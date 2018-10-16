package leetcode.medium._046_permutations

import extensions.math.permutations

/**
 * 46 - https://leetcode.com/problems/permutations/
 */
class Solution {
    /**
     * Time: O(n!)
     * Space: O(?)
     */
    fun permute(nums: IntArray): List<List<Int>> = nums.permutations()
}

class SolutionTwo {
    /**
     * Time: O(n!)
     * Space: O(n)
     */
    fun permute(nums: IntArray): List<List<Int>> = when (nums.size) {
        0 -> listOf(emptyList())
        1 -> listOf(listOf(nums[0]))
        2 -> listOf(nums.toList(), listOf(nums[1], nums[0]))
        else -> nums.fold(listOf()) { acc, num ->
            val otherElements = nums.filter { it != num }.toIntArray()
            acc + permute(otherElements).map {
                it + num
            }
        }
    }
}