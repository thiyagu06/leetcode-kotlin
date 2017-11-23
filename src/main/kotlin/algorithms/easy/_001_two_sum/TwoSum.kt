package algorithms.easy._001_two_sum

import extensions.toIntArray

/**
 * 1.
 * https://leetcode.com/problems/two-sum/description/
 *
 * @author nrojiani
 * @date 11/7/17
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
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