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
        return powerSet(nums.toSet()).map { it.toList() }.toList()
    }

    private fun <T> powerSet(set: Set<T>): Set<Set<T>> = when {
        set.isEmpty() -> setOf(setOf())
        else -> {
            val tailPowerSet = powerSet(set.drop(1).toSet())
            tailPowerSet + tailPowerSet.map { setOf(set.first()) + it }
        }
    }
}

class SolutionFive {
    /**
     * TODO
     * Time: O(2^n)
     * Space: O(n)
     */
    fun subsets(nums: IntArray): List<List<Int>> {
        TODO()
    }
}
