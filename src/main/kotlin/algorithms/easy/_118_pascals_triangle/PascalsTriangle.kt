package algorithms.easy._118_pascals_triangle

/**
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 */
class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        require(numRows >= 0) { "numRows must be >= 0" }

        /* Create List<IntArray> full of 1s */
        val triangle = List(numRows + 1, { i -> IntArray(i, { 1 }) })

        (3..numRows).forEach { i ->
            triangle[i].forEachIndexed { j, _->
                if (j != 0 && j != triangle[i].lastIndex) {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j]
                }
            }
        }

        /* Convert List<IntArray> -> List<List<Int>> and drop empty 0th row */
        return triangle.map { it.toList() }.drop(1)
    }
}