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

        var indicesOfLongest = IntRange.EMPTY

        /* dp[i][j] indicates that s[i..j] is a palindrome */
        val dp = booleanMatrixWithSize(n, n)
        for (substrLen in 1..n) {
            (0..(n - substrLen)).forEach { i ->
                val j = i + substrLen - 1
                if (isPalindrome(s, i, j, dp)) {
                    indicesOfLongest = i..j
                }
            }
        }

        return s.substring(indicesOfLongest)
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
