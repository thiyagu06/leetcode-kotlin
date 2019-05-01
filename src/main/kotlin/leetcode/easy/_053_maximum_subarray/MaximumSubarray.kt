package leetcode.easy._053_maximum_subarray

import kotlin.math.max

/**
 * 53 - https://leetcode.com/problems/maximum-subarray/
 */
class Solution {
    /**
     * Brute-force solution
     * Time: O(n^2)
     * Space: O(1)
     */
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = nums[0]
        for (i in 0..nums.lastIndex) {
            var runningSum = 0
            for (j in i..nums.lastIndex) {
                runningSum += nums[j]
                maxSum = max(maxSum, runningSum)
            }
        }
        return maxSum
    }
}

class SolutionTwo {
    /**
     * Using the Sliding Window Technique.
     *
     * Time: O(n^2)
     * Space: O(1)
     */
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = Int.MIN_VALUE
        for (k in 1..nums.size) {
            val maxSumK = nums.maxSubarraySumOfSize(k)
            maxSum = max(maxSum, maxSumK)
        }
        return maxSum
    }

    /**
     * Calculates the max subarray sum for subarrays of size [k].
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

class SolutionThree {
    /**
     * [Kadane's Algorithm](https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane's_algorithm)
     * Time: O(n)
     * Space: O(1)
     */
    fun maxSubArray(nums: IntArray): Int {
        var globalMax = nums[0]
        var maxEndingHere = nums[0]

        for (i in 1..nums.lastIndex) {
            maxEndingHere = max(nums[i], maxEndingHere + nums[i])
            globalMax = max(globalMax, maxEndingHere)
        }

        return globalMax
    }
}

class DPSolution {
    /**
     * Using Dynamic Programming.
     *
     * Time: O(n)
     * Space: O(1)
     */
    fun maxSubArray(nums: IntArray): Int {
        val maxes = IntArray(nums.size)     /* maxes[i]: The max subarray sum ending at index i */
        maxes[0] = nums[0]
        var globalMax = nums[0]

        for (i in 1..nums.lastIndex) {
            maxes[i] = max(maxes[i - 1] + nums[i], nums[i])
            globalMax = max(globalMax, maxes[i])
        }

        return globalMax
    }
}

class DPSolutionOptimized {
    /**
     * Dynamic Programming optimized to use constant space => is Kadane's algorithm
     *
     * Time: O(n)
     * Space: O(1)
     */
    fun maxSubArray(nums: IntArray): Int {
        var iMax = nums[0]
        var globalMax = nums[0]

        for (i in 1..nums.lastIndex) {
            iMax = max(iMax + nums[i], nums[i])
            globalMax = max(globalMax, iMax)
        }

        return globalMax
    }
}
