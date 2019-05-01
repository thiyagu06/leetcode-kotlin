package leetcode.hard._072_edit_distance

import extensions.strings.editDistance

/**
 * 72 - https://leetcode.com/problems/edit-distance/description/
 */
class Solution {
    /**
     * Time: O(m * n)
     * Space: O(m * n)
     */
    fun minDistance(word1: String, word2: String): Int {
        val dp = Array(word1.length + 1) { IntArray(word2.length + 1) }

        // If either word1 or word2 is empty, the # of operations is the length of
        // the other string
        for (i in 0..word1.length) dp[i][0] = i
        for (j in 0..word2.length) dp[0][j] = j

        val m = word1.length
        val n = word2.length

        for (i in 1..m) {
            for (j in 1..n) {
                // If last chars match, no additional operations needed vs. word1[:m - 1] & word2[:n - 1]
                // Note: i - 1 & j - 1 because we added rows for 0-length strings in dp table
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = 1 + minOf(
                        dp[i][j - 1],       // insertion
                        dp[i - 1][j],       // deletion
                        dp[i - 1][j - 1]    // substitution
                    )
                }
            }
        }

        return dp[m][n]
    }
}

class SolutionTwo {
    /**
     * Time: O(m * n)
     * Space: O(m * n)
     */
    fun minDistance(word1: String, word2: String): Int = editDistance(word1, word2)
}
