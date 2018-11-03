package leetcode.medium._200_number_of_islands

import java.util.Deque
import java.util.ArrayDeque

/**
 * 200 - https://leetcode.com/problems/number-of-islands
 */
class Solution {

    private lateinit var visited: Array<BooleanArray>
    private lateinit var grid: Array<CharArray>

    fun numIslands(grid: Array<CharArray>): Int {
        this.grid = grid
        this.visited = Array(grid.size) { i -> BooleanArray(grid[i].size) { false } }

        var count = 0
        val queue: Deque<Pair<Int, Int>> = ArrayDeque()

        for (r in grid.indices) {
            for (c in grid[r].indices) {
                // If already visited or is water, continue iterating through matrix
                if (grid[r][c] == '1' && !visited[r][c]) {
                    count++
                    queue.offer(r to c)

                    while (queue.isNotEmpty()) {
                        val (i, j) = queue.poll()
                        visited[i][j] = true
                        getUnvisitedIslandNeighbors(i, j).forEach {
                            queue.offer(it)
                        }
                    }
                    // when queue is empty, we're done with the current island.
                }
            }
        }


        return count
    }

    /** All valid unvisited (non-diagonally) adjacent neighbors */
    private fun getUnvisitedIslandNeighbors(i: Int, j: Int): List<Pair<Int, Int>> = setOf(
        (i - 1 to j),   // Up
        (i to j + 1),   // Right
        (i + 1 to j),   // Down
        (i to j - 1)    // Left
    ).filter { (row, col) ->
        (row in grid.indices && col in grid[0].indices) && (grid[row][col] == '1')
    }
}


/**
 * BFS - same as above, but instead of visited matrix, mark visited squares as '0' in grid.
 * Time Limit Exceeded
 * TODO: try DFS
 */
class SolutionTwo {

    private lateinit var grid: Array<CharArray>

    fun numIslands(grid: Array<CharArray>): Int {
        this.grid = grid

        var count = 0
        val queue: Deque<Pair<Int, Int>> = ArrayDeque()

        for (r in grid.indices) {
            for (c in grid[r].indices) {
                // If already visited or is water, continue iterating through matrix
                if (grid[r][c] == '1') {
                    count++
                    grid[r][c] = '0'
                    queue.offer(r to c)

                    while (queue.isNotEmpty()) {
                        val (i, j) = queue.poll()
                        grid[i][j] = '0'    // mark visited
                        getUnvisitedIslandNeighbors(i, j).forEach {
                            grid[i][j] = '0'
                            queue.offer(it)
                        }
                    }
                    // when queue is empty, we're done with the current island.
                }
            }
        }


        return count
    }

    /** All valid unvisited (non-diagonally) adjacent neighbors */
    private fun getUnvisitedIslandNeighbors(i: Int, j: Int): List<Pair<Int, Int>> = setOf(
        (i - 1 to j),   // Up
        (i to j + 1),   // Right
        (i + 1 to j),   // Down
        (i to j - 1)    // Left
    ).filter { (r, c) ->
        (r in grid.indices && c in grid[0].indices) && (grid[r][c] == '1')
    }
}
