package leetcode.medium._090_subsets_ii

class Solution {
    /**
     * Approach: Sort, then if is duplicate, only map onto the
     * subsets added during the last iteration.
     *
     * Time: O(2^n)
     * Space: O(n)
     */
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        val powerSet: MutableList<List<Int>> = arrayListOf()
        powerSet.add(emptyList())  // add null set
        var lastIterationSubsets: List<List<Int>> = arrayListOf()

        for (i in nums.indices) {
            lastIterationSubsets = if (i > 0 && nums[i] == nums[i - 1]) {
                lastIterationSubsets.map { it + nums[i] }
            } else {
                powerSet.map { it + nums[i] }
            }
            powerSet.addAll(lastIterationSubsets)
        }

        return powerSet
    }
}

class SolutionTwo {
    /**
     * TODO
     * Backtracking
     *
     * Time: O(2^n)
     * Space: O(n)
     */
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        TODO()
    }
}
/*
import java.util.*

class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)
        val result = mutableListOf<List<Int>>()
        val book = BooleanArray(nums.size)
        dfs(nums, 0, book, result, mutableListOf())
        return result
    }

    fun dfs(nums: IntArray, pos: Int, book: BooleanArray, result: MutableList<List<Int>>, solution: MutableList<Int>) {
        result.add(ArrayList<Int>(solution))
        for (i in pos until nums.size) {
            if (i > 0 && nums[i] == nums[i - 1] && !book[i - 1]) {
                continue
            }
            book[i] = true
            solution.add(nums[i])
            dfs(nums, i + 1, book, result, solution)
            solution.removeAt(solution.lastIndex)
            book[i] = false
        }
    }
}
 */
