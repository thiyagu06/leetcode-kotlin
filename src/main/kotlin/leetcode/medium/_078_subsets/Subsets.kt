package leetcode.medium._078_subsets

/**
 * 78 - https://leetcode.com/problems/subsets/description/
 */
class Solution {
    /**
     * Iterative appending algorithm
     * Time: O(2^n)
     * Space: O(n)
     */
    fun subsets(nums: IntArray): List<List<Int>> {
        val powerSet: MutableList<List<Int>> = arrayListOf()
        powerSet.add(emptyList())  // add null set

        (0 until nums.size).forEach { i ->
            val sublistsPlusCurrent = powerSet.map { it + nums[i] }
            powerSet += sublistsPlusCurrent
        }

        return powerSet
    }
}

class SolutionTwo {
    /**
     * Iterative appending algorithm, using fold
     * Time: O(2^n)
     * Space: O(n)
     */
    fun subsets(nums: IntArray): List<List<Int>> {
        val powerSet: MutableList<List<Int>> = arrayListOf(emptyList()) // contains only the null set {{}}
        return nums.fold(powerSet) { acc, n ->
            acc.apply {
                acc += acc.map { it + n }
            }
        }
    }
}

class SolutionThree {
    /**
     * Recursive version of the Iterative one
     * Time: O(2^n)
     * Space: O(n)
     */
    fun subsets(nums: IntArray): List<List<Int>> = when {
        nums.isEmpty() -> arrayListOf(emptyList())
        else -> {
            val prevPowerSets = subsets(nums.sliceArray(0 until nums.lastIndex))
            prevPowerSets + prevPowerSets.map { it + nums.last() }
        }

    }
}

class SolutionFour {
    /**
     * Recursive implementation - mapping first onto tail power sets instead of
     * last onto prev. power sets.
     * Time: O(2^n)
     * Space: O(n)
     */
    fun subsets(nums: IntArray): List<List<Int>> {
        return powerSet(nums.toSet())
            .asSequence()
            .map { it.toList() }
            .toList()
    }

    private fun <T> powerSet(set: Set<T>): Set<Set<T>> = when {
        set.isEmpty() -> setOf(setOf())
        else -> {
            val tailPowerSet = powerSet(set.asSequence().drop(1).toSet())
            tailPowerSet + tailPowerSet.map { setOf(set.first()) + it }
        }
    }
}


class SolutionFive {
    /**
     * Backtracking (1 of 2)
     *
     * Time: O(2^n)
     * Space: O(n)
     */
    fun subsets(nums: IntArray): List<List<Int>> {
        val powerSet: MutableList<List<Int>> = arrayListOf()
        generateSubsets(nums.toList(), arrayListOf(), powerSet)
        return powerSet
    }

    private fun generateSubsets(
        nums: List<Int>,
        subset: List<Int> = arrayListOf(),
        powerSet: MutableList<List<Int>>
    ) {
        when {
            nums.isEmpty() -> powerSet += subset
            else -> {
                generateSubsets(nums.drop(1), (subset + nums.first()), powerSet)    // include
                generateSubsets(nums.drop(1), subset, powerSet)                     // don't include
            }
        }
    }
}

class SolutionSix {
    /**
     * Backtracking
     *
     * Time: O(2^n)
     * Space: O(n)
     */
    fun subsets(nums: IntArray): List<List<Int>> {
        val powerSet = mutableListOf<List<Int>>()
        backtrack(nums.toList(), 0, mutableListOf(), powerSet)
        return powerSet
    }

    private fun backtrack(
        nums: List<Int>,
        startIdx: Int,
        sublist: MutableList<Int>,
        powerSet: MutableList<List<Int>>,
        depth: Int = 0
    ) {
        // We want to add the elements in sublist to the powerSet, but we don't want
        // to add sublist itself into the powerSet since it is mutable
        powerSet.add(sublist.toList())

        for (i in (startIdx..nums.lastIndex)) {
            backtrack(nums, i + 1, (sublist + nums[i]).toMutableList(), powerSet, depth + 1)
        }
    }
}

class SolutionSeven {
    /**
     * Backtracking - same as [SolutionSix], but without `startIdx` param
     * (uses more space, but more readable)
     *
     * Time: O(2^n)
     * Space: O(n)
     */
    fun subsets(nums: IntArray): List<List<Int>> {
        val powerSet = mutableListOf<List<Int>>()
        backtrack(nums.toList(), mutableListOf(), powerSet)
        return powerSet
    }

    private fun backtrack(
        nums: List<Int>,
        sublist: MutableList<Int>,
        powerSet: MutableList<List<Int>>
    ) {
        // We want to add the elements in sublist to the powerSet, but we don't want
        // to add sublist itself into the powerSet since it is mutable
        powerSet.add(sublist.toList())

        nums.forEachIndexed { i, num ->
            // nums.drop(i + 1): nums[i:]
            backtrack(
                nums = nums.drop(i + 1),
                sublist = (sublist + num).toMutableList(),  // add current num to sublist, which will be added to solution
                powerSet = powerSet
            )
        }
    }
}

class SolutionEight {
    /**
     * Backtracking - same as prev., but without `startIdx` param
     * (uses more space, but more readable)
     *
     * Time: O(2^n)
     * Space: O(n)
     */
    fun subsets(nums: IntArray): List<List<Int>> {
        val powerSet = mutableListOf<List<Int>>()
        dfs(nums, 0, mutableListOf(), powerSet)
        return powerSet
    }

    private fun dfs(
        nums: IntArray,
        index: Int,
        sublist: MutableList<Int>,
        powerSet: MutableList<List<Int>>
    ) {
        if (index > nums.lastIndex) {
            powerSet += sublist.toList()
            return
        }

        /* Don't include the number */
        dfs(nums, index + 1, sublist, powerSet)

        /* Include the number */
        sublist.add(nums[index])
        dfs(nums, index + 1, sublist, powerSet)
        sublist.removeAt(sublist.lastIndex) // undo
    }
}
