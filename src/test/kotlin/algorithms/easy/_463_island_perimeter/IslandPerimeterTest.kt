package algorithms.easy._463_island_perimeter

import extensions.arrays.IntMatrix
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class IslandPerimeterTest {

    private val solution = Solution()
    private val solution2 = Solution2()

    private lateinit var grid: IntMatrix

    @Before
    fun setup() {
        val row0 = intArrayOf(0, 1, 0, 0)
        val row1 = intArrayOf(1, 1, 1, 0)
        val row2 = intArrayOf(0, 1, 0, 0)
        val row3 = intArrayOf(1, 1, 0, 0)
        grid = Array(4) { IntArray(4) }
        grid[0] = row0
        grid[1] = row1
        grid[2] = row2
        grid[3] = row3
    }

    @Test
    fun islandPerimeter() {
        assertEquals(16, solution.islandPerimeter(grid))
    }

    @Test
    fun islandPerimeter2() {
        assertEquals(16, solution2.islandPerimeter(grid))
    }


}