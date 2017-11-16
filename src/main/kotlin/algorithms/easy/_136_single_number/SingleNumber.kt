package algorithms.easy._136_single_number

/**
 * 136 - https://leetcode.com/problems/single-number/description/
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * @author nrojiani
 * @date 11/14/17
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