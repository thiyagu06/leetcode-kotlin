package leetcode.easy._026_remove_duplicates_sorted_array

/**
 * 26 - https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var comparisonIdx = 0
        nums.forEachIndexed { i, n ->
            if (i == 0 || n == nums[comparisonIdx]) {
                return@forEachIndexed
            }

            nums[++comparisonIdx] = n
        }
        return comparisonIdx + 1
    }
}
