package algorithms.easy._695_max_area_island

import extensions.arrays.columnRange
import extensions.arrays.columns
import extensions.arrays.dfs
import extensions.arrays.rowRange
import extensions.arrays.rows
import java.util.*
import kotlin.math.max

/**
 * 695 - https://leetcode.com/problems/max-area-of-island/description/
 */
class RecursiveDFSSolution {
    private lateinit var grid: Array<IntArray>
    private lateinit var seen: Array<BooleanArray>

    /**
     * Time: O(R * C) - where R is the # of rows, C is the # of cols. Each square is visited once.
     * Space: O(R * C)
     */
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        this.grid = grid

        seen = Array(grid.rows) { BooleanArray(grid.columns) }

        var maxArea = 0
        grid.rowRange.forEach { r ->
            grid.columnRange.forEach { c ->
                maxArea = max(maxArea, areaOfIslandAt(r, c))
            }
        }
        return maxArea
    }

    // note: water squares do not need to be marked (but can be)
    private fun areaOfIslandAt(r: Int, c: Int): Int = when {
        r !in grid.rowRange -> 0
        c !in grid.columnRange -> 0
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
    private lateinit var grid: Array<IntArray>
    private lateinit var seen: Array<BooleanArray>

    /**
     * Uses the generalized `Matrix.dfs()` extension function.
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
        r !in grid.rowRange -> 0
        c !in grid.columnRange -> 0
        seen[r][c] -> 0
        grid[r][c] == 0 -> 0
        else -> {
            seen[r][c] = true

            (1 + areaOfIslandAt(r + 1, c) + areaOfIslandAt(r - 1, c)
                    + areaOfIslandAt(r, c - 1) + areaOfIslandAt(r, c + 1))
        }
    }
}

class IterativeDFSSolution {
    /**
     * Uses a stack instead of recursion
     * See https://leetcode.com/problems/max-area-of-island/solution/
     *
     * Time: O(R * C) - where R is the # of rows, C is the # of cols. Each square is visited once.
     * Space: O(R * C)
     */
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val seen = Array(grid.rows) { BooleanArray(grid.columns) }
        TODO()
    }
}

/**
 * TODO - fix
 */
class BFSSolution {
    private lateinit var grid: Array<IntArray>
    private lateinit var seen: Array<BooleanArray>

    /**
     * Time: O(R * C) - where R is the # of rows, C is the # of cols. Each square is visited once.
     * Space: O(R * C)
     */
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        this.grid = grid
        seen = Array(grid.size) { BooleanArray(grid[0].size) }

        var maxArea = 0
        val queue = ArrayDeque<Pair<Int, Int>>()
        var currentPoint: Pair<Int, Int> = 0 to 0
        queue.offer(currentPoint)
        while (queue.isNotEmpty()) {
            val (r, c) = queue.poll()
            println("last dequeued: grid[$r][$c]")
            println("queue before adding neighbors: $queue")

            val temp = areaOfIslandAt(r, c)
            println("area($r, $c) = $temp")
//            maxArea = max(maxArea, areaOfIslandAt(r, c))
            maxArea = max(maxArea, temp)
            // enqueue 4 non-diagonal neighbors (up, down, right, left)
            val up = r + 1 to c
            val down = r - 1 to c
            val left = r to c - 1
            val right = r to c + 1
            val neighbors = listOf(up, down, right, left)

            neighbors.forEach { point ->
                println("neighbor: (${point.first}, ${point.second})")
//                println("isValid($point): ${isValid(point)}")
//                if (isValid(point)) println("hasBeenVisited($point): ${hasBeenVisited(point)}")
                println("seen: ${seen.toList()}")
                if (isValid(point) && !hasBeenVisited(point)) {
//                    println("valid & !visited: (${point.first}, ${point.second})")
                    queue.offer(point)
                }
            }

            println("queue after adding neighbors: $queue")
        }
        return maxArea
    }


    private fun Array<BooleanArray>.toList(): List<List<String>> = fold(kotlin.collections.mutableListOf()) {
            acc, boolArr ->
        acc.apply {
            acc.add(boolArr.toList().map { if (it) "T" else "F" })
        }
    }

    private fun isValid(coordinates: Pair<Int, Int>): Boolean = coordinates.first in grid.rowRange
            && coordinates.second in grid.columnRange

    private fun hasBeenVisited(coordinates: Pair<Int, Int>): Boolean = seen[coordinates.first][coordinates.second]

    // note: water squares do not need to be marked (but can be)
    private fun areaOfIslandAt(r: Int, c: Int): Int = when {
        r !in grid.rowRange -> 0
        c !in grid.columnRange -> 0
        seen[r][c] -> 0
        grid[r][c] == 0 -> 0
        else -> {
            seen[r][c] = true

            (1 + areaOfIslandAt(r + 1, c) + areaOfIslandAt(r - 1, c)
                    + areaOfIslandAt(r, c - 1) + areaOfIslandAt(r, c + 1))
        }
    }
}