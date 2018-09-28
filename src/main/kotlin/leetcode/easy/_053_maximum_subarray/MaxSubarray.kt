package leetcode.easy._053_maximum_subarray

import kotlin.math.max

/**
 * 53 - https://leetcode.com/problems/maximum-subarray/
 */
class Solution {
    /**
     * Brute-force solution
     * Time: O(n^3) ?
     * Space: O(?)
     */
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = Int.MIN_VALUE        // Assume size >= 1
        (1..nums.size).forEach { k ->
            (0 until (nums.size - k + 1)).forEach { i ->
                var subarraySum = 0
                (i until (i + k)).forEach { j ->
                    subarraySum += nums[j]
                }
                maxSum = max(maxSum, subarraySum)
            }
        }

        return maxSum
    }
}

class SolutionTwo {
    /**
     * Kadane's Algorithm - https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane's_algorithm
     * Time: O(n)
     * Space: O(1)
     */
    fun maxSubArray(nums: IntArray): Int {
        var maxSoFar = nums[0]
        var maxEndingHere = nums[0]

        (1..nums.lastIndex).forEach { i ->
            maxEndingHere = max(nums[i], maxEndingHere + nums[i])
            maxSoFar = max(maxSoFar, maxEndingHere)
        }

        return maxSoFar
    }
}

class SolutionThree {
    /**
     * Sliding Window
     * Time: O(n^2)
     * Space: O(1)
     */
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = Int.MIN_VALUE
        (1..nums.size).forEach { k ->
            val maxSumK = nums.maxSubarraySumOfSize(k)
            maxSum = max(maxSum, maxSumK)
        }
        return maxSum
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    private fun IntArray.maxSubarraySumOfSize(k: Int): Int {
        var maxSum: Int

        /* Calculate sum of 1st window */
        var windowSum = 0
        (0 until k).forEach { i ->
            windowSum += this[i]
        }
        maxSum = windowSum

        /* Slide window from start to end in array. Here i is the last element in the current window. */
        (k until size).forEach { i ->
            windowSum += this[i] - this[i - k]
            maxSum = max(maxSum, windowSum)
        }

        return maxSum
    }
}

class SolutionFour {
    /**
     * TODO
     * Time: O(?)
     * Space: O(?)
     */
    fun maxSubArray(nums: IntArray): Int {
        val maxSub = IntArray(nums.size)
        maxSub[0] = nums[0]
        var max = maxSub[0]

        /* Sum all possible subarrays */
        (1..nums.lastIndex).forEach { i ->
            maxSub[i] = (if (maxSub[i - 1] > 0) maxSub[i - 1] else 0) + nums[i]
            max = maxOf(max, maxSub[i])
        }

        return max
    }
}

class DPSolution {
    /**
     * TODO
     * Time: O(?)
     * Space: O(?)
     */
    fun maxSubArray(nums: IntArray): Int {
        val n = nums.size
        val maxSub = IntArray(n)
        maxSub[0] = nums[0]
        var max = maxSub[0]

        for (i in 1..nums.lastIndex) {
            maxSub[i] = (if (maxSub[i - 1] > 0) maxSub[i - 1] else 0) + nums[i]
            max = maxOf(max, maxSub[i])
        }

        return max
    }
}
