package leetcode.medium._718_max_length_repeated_subarray

import kotlin.math.max

/**
 * 718 - https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 */
class Solution {
    /**
     * Dynamic Programming - modified LCS
     * Time: O(m * n) - where m = A.size, n = B.size
     * Space: O(m * n)
     */
    fun findLength(A: IntArray, B: IntArray): Int {
        var maxLength = 0
        val dp = Array(A.size + 1) { IntArray(B.size + 1) }

        for (i in 1..A.size) {
            for (j in 1..B.size) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                    maxLength = max(maxLength, dp[i][j])
                }
            }
        }

        return maxLength
    }
}