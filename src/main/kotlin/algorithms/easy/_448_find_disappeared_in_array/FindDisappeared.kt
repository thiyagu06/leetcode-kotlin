package algorithms.easy._448_find_disappeared_in_array

import extensions.valueToIndicesMap

/**
 * 448 - https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 */
class Solution {
    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val valueToIndices = nums.valueToIndicesMap()

        return (1..nums.size).fold(emptyList()) { acc, n ->
            if (!valueToIndices.containsKey(n)) acc + n else acc
        }
    }
}
