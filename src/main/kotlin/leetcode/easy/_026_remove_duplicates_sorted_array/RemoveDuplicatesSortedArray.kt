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
        if (nums.size < 2) return nums.size

        var insertIndex = 0
        for (i in nums.indices) {
            if (i > 0 && nums[i] != nums[insertIndex]) {
                nums[++insertIndex] = nums[i]
            }
        }
        return insertIndex + 1
    }
}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size < 2) return nums.size

        var insertIndex = 1
        (1..nums.lastIndex).forEach { i ->
            if (nums[i] != nums[i - 1]) {
                nums[insertIndex++] = nums[i]
            }
        }
        return insertIndex
    }
}

class SolutionThree {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun removeDuplicates(nums: IntArray): Int {
        var insertIndex = if (nums.isNotEmpty()) 1 else 0

        for (i in nums.indices) {
            if (nums[i] > nums[insertIndex - 1]) {
                nums[insertIndex++] = nums[i]
            }
        }
        return insertIndex
    }
}
