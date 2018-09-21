package leetcode.easy._268_missing_number

import extensions.arrays.frequencyMap
import extensions.math.sumOfFirstNPositiveIntegers
import java.lang.IllegalArgumentException

/**
 * 268 - https://leetcode.com/problems/missing-number/description/
 */
class Solution {
    /**
     * Sort the array, then check
     *
     * Time: O(n log n)
     * Space: O(1)
     */
    fun missingNumber(nums: IntArray): Int {
        nums.sort()
        nums.forEachIndexed { i, n ->
            if (n != i)
                return i
        }

        return nums.size
    }
}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun missingNumber(nums: IntArray): Int {
        val numbers = nums.distinct()
        val n = nums.size
        (0..n).forEach { i ->
            if (!numbers.contains(i))
                return i
        }
        throw IllegalArgumentException("Input has no missing numbers in range 0..n")
    }
}

class FollowUpSolution {
    /**
     * Time: O(n) - for nums.sum()
     * Space: O(1)
     */
    fun missingNumber(nums: IntArray): Int = sumOfFirstNPositiveIntegers(nums.size) - nums.sum()
}