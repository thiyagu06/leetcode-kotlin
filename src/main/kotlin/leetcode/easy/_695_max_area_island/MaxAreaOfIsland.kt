package leetcode.easy._695_max_area_island

import extensions.arrays.BooleanMatrix
import extensions.arrays.IntMatrix
import extensions.arrays.columnIndices
import extensions.arrays.columns
import extensions.arrays.dfs
import extensions.arrays.rowIndices
import extensions.arrays.rows
import kotlin.math.max

/**
 * 695 - https://leetcode.com/problems/max-area-of-island/
 */
class RecursiveDFSSolution {
    private lateinit var grid: IntMatrix
    private lateinit var seen: BooleanMatrix

    /**
     * Time: O(R * C) - where R is the # of rows, C is the # of cols. Each square is visited once.
     * Space: O(R * C)
     */
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        this.grid = grid

        seen = Array(grid.rows) { BooleanArray(grid.columns) }

        var maxArea = 0
        grid.rowIndices.forEach { r ->
            grid.columnIndices.forEach { c ->
                maxArea = max(maxArea, areaOfIslandAt(r, c))
            }
        }
        return maxArea
    }

    // note: water squares do not need to be marked (but can be)
    private fun areaOfIslandAt(r: Int, c: Int): Int = when {
        r !in grid.rowIndices -> 0
        c !in grid.columnIndices -> 0
        seen[r][c] -> 0
        grid[r][c] == 0 -> 0
        else -> {
            seen[r][c] = true

            (1 + areaOfIslandAt(r + 1, c) + areaOfIslandAt(r - 1, c)
                    + areaOfIslandAt(r, c - 1) + areaOfIslandAt(r, c + 1))
        }
    }
}

class RecursiveDFSSolution2 {
    private lateinit var grid: IntMatrix
    private lateinit var seen: BooleanMatrix

    /**
     * Uses the generalized [extensions.arrays.dfs] extension function.
     *
     * Time: O(R * C) - where R is the # of rows, C is the # of cols. Each square is visited once.
     * Space: O(R * C)
     */
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        this.grid = grid

        seen = Array(grid.size) { BooleanArray(grid[0].size) }

        var maxArea = 0
        grid.dfs { r, c ->
            maxArea = max(maxArea, areaOfIslandAt(r, c))
        }
        return maxArea
    }

    // note: water squares do not need to be marked (but can be - returns 0 if water or seen)
    private fun areaOfIslandAt(r: Int, c: Int): Int = when {
        r !in grid.rowIndices -> 0
        c !in grid.columnIndices -> 0
        seen[r][c] -> 0
        grid[r][c] == 0 -> 0
        else -> {
            seen[r][c] = true

            (1 + areaOfIslandAt(r + 1, c) + areaOfIslandAt(r - 1, c)
                    + areaOfIslandAt(r, c - 1) + areaOfIslandAt(r, c + 1))
        }
    }
}

/**
 * TODO
 */
class BFSSolution {
    // private lateinit var grid: IntMatrix
    // private lateinit var seen: BooleanMatrix

    /**
     * Time: O(R * C) - where R is the # of rows, C is the # of cols. Each square is visited once.
     * Space: O(R * C)
     */
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        TODO()
    }
}