package leetcode.medium._064_min_path_sum

import extensions.arrays.IntMatrix
import extensions.arrays.columnIndices
import extensions.arrays.lastColumnIndex
import extensions.arrays.lastRowIndex
import extensions.arrays.rowIndices

/**
 * 64 - https://leetcode.com/problems/minimum-path-sum
 */
class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val minPaths = mutableMapOf<Cell, Int>()
        findMinPathSum(grid, START_CELL, 0, minPaths)
        return minPaths[Cell(grid.lastRowIndex, grid.lastColumnIndex)]!!
    }

    private fun findMinPathSum(grid: IntMatrix, cell: Cell, pathSum: Int, minPaths: MutableMap<Cell, Int>) {
        // Update min path sum to cell if lower
        if (!cell.isValidCellIn(grid)) {
            return
        }
        val pathSumToCurrent = pathSum + cell.valueIn(grid)

        if (cell !in minPaths) {
            minPaths[cell] = pathSumToCurrent
        } else if (cell in minPaths && pathSumToCurrent < minPaths[cell]!!) {
            minPaths[cell] = pathSumToCurrent
        } else if (cell in minPaths && pathSumToCurrent >= minPaths[cell]!!) {
            return
        }

        findMinPathSum(grid, cell.rightCell, pathSum + cell.valueIn(grid), minPaths)    // right
        findMinPathSum(grid, cell.downCell, pathSum + cell.valueIn(grid), minPaths)     // down
    }

    companion object {
        private val START_CELL = Cell(0, 0)
    }
}

/**
 * Represents a position in the matrix.
 */
data class Cell(val row: Int, val column: Int) {
    val downCell: Cell get() = Cell(row + 1, column)
    val rightCell: Cell get() = Cell(row, column + 1)

    fun valueIn(grid: IntMatrix): Int = grid[row][column]
    fun isValidCellIn(grid: IntMatrix): Boolean = row in grid.rowIndices && column in grid.columnIndices

    override fun toString(): String = "[$row][$column]"
}

/**
 * Without [Cell]
 */
class SolutionTwo {
    fun minPathSum(grid: Array<IntArray>): Int {
        val minPaths = mutableMapOf<Pair<Int, Int>, Int>()
        findMinPathSum(grid, i = 0, j = 0, pathSum = 0, minPaths = minPaths)
        return minPaths[grid.lastRowIndex to grid.lastColumnIndex]!!
    }

    private fun findMinPathSum(
        grid: IntMatrix,
        i: Int,
        j: Int,
        pathSum: Int,
        minPaths: MutableMap<Pair<Int, Int>, Int>
    ) {
        // Update min path sum to cell if lower
        if (i !in grid.rowIndices || j !in grid.columnIndices) {
            return
        }
        val pathSumToCurrent = pathSum + grid[i][j]

        val cell = (i to j)
        if (cell !in minPaths) {
            minPaths[cell] = pathSumToCurrent
        } else if (cell in minPaths && pathSumToCurrent < minPaths[cell]!!) {
            minPaths[cell] = pathSumToCurrent
        } else if (cell in minPaths && pathSumToCurrent >= minPaths[cell]!!) {
            return
        }

        findMinPathSum(grid, i, j + 1, pathSum + grid[i][j], minPaths) // right
        findMinPathSum(grid, i + 1, j, pathSum + grid[i][j], minPaths) // down
    }
}
