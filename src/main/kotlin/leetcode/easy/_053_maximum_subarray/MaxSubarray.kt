package leetcode.easy._053_maximum_subarray

/**
 * 53 - https://leetcode.com/problems/maximum-subarray/description/
 */
class Solution {
    /**
     * TODO
     * Time: O(?)
     * Space: O(?)
     */
    fun maxSubArray(nums: IntArray): Int {
        val maxSub = IntArray(nums.size)
        maxSub[0] = nums[0]
        var max = maxSub[0]

        /* Sum all possible subarrays */
        (1..nums.lastIndex).forEach { i ->
            maxSub[i] = (if (maxSub[i - 1] > 0) maxSub[i - 1] else 0) + nums[i]
            max = maxOf(max, maxSub[i])
        }

        return max
    }
}

class Solution2 {
    /**
     * TODO
     * Time: O(?)
     * Space: O(?)
     */
    fun maxSubArray(nums: IntArray): Int =
            (0 until nums.size).fold(emptyList<Int>()) { sums, i ->
                sums + (i until nums.size).map { j ->
                    (i..j).sumBy { index -> nums[index] }
                }
            }.max()!!
}

class DPSolution {
    /**
     * TODO
     * Time: O(?)
     * Space: O(?)
     */
    fun maxSubArray(nums: IntArray): Int {
        val n = nums.size
        val maxSub = IntArray(n)
        maxSub[0] = nums[0]
        var max = maxSub[0]

        for (i in 1..nums.lastIndex) {
            maxSub[i] = (if (maxSub[i - 1] > 0) maxSub[i - 1] else 0) + nums[i]
            max = maxOf(max, maxSub[i])
        }

        return max
    }
}
