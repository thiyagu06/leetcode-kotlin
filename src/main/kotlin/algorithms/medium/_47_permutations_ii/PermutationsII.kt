package algorithms.medium._47_permutations_ii

import extensions.math.permutations

/**
 * 47 - https://leetcode.com/problems/permutations-ii/description/
 */
class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> = nums.permutations().distinct()
}