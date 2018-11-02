package leetcode.medium._931_min_falling_path_sum

import extensions.comparables.minOf

/**
 * 931 - https://leetcode.com/problems/minimum-falling-path-sum/description/
 */
class Solution {
    /**
     * Dynamic Programming
     * Time: O(n^2) - m == n
     * Space: O(n)
     */
    fun minFallingPathSum(A: Array<IntArray>): Int {
        val minRemainingPaths: Array<IntArray> = Array(A.size) { IntArray(A.size) { Int.MAX_VALUE } }

        for (i in A.lastIndex downTo 0) {
            for (j in 0..A[i].lastIndex) {
                when (i) {
                    A.lastIndex -> minRemainingPaths[i][j] = A[i][j]
                    else -> {
                        minRemainingPaths[i][j] = A[i][j] + minOf(
                            if (isValidIndex(A, i + 1, j - 1)) minRemainingPaths[i + 1][j - 1] else Int.MAX_VALUE,
                            if (isValidIndex(A, i + 1, j)) minRemainingPaths[i + 1][j] else Int.MAX_VALUE,
                            if (isValidIndex(A, i + 1, j + 1)) minRemainingPaths[i + 1][j + 1] else Int.MAX_VALUE
                        )
                    }
                }
            }
        }

        // The smallest falling path will be the smallest remaining path starting in row 0.
        return minRemainingPaths[0].min()!!
    }

    private fun isValidIndex(A: Array<IntArray>, i: Int, j: Int): Boolean =
        A.isNotEmpty() && i in A.indices && j in A[0].indices
}