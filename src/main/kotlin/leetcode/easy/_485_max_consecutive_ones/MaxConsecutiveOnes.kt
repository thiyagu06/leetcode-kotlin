package leetcode.easy._485_max_consecutive_ones

import kotlin.math.max

/**
 * 485 - https://leetcode.com/problems/max-consecutive-ones/
 */
class Solution {
    /**
     * Using Sliding Window Technique
     * Time: O(n)
     * Space: O(1)
     */
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var l = 0
        var r = 0
        var maxOnes = 0

        while (r < nums.size) {
            when (nums[r]) {
                // If rightmost element in window is 1, expand
                1 -> {
                    maxOnes = max(maxOnes, r - l + 1)
                    r++
                }
                // If 0, whole window is invalidated.
                0 -> {
                    r++
                    l = r
                }
            }
        }

        return maxOnes
    }
}

class SolutionTwo {
    /**
     * Uses Kadane's algorithm (slightly modified)
     * Time: O(n)
     * Space: O(1)
     */
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var maxEndingHere = if (nums[0] == 0) 0 else 1
        var globalMax = maxEndingHere

        for (i in 1..nums.lastIndex) {
            maxEndingHere = if (nums[i] == 1) maxEndingHere + 1 else 0
            globalMax = max(globalMax, maxEndingHere)
        }

        return globalMax
    }
}
