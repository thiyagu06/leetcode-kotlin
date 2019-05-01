package leetcode.easy._674_longest_continuous_increasing_sub

import kotlin.math.max

/**
 * 674 - https://leetcode.com/problems/longest-continuous-increasing-subsequence
 */
class Solution {
    /**
     * Brute-force algorithm (accepted)
     * Time: O(n^2)
     * Space: O(1)
     */
    fun findLengthOfLCIS(nums: IntArray): Int {
        var maxLength = 0
        for (i in 0..nums.lastIndex) {
            var j = i + 1
            while (j <= nums.lastIndex && nums[j] > nums[j - 1])
                j++
            maxLength = max(maxLength, j - i)
        }

        return maxLength
    }
}

class SolutionTwo {
    /**
     * Sliding-Window Technique
     * Time: O(n)
     * Space: O(1)
     */
    fun findLengthOfLCIS(nums: IntArray): Int {
        if (nums.size < 2) return nums.size

        var l = 0
        var r = 1
        var maxLength = 1

        while (r <= nums.lastIndex) {
            when {
                l == r || nums[r] > nums[r - 1] -> {
                    maxLength = max(maxLength, r - l + 1)   // r - l + 1 = window length
                    r++
                }
                else -> l = r // reset window
            }
        }

        return maxLength
    }
}

class SolutionThree {
    /**
     * Same concept as the above Sliding-Window algorithm.
     * Time: O(n)
     * Space: O(1)
     */
    fun findLengthOfLCIS(nums: IntArray): Int {
        if (nums.size < 2) return nums.size

        var currentLength = 1
        var maxLength = 0
        (1..nums.lastIndex).forEach { i ->
            if (nums[i] > nums[i - 1]) currentLength++
            else currentLength = 1
            maxLength = max(maxLength, currentLength)
        }

        return maxLength
    }
}