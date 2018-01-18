package algorithms.easy._283_move_zeroes

import extensions.arrays.swap

/**
 * 283 - https://leetcode.com/problems/move-zeroes/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun moveZeroes(nums: IntArray) {
        nums.withIndex().forEach { (i, n) ->
            if (n == 0) {
                var j = i + 1
                while (j <= nums.lastIndex && nums[j] == 0)
                    j++

                if (j > nums.lastIndex) return

                nums.swap(i, j)
            }
        }
    }
}