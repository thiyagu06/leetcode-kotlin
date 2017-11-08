package algorithms.easy._001_twosum

import extensions.toIntArray

/**
 * 1.
 * https://leetcode.com/problems/two-sum/description/
 *
 * Time: O(n)
 * Space: O(n)
 *
 * @author nrojiani
 * @date 11/7/17
 */
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numsIndexed = mutableMapOf<Int, Int>()  /* Map of n => index */
        for ((i, n) in nums.withIndex()) {
            val complement = target - n
            if (numsIndexed.contains(complement)) {
                return Pair(numsIndexed[complement]!!, i).toIntArray()
            }
            numsIndexed[n] = i
        }
        throw IllegalArgumentException("No pair sum == target")
    }
}