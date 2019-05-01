package leetcode.medium._054_spiral_matrix

/**
 * 54 - https://leetcode.com/problems/spiral-matrix
 */
class Solution {
    enum class Direction { RIGHT, DOWN, LEFT, UP }

    /**
     * Time: O(m * n)
     * Space: O(m * n)
     */
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return emptyList()

        var firstRow = 0
        var lastRow = matrix.lastIndex
        var firstColumn = 0
        var lastColumn = matrix[0].lastIndex

        val visited: MutableList<Int> = ArrayList()
        var direction = Direction.RIGHT

        while (firstRow <= lastRow && firstColumn <= lastColumn) {
            when (direction) {
                Direction.RIGHT -> {
                    val i = firstRow
                    for (j in firstColumn..lastColumn) {
                        visited += matrix[i][j]
                    }
                    firstRow++
                }
                Direction.DOWN -> {
                    val j = lastColumn
                    for (i in firstRow..lastRow) {
                        visited += matrix[i][j]
                    }
                    lastColumn--
                }
                Direction.LEFT -> {
                    val i = lastRow
                    for (j in lastColumn downTo firstColumn) {
                        visited += matrix[i][j]
                    }
                    lastRow--
                }
                Direction.UP -> {
                    val j = firstColumn
                    for (i in lastRow downTo firstRow) {
                        visited += matrix[i][j]
                    }
                    firstColumn++
                }
            }
            direction = directionAfter(direction)
        }

        return visited
    }

    // Move ->, ↓, <-, ↑
    private fun directionAfter(direction: Direction): Direction = when (direction) {
        Direction.RIGHT -> Direction.DOWN
        Direction.DOWN -> Direction.LEFT
        Direction.LEFT -> Direction.UP
        Direction.UP -> Direction.RIGHT
    }
}
