package leetcode.easy._283_move_zeroes

import extensions.arrays.swap

/**
 * 283 - https://leetcode.com/problems/move-zeroes/description/
 */
class Solution {
    /**
     * Time: O(n^2)
     * Space: O(1)
     */
    fun moveZeroes(nums: IntArray) {
        nums.indices.forEach { i ->
            if (nums[i] == 0) {
                var j = i + 1
                while (j <= nums.lastIndex && nums[j] == 0)
                    j++

                if (j > nums.lastIndex) return

                nums.swap(i, j)
            }
        }
    }
}

class SolutionTwo {
    /**
     * Optimal
     *
     * Time: O(n)
     * Space: O(1)
     */
    fun moveZeroes(nums: IntArray) {
        if (nums.isEmpty()) return

        var insertIdx = 0
        nums.forEach { num ->
            if (num != 0) {
                nums[insertIdx++] = num
            }
        }

        (insertIdx..nums.lastIndex).forEach { i ->
            nums[i] = 0
        }
    }
}

class SolutionThree {
    /**
     * Optimal
     *
     * Time: O(n)
     * Space: O(1)
     */
    fun moveZeroes(nums: IntArray) {
        var swapIdx = 0
        nums.indices.forEach { i ->
            if (nums[i] != 0) {
                if (i == swapIdx) swapIdx++
                else nums.swap(swapIdx++, i)
            }
        }
    }
}