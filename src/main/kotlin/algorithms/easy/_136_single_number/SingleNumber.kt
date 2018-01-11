package algorithms.easy._136_single_number

/**
 * 136 - https://leetcode.com/problems/single-number/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun singleNumber(nums: IntArray): Int = nums.groupBy { it }
            .map { (key, values) -> key to values.count() }
            .single { (_, count) -> count == 1 }
            .first

}

class ConstantSpaceSolution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun singleNumber(nums: IntArray): Int {
        // Bit Manipulation
        TODO()
    }

}
