package leetcode.medium._046_permutations

import extensions.math.permutations

/**
 * 46 - https://leetcode.com/problems/permutations/
 */
class Solution {
    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun permute(nums: IntArray): List<List<Int>> = nums.permutations()
}

class SolutionTwo {
    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun permute(nums: IntArray): List<List<Int>> = when (nums.size) {
        0 -> listOf(emptyList())
        1 -> listOf(listOf(nums[0]))
        else -> {
            val permutations: MutableList<List<Int>> = arrayListOf()
            (0..nums.lastIndex).forEach { i ->
                val others = (nums.take(i) + nums.drop(i + 1)).toIntArray() // All elements except nums[i]
                permutations += permute(others).map {
                    listOf(nums[i]) + it
                }
            }
            permutations
        }
    }
}