package algorithms.easy._119_pascals_triangle_II

import algorithms.easy._118_pascals_triangle.PascalsTriangle
import extensions.math.choose

/**
 * 119 - https://leetcode.com/problems/pascals-triangle-ii/description/
 */
class Solution {
    fun getRow(rowIndex: Int): List<Int> =
        PascalsTriangle().generate(numRows = rowIndex + 1).lastOrNull() ?: emptyList()
}

/**
 * Follow-up:
 * k = index of the kth row (`rowIndex`)
 * Could you optimize your algorithm to use only `O(k)` extra space?
 */
class FollowUpSolution {
    /**
     * The value at the nth row, kth index = C(n, k)
     */
    fun getRow(rowIndex: Int): List<Int> {
        return (0..rowIndex).fold(emptyList()) { acc, k ->
            acc + choose(rowIndex, k).toInt()
        }
    }
}

/**
 * Use binomial symmetry to avoid calculating every number.
 *
 * getRow(rowIndex = 3) -> [1, 3, 3, 1]
 * rowIndex.isOdd -> even # of elements -> !hasMiddleElement
 * C(3, 0) = C(3, 3) = 1
 * C(3, 1) = C(3, 2) = 3
 *
 * getRow(rowIndex = 4) -> [1, 4, 6, 4, 1]
 * rowIndex.isEven -> odd # of elements -> hasMiddleElement
 * C(4, 0) = C(4, 4) = 1
 * C(4, 1) = C(4, 3) = 4
 * C(4, 2) = 6
 *
 * Calculate the elements at index k = 0..(rowIndex / 2)
 * and use property:
 *
 * C(n, k) = C(n, n - k)
 */
class FollowUpSolution2 {
    /**
     * The value at the nth row, kth index = C(n, k)
     */
    fun getRow(rowIndex: Int): List<Int> {
        val rangeToCalculate = 0..(rowIndex / 2)
        return (0..rowIndex).fold(emptyList()) { rowAcc, k ->
            rowAcc + when (k) {
                in rangeToCalculate -> choose(rowIndex, k).toInt()
                else -> rowAcc[rowIndex - k]
            }
        }
    }
}