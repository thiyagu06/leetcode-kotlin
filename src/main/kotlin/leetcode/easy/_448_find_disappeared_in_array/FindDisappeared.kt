package leetcode.easy._448_find_disappeared_in_array

import extensions.arrays.valueToIndicesMap
import kotlin.math.abs

/**
 * 448 - https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val valueToIndices = nums.valueToIndicesMap()

        return (1..nums.size).fold(emptyList()) { acc, n ->
            if (!valueToIndices.containsKey(n)) acc + n else acc
        }
    }
}

/**
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list (the input list?) does not count as extra space.
 */
class FollowUpSolution {
    /**
     * Time: O(n)
     * Space: O(1) - "You may assume the returned list does not count as extra space"
     */
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        nums.forEach { num ->
            val mappedIndex = abs(num) - 1
            if (nums[mappedIndex] > 0) {
                nums[mappedIndex] *= -1
            }
        }

        return nums.foldIndexed(emptyList()) { index, acc, num ->
            if (num > 0) acc + (index + 1)
            else acc
        }
    }
}
