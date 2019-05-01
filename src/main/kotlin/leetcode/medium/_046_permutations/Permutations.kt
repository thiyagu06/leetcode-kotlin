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
    fun permute(nums: IntArray): List<List<Int>> = nums.toList().permutations().toList()
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
        else -> {
            val permutations: MutableList<List<Int>> = ArrayList()
            nums.forEachIndexed { i, e ->
                val otherElements = nums.take(i) + nums.drop(i + 1)
                permute(otherElements.toIntArray())
                    .map { it + e }
                    .forEach { permutations += it }
            }
            permutations
        }
    }
}