package leetcode.easy._118_pascals_triangle

/**
 * 118 - https://leetcode.com/problems/pascals-triangle/
 */
class PascalsTriangle {
    /**
     * Time: O(n)
     * Space: O(?)
     */
    fun generate(numRows: Int): List<List<Int>> =
            (1..numRows).fold(mutableListOf()) { acc, i ->
                acc += when (i) {
                    1 -> listOf(1)
                    2 -> listOf(1, 1)
                    else -> ithRow(acc.last())
                }
                acc
            }

    private fun ithRow(precedingRow: List<Int>): List<Int> =
            arrayListOf<Int>().apply {
                add(1)
                (1..precedingRow.lastIndex).forEach { i ->
                    add(precedingRow[i - 1] + precedingRow[i])
                }
                add(1)
            }
}

class PascalsTriangle2 {
    /**
     * Time: O(n)
     * Space: O(?)
     */
    fun generate(numRows: Int): List<List<Int>> {
        require(numRows >= 0) { "numRows must be >= 0" }
        if (numRows <= 0)
            return emptyList()

        /* Create List<IntArray> full of 1s */
        val triangle = List(numRows + 1) { i -> IntArray(i) { 1 } }

        (3..numRows).forEach { i ->
            triangle[i].forEachIndexed { j, _ ->
                if (j != 0 && j != triangle[i].lastIndex) {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j]
                }
            }
        }

        /* Convert List<IntArray> -> List<List<Int>> and drop empty 0th row */
        return triangle.asSequence()
            .map { it.toList() }
            .drop(1)
            .toList()
    }
}
