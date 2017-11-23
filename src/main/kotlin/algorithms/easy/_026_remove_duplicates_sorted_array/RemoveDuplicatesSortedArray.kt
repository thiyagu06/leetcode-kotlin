package algorithms.easy._026_remove_duplicates_sorted_array

/**
 * 26 - https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * @author nrojiani
 * @date 11/9/17
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var comparisonIdx = 0
        for ((i, n) in nums.withIndex()) {
            if (i == 0 || n == nums[comparisonIdx]) {
                continue
            }

            nums[++comparisonIdx] = n
        }
        return comparisonIdx + 1
    }
}