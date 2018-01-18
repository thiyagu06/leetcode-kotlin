package algorithms.medium._031_next_permutation

import extensions.arrays.isSortedDescending
import extensions.arrays.swap

/**
 * 31 - https://leetcode.com/problems/next-permutation/description/
 */
class Solution {
    /**
     * TODO - Review
     * Time: O(?)
     * Space: O(?)
     */
    fun nextPermutation(nums: IntArray) {
        if (nums.isEmpty()) return
        if (nums.isLastPermutation()) {
            nums.reverse()
            return
        }

        var i = nums.lastIndex
        while (nums[i] <= nums[i - 1]) i--

        var j = nums.size
        while (nums[j - 1] <= nums[i - 1]) j--

        nums.swap(i - 1, j - 1)

        i++
        j = nums.size
        while (i < j) {
            nums.swap(i - 1, j - 1)
            i++
            j--
        }
    }

    private fun IntArray.isLastPermutation(): Boolean = isSortedDescending()
}