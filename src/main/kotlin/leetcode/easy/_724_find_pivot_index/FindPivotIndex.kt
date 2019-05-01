package leetcode.easy._724_find_pivot_index

/**
 * 724 - https://leetcode.com/problems/find-pivot-index
 */
class Solution {
    /**
     * Brute Force
     * Time: O(N * N)
     * Space: O(1)
     */
    fun pivotIndexBruteForce(nums: IntArray): Int {
        (0..nums.lastIndex).forEach { index ->
            val leftSum = nums.slice(0 until index).sum()
            val rightSum = nums.slice((index + 1)..nums.lastIndex).sum()

            if (leftSum == rightSum) {
                return index
            }
        }
        return -1
    }

    /**
     * Time: O(N), where N is the length of `nums`
     * Space: O(1)
     */
    fun pivotIndex(nums: IntArray): Int {
        val sum = nums.sum()
        var leftSum = 0
        var rightSum = sum

        (0..nums.lastIndex).forEach { index ->
            if (index > 0)
                leftSum += nums[index - 1]

            rightSum -= nums[index]

            if (leftSum == rightSum) {
                return index
            }
        }
        return -1
    }
}
