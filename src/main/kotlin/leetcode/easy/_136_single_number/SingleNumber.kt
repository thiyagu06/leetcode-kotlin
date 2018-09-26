package leetcode.easy._136_single_number

import extensions.arrays.groupingBy

/**
 * 136 - https://leetcode.com/problems/single-number/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun singleNumber(nums: IntArray): Int = nums.groupingBy { it }
        .eachCount()
        .entries
        .single { (_, freq) -> freq == 1 }
        .key
}

class SolutionTwo {
    /**
     * Approach: Use Math.
     * (2 * (a + b + c)) - (a + a + b + b + c) = c
     * (2 * sum of distinct elements) - (sum of all elements) = c
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun singleNumber(nums: IntArray): Int = (2 * nums.toSet().sum()) - nums.sum()
}


