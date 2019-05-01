package leetcode.medium._300_longest_increasing_subsequence

import kotlin.math.max

/**
 * 300 - https://leetcode.com/problems/longest-increasing-subsequence
 */
class Solution {
    /**
     * Time: O(n^2)
     * Space: O(n)
     */
    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.size < 2) return nums.size

        val maxEndingAt = IntArray(nums.size)    // maxEndingAt[i] = the LIS for nums[0..i]
        var globalMax = 0

        for (i in nums.indices) {
            maxEndingAt[i] = 1
            for (k in 0 until i) {
                if (nums[i] > nums[k]) {
                    maxEndingAt[i] = max(maxEndingAt[i], maxEndingAt[k] + 1)
                }
            }
            globalMax = max(globalMax, maxEndingAt[i])
        }

        return globalMax
    }
}

// TODO - Follow up: Could you improve it to O(n log n) time complexity?