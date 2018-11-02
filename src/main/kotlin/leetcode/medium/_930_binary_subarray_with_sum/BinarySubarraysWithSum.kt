package leetcode.medium._930_binary_subarray_with_sum

/**
 * 930 - https://leetcode.com/problems/binary-subarrays-with-sum/description/
 */
class Solution {
    /**
     * Brute-Force (Time Limit Exceeded)
     * Time: O(n^3)
     * Space: O(n)
     */
    fun numSubarraysWithSum(A: IntArray, S: Int): Int {
        var result = 0
        for (k in 1..A.size) {
            for (i in 0..(A.size - k)) {
                if (A.slice(i until (i + k)).sum() == S) {
                    result++
                }
            }
        }

        return result
    }
}

class SolutionTwo {
    /**
     * Same approach as in [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k)
     * Time: O(n)
     * Space: O(n)
     */
    fun numSubarraysWithSum(A: IntArray, S: Int): Int {
        if (A.isEmpty()) return 0

        var sum = 0
        var count = 0
        val prefixSumFreqs: MutableMap<Int, Int> = HashMap()
        prefixSumFreqs[0] = 1

        for (i in A.indices) {
            sum += A[i]

            if ((sum - S) in prefixSumFreqs) {
                count += prefixSumFreqs[sum - S]!!
            }

            prefixSumFreqs[sum] = (prefixSumFreqs[sum] ?: 0) + 1
        }

        return count
    }
}