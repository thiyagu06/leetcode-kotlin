package leetcode.medium._047_permutations_ii

import extensions.math.permutations

/**
 * 47 - https://leetcode.com/problems/permutations-ii/
 */
class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> = nums.permutations().distinct()
}