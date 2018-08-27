package algorithms.easy._643_max_avg_subarray_I

/**
 * 643 - https://leetcode.com/problems/maximum-average-subarray-i/description/
 */
class Solution {
    /**
     * Time: O(n * k)
     * Space: O(n)
     */
    fun findMaxAverage(nums: IntArray, k: Int): Double =
        (0..(nums.size - k)).fold(arrayListOf<Double>()) { acc, startIndex ->
            val subarrayRange = (startIndex until (startIndex + k))
            acc.apply {
                acc.add((subarrayRange.sumBy { nums[it] }.toDouble()) / k.toDouble())
            }
        }.max()!!
}

class Solution2 {
    /**
     * Cumulative Sum method
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        val cumulativeSums = IntArray(nums.size)
        (0..nums.lastIndex).forEach { i->
            when (i) {
                0 -> cumulativeSums[0] = nums[0]
                else -> cumulativeSums[i] = cumulativeSums[i - 1] + nums[i]
            }
        }

        var maxAvg = cumulativeSums[k - 1] / k.toDouble()   // for when k = nums.size
        (k until nums.size).forEach { i ->
            val subarraySum = cumulativeSums[i] - cumulativeSums[i - k]
            val subarrayAvg = subarraySum / k.toDouble()
            maxAvg = maxOf(maxAvg, subarrayAvg)
        }

        return maxAvg
    }
}
