package leetcode.easy._463_island_perimeter

import extensions.arrays.IntMatrix
import extensions.arrays.lastColumn
import extensions.arrays.lastRow
import extensions.arrays.transpose

/**
 * 463 - https://leetcode.com/problems/island-perimeter/description/
 */
class Solution {
    fun islandPerimeter(grid: IntMatrix): Int {
        var count = grid.countHorizontalPerimeters()
        val transposed = grid.transpose()
        count += transposed.countHorizontalPerimeters()
        return count
    }

    private fun IntMatrix.countHorizontalPerimeters(): Int {
        var count = 0

        (0..lastRow).forEach { i ->
            (0..lastColumn).forEach { j ->
                if (this[i][j] == 1 && j == 0) count++
                if (this[i][j] == 1 && j == lastColumn) count++
                if (this[i][j] == 1 && isWaterAt(i, j - 1)) count++
                if (this[i][j] == 1 && isWaterAt(i, j + 1)) count++
            }
        }

        return count
    }

    private fun IntMatrix.isWaterAt(i: Int, j: Int): Boolean =
            if (i in 0..lastRow && j in 0..lastColumn) this[i][j] == 0
            else false
}

class Solution2 {
    fun islandPerimeter(grid: IntMatrix): Int {
        var count = grid.countHorizontalPerimeters()
        val transposed = grid.transpose()
        count += transposed.countHorizontalPerimeters()
        return count
    }

    private fun IntMatrix.countHorizontalPerimeters(): Int {
        val perimeterConditions: List<(Int, Int) -> (Boolean)> = listOf(
                { i: Int, j: Int -> isLandAt(i, j) && j == 0 },
                { i: Int, j: Int -> isLandAt(i, j) && j == lastColumn },
                { i: Int, j: Int -> isLandAt(i, j) && isWaterAt(i, j - 1) },
                { i: Int, j: Int -> isLandAt(i, j) && isWaterAt(i, j + 1) }
        )

        var count = 0
        (0..lastRow).forEach { i ->
            (0..lastColumn).forEach { j ->
                perimeterConditions.forEach { condition ->
                    if (condition(i, j)) {
                        count++
                    }
                }
            }
        }

        return count
    }

    private fun IntMatrix.isLandAt(i: Int, j: Int): Boolean =
        if (i in 0..lastRow && j in 0..lastColumn) this[i][j] == 1
        else false

    private fun IntMatrix.isWaterAt(i: Int, j: Int): Boolean =
        if (i in 0..lastRow && j in 0..lastColumn) this[i][j] == 0
        else false
}
