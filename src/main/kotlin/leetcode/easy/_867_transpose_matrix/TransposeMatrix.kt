package leetcode.easy._867_transpose_matrix

import extensions.arrays.transpose

/**
 * 867 - https://leetcode.com/problems/transpose-matrix/
 */
class Solution {
    /**
     * Time: O(m * n)
     * Space: O(m * n) - makes a copy rather than mutating input
     */
    fun transpose(A: Array<IntArray>): Array<IntArray> = A.transpose()
}

class Solution2 {
    /**
     * Time: O(m * n)
     * Space: O(m * n) - makes a copy rather than mutating input
     */
    fun transpose(A: Array<IntArray>): Array<IntArray> {
        val rows = A.size
        val columns = A[0].size
        val transposed: Array<IntArray> = Array(columns) { IntArray(rows) }

        (0 until rows).forEach { i ->
            (0 until columns).forEach { j ->
                transposed[j][i] = A[i][j]
            }
        }

        return transposed
    }
}