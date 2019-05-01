package leetcode.medium._005_longest_palindromic_substring

import extensions.arrays.BooleanMatrix
import extensions.arrays.booleanMatrixWithSize

/**
 * 5 - https://leetcode.com/problems/longest-palindromic-substring/
 */
class Solution {
    /**
     * See [Approach 3](https://leetcode.com/problems/longest-palindromic-substring/solution/) in Solutions.
     * Time: O(n^2)
     * Space: O(n^2)
     */
    fun longestPalindrome(s: String): String {
        val n = s.length
        if (n <= 1) return s

        // dp[i][j] = is s[i..j] a palindrome?
        val dp = booleanMatrixWithSize(n, n)
        var longestIndices = 0..0

        for (substrLen in 1..n) {
            for (i in 0..(n - substrLen)) {
                val j = i + substrLen - 1
                if (isPalindrome(s, i, j, dp)) {
                    longestIndices = i..j
                }
            }
        }

        return s.substring(longestIndices)
    }

    private fun isPalindrome(s: String, i: Int, j: Int, dp: BooleanMatrix): Boolean {
        dp[i][j] = when {
            dp[i][j] -> true
            i == j -> true
            i + 1 == j -> s[i] == s[j]
            else -> dp[i + 1][j - 1] && s[i] == s[j]
        }
        return dp[i][j]
    }
}
