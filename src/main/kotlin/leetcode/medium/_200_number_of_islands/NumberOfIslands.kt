package leetcode.medium._200_number_of_islands

import java.util.ArrayDeque
import java.util.Deque
import java.util.Queue

/**
 * 200 - https://leetcode.com/problems/number-of-islands
 */
class Solution {

    private lateinit var grid: Array<CharArray>
    private lateinit var visited: Array<BooleanArray>

    /**
     * DFS Solution.
     *
     * Time: O(?)
     * Space: O(?)
     */
    fun numIslands(grid: Array<CharArray>): Int {
        this.grid = grid
        this.visited = Array(grid.size) { i -> BooleanArray(grid[i].size) }

        var islands = 0

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islands++
                    dfs(i, j)
                }
            }
        }

        return islands
    }

    private fun dfs(i: Int, j: Int) {
        if (!isValid(i, j) || grid[i][j] == '0' || visited[i][j]) return

        visited[i][j] = true
        neighborsOf(i, j).forEach { (r, c) ->
            dfs(r, c)
        }
    }


    private fun neighborsOf(i: Int, j: Int): List<Pair<Int, Int>> = listOf(
        i to j + 1,
        i + 1 to j,
        i to j - 1,
        i - 1 to j
    )

    private fun isValid(i: Int, j: Int): Boolean = i in grid.indices && j in grid[i].indices
}

class SolutionTwo {

    private lateinit var grid: Array<CharArray>

    /**
     * DFS. Same as [Solution], except instead of keeping a visited matrix as used in this
     * solution, we change each visited land cell from '1' to '0' in the grid.
     */
    fun numIslands(grid: Array<CharArray>): Int {
        this.grid = grid

        var islands = 0

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    islands++
                    dfs(i, j)
                }
            }
        }

        return islands
    }

    private fun dfs(i: Int, j: Int) {
        // Changing it to '0' is equivalent of marking it visited, since
        // we just want to prevent DFS from being called again on the cell.
        grid[i][j] = '0'
        // Continue search for Up, Right, Down, & Left neighbors that are land & unvisited
        setOf(
            i - 1 to j,
            i to j + 1,
            i + 1 to j,
            i to j - 1
        ).filter { (r, c) ->
            isValidCell(r, c) && grid[r][c] == '1'
        }.forEach { (r, c) ->
            dfs(r, c)
        }
    }

    private fun isValidCell(i: Int, j: Int): Boolean = i in grid.indices && j in grid[0].indices
}

class SolutionThree {

    private lateinit var grid: Array<CharArray>

    /**
     * DFS. Same as [SolutionTwo], except uses a Stack instead of recursion.
     */
    fun numIslands(grid: Array<CharArray>): Int {
        this.grid = grid

        var islands = 0

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    islands++
                    dfs(i, j)
                }
            }
        }

        return islands
    }

    private fun dfs(i: Int, j: Int) {
        val stack: Deque<Pair<Int, Int>> = ArrayDeque()
        // Changing it to '0' is equivalent of marking it visited, since
        // we just want to prevent DFS from being called again on the cell.
        grid[i][j] = '0'

        var cell = i to j
        stack.push(cell)

        while (stack.isNotEmpty()) {
            cell = stack.pop()
            val (r, c) = cell
            grid[r][c] = '0'    // mark as visited
            // Continue search for Up, Right, Down, & Left neighbors that are land & unvisited
            allNeighbors(cell).filter { (r, c) ->
                isValidCell(r, c) && grid[r][c] == '1'
            }.forEach {
                stack.push(it)
            }
        }
    }

    private fun isValidCell(i: Int, j: Int): Boolean = i in grid.indices && j in grid[0].indices

    // All non-diagonal neighbors (possibly invalid)
    private fun allNeighbors(cell: Pair<Int, Int>): List<Pair<Int, Int>> {
        val (i, j) = cell
        return listOf(
            i - 1 to j,
            i to j + 1,
            i + 1 to j,
            i to j - 1
        )
    }
}

class SolutionFour {

    private lateinit var grid: Array<CharArray>

    /**
     * BFS version
     */
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0

        this.grid = grid
        var islands = 0

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    islands++
                    bfs(i, j)
                }
            }
        }

        return islands
    }

    private fun bfs(i: Int, j: Int) {
        var cell = i to j

        val queue: Queue<Pair<Int, Int>> = ArrayDeque()
        queue.offer(cell)

        while (queue.isNotEmpty()) {
            cell = queue.poll()
            val (r, c) = cell

            // Critically important:
            // Cells can be added to queue multiple times. Make sure this
            // is unvisited before processing it.
            // Alternatively, can mark each as visited prior to enqueueing them.
            if (grid[r][c] == '0') continue

            grid[r][c] = '0'    // mark as visited

            allNeighbors(cell).filter { (r, c) ->
                isValidCell(r, c) && grid[r][c] == '1'
            }.forEach { (r, c) ->
                queue.offer(r to c)
            }
        }
    }

    // All non-diagonal neighbors
    private fun allNeighbors(cell: Pair<Int, Int>): List<Pair<Int, Int>> {
        val (i, j) = cell
        return listOf(
            i - 1 to j,
            i to j + 1,
            i + 1 to j,
            i to j - 1
        )
    }

    private fun isValidCell(i: Int, j: Int): Boolean = i in grid.indices && j in grid[0].indices
}
