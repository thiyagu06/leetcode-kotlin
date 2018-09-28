package leetcode.medium._152_max_product_subarray

import extensions.math.minOf
import kotlin.math.max
import kotlin.math.min

class Solution {
    /**
     * Time: O(n^2)
     * Space: O(1)
     */
    fun maxProduct(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var maxProduct = Int.MIN_VALUE
        for (k in (1..nums.size)) {
            val kMaxProduct = maxProductSubarray(nums, k)
            maxProduct = max(maxProduct, kMaxProduct)
        }

        return maxProduct
    }

    /**
     * Sliding Window
     *
     * Time: O(n)
     * Space: O(1)
     */
    internal fun maxProductSubarray(nums: IntArray, k: Int): Int {
        require(k <= nums.size) { "Invalid k: $k for array with size: ${nums.size}" }
        if (nums.isEmpty()) return 0

        var maxProduct: Int
        var windowProduct = 1

        for (i in (0 until k)) {
            windowProduct *= nums[i]
        }
        maxProduct = windowProduct

        for (i in (k until nums.size)) {
            if (nums[i - k] != 0) {
                windowProduct = (windowProduct * nums[i]) / nums[i - k]
            } else {
                // can't divide by 0
                var j = 0
                windowProduct = 1
                while (j < k) {
                    windowProduct *= nums[i - j]
                    j++
                }
            }
            maxProduct = max(maxProduct, windowProduct)
        }

        return maxProduct
    }
}

class SolutionTwo {
    /**
     * Kadane's Algorithm
     * Time: O(n)
     * Space: O(1)
     */
    fun maxProduct(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var localMax = nums[0]
        var localMin = nums[0]
        var maxProduct = nums[0]
        var minProduct = nums[0]

        (1..nums.lastIndex).forEach { i ->
            // also { } uses the original localMax, so that we don't need to make a temp copy.
            // otherwise localMin would use the updated localMax in its calculation
            localMax = maxOf(nums[i], localMax * nums[i], localMin * nums[i])
                .also { localMin = minOf(nums[i], localMin * nums[i], localMax * nums[i]) }

            maxProduct = max(maxProduct, localMax)
            minProduct = min(minProduct, localMin)
        }

        return maxProduct
    }
}