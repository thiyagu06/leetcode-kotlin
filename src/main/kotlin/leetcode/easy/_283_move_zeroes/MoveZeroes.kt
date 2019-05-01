package leetcode.easy._283_move_zeroes

import extensions.arrays.swap

/**
 * 283 - https://leetcode.com/problems/move-zeroes/
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
                while (j <= nums.lastIndex && nums[j] == 0) j++

                if (j <= nums.lastIndex)
                    nums.swap(i, j)
            }
        }
    }
}

class SolutionTwo {
    /**
     * Time: O(n^2)
     * Space: O(1)
     */
    fun moveZeroes(nums: IntArray) {
        var r = 0
        nums.indices.forEach { l ->
            if (nums[l] == 0) {
                r = l + 1
                while (r <= nums.lastIndex && nums[r] == 0) r++
                if (r <= nums.lastIndex) nums.swap(l, r)
            }
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

class SolutionFour {
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
                if (i != swapIdx) nums.swap(swapIdx, i)
                swapIdx++
            }
        }
    }
}