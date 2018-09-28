package leetcode.medium._378_kth_smallest_in_sorted_matrix

import extensions.arrays.columnIndices
import extensions.arrays.rowIndices
import extensions.arrays.rows

/**
 * 378 - https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
class Solution {
    /**
     * Time: O(n^2)
     * Space: O(n)
     */
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val n = matrix.rows
        val seen = IntArray(n * n)
        var seenIndex = 0
        for (i in matrix.rowIndices) {
            for (j in matrix.columnIndices) {
                seen[seenIndex++] = matrix[i][j]
            }
        }
        seen.sort()
        return seen[k - 1]
    }
}