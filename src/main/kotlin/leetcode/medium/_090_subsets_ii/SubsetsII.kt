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

        for (i in (0..nums.lastIndex)) {
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
