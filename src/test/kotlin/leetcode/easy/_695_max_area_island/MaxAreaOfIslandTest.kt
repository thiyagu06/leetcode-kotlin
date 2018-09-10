package leetcode.easy._695_max_area_island

import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore

class MaxAreaOfIslandTest {

    private val recDFSSolution = RecursiveDFSSolution()
    private val recDFSSolution2 = RecursiveDFSSolution2()
    private val bfsSolution = BFSSolution()

    private val grid1 = arrayOf(
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 1, 1),
        intArrayOf(0, 0, 0, 1, 1)
    )
    private val grid2 = arrayOf(
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(0, 0, 1, 1, 1),
        intArrayOf(0, 0, 1, 1, 1)
    )
    private val grid3 = arrayOf(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0))
    private val grid4 = arrayOf(intArrayOf(0, 0, 0, 0, 0, 0, 0, 1))
    private val grid5 = arrayOf(intArrayOf(0, 0, 0, 1, 1, 1, 1, 1))
    private val grid6 = arrayOf(
        intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
    )
    private val grid7 = arrayOf(
        intArrayOf(0, 1, 1),
        intArrayOf(1, 1, 0)
    )
    private val grid8 = arrayOf(
        intArrayOf(1, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0, 1)
    )

    @Test
    fun maxAreaOfIslandRec1() {
        assertEquals(4, recDFSSolution.maxAreaOfIsland(grid1))
        assertEquals(6, recDFSSolution.maxAreaOfIsland(grid2))
        assertEquals(0, recDFSSolution.maxAreaOfIsland(grid3))
        assertEquals(1, recDFSSolution.maxAreaOfIsland(grid4))
        assertEquals(5, recDFSSolution.maxAreaOfIsland(grid5))
        assertEquals(6, recDFSSolution.maxAreaOfIsland(grid6))
        assertEquals(4, recDFSSolution.maxAreaOfIsland(grid7))
        assertEquals(1, recDFSSolution.maxAreaOfIsland(grid8))
    }

    @Test
    fun maxAreaOfIslandRec2() {
        assertEquals(4, recDFSSolution2.maxAreaOfIsland(grid1))
        assertEquals(6, recDFSSolution2.maxAreaOfIsland(grid2))
        assertEquals(0, recDFSSolution2.maxAreaOfIsland(grid3))
        assertEquals(1, recDFSSolution2.maxAreaOfIsland(grid4))
        assertEquals(5, recDFSSolution2.maxAreaOfIsland(grid5))
        assertEquals(6, recDFSSolution2.maxAreaOfIsland(grid6))
        assertEquals(4, recDFSSolution2.maxAreaOfIsland(grid7))
        assertEquals(1, recDFSSolution2.maxAreaOfIsland(grid8))
    }

    @Ignore
    @Test
    fun maxAreaOfIslandBFS() {
        assertEquals(4, bfsSolution.maxAreaOfIsland(grid1))
        assertEquals(6, bfsSolution.maxAreaOfIsland(grid2))
        assertEquals(0, bfsSolution.maxAreaOfIsland(grid3))
        assertEquals(1, bfsSolution.maxAreaOfIsland(grid4))
        assertEquals(5, bfsSolution.maxAreaOfIsland(grid5))
        assertEquals(6, bfsSolution.maxAreaOfIsland(grid6))
        assertEquals(4, bfsSolution.maxAreaOfIsland(grid7))
        assertEquals(1, bfsSolution.maxAreaOfIsland(grid8))
    }
}