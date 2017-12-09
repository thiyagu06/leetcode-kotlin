package algorithms.easy._448_find_disappeared_in_array

import extensions.valueToIndicesMap

/**
 * 448 - https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
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
     * Space: O(1)
     *
     * See https://discuss.leetcode.com/topic/65738/java-accepted-simple-solution
     */
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        nums.forEach { n ->
            val indexMapping = Math.abs(n) - 1
            if (nums[indexMapping] > 0) {
                nums[indexMapping] = -(nums[indexMapping])
            }
        }

        return nums.withIndex().fold(emptyList()) { acc, (index, n) ->
            if (n > 0) {
                acc + (index + 1)
            } else {
                acc
            }
        }
    }
}
