package leetcode.easy._268_missing_number

import extensions.math.sumOfFirstNPositiveIntegers

/**
 * 268 - https://leetcode.com/problems/missing-number/
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

class FollowUpSolution2 {
    /**
     * Bit Manipulation
     * Time: O(n)
     * Space: O(1)
     */
    fun missingNumber(nums: IntArray): Int {
        var missing = nums.size
        for ((i, n) in nums.withIndex()) {
            missing = missing xor n
            missing = missing xor i
        }
        return missing
    }
}

class FollowUpSolution3 {
    /**
     * Bit Manipulation
     * Time: O(n)
     * Space: O(1)
     */
    fun missingNumber(nums: IntArray): Int =
        nums.foldIndexed(nums.size) { index, acc, n ->
            acc xor (index xor n)
        }
}