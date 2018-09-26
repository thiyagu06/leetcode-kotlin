package leetcode.medium._611_valid_triangle_number

/**
 * 611 - https://leetcode.com/problems/valid-triangle-number/
 */
class Solution {
    fun triangleNumber(nums: IntArray): Int {
        if (nums.size < 3) return 0

        nums.sort()
        var count = 0
        (nums.lastIndex downTo 2).forEach { i ->
            // nums[leftIdx] = a, nums[rightIdx] = b, nums[i] = c
            var leftIdx = 0
            var rightIdx = i - 1
            while (leftIdx < rightIdx) {
                if (nums[leftIdx] + nums[rightIdx] > nums[i]) {
                    count += rightIdx - leftIdx
                    rightIdx -= 1
                } else {
                    leftIdx += 1
                }
            }
        }
        return count
    }
}