package leetcode.medium._487_max_consecutive_ones_ii

import kotlin.math.max

/**
 * 487 - https://leetcode.com/problems/max-consecutive-ones-ii
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
        var zeroesInWindow = 0
        var zeroIndex = 0

        while (r < nums.size) {
            when {
                // If rightmost element in window is 1, expand
                nums[r] == 1 -> {
                    maxOnes = max(maxOnes, r - l + 1)
                    r++
                }

                // if 0, but can flip it, expand
                nums[r] == 0 && zeroesInWindow == 0 -> {
                    zeroesInWindow++
                    zeroIndex = r
                    maxOnes = max(maxOnes, r - l + 1)
                    r++
                }

                // If 0 and already flipped a zero, evict up to and including the first zero.
                nums[r] == 0 && zeroesInWindow >= 1 -> {
                    l = zeroIndex + 1       // new start of window is after first zero
                    zeroIndex = r           // mark r as the index of the zero
                    zeroesInWindow = 1      // we removed the first zero but still have the zero at nums[r]
                    r++
                }
            }
        }

        return maxOnes
    }
}