package leetcode.easy._035_search_insert_position

import org.junit.Test

import org.junit.Assert.*

class SearchInsertPositionTest {

    private val simpleSolution = SimpleSolution()
    private val optimalSolution = OptimalSolution()

    @Test
    fun searchInsertSimple() {
        assertEquals(2, simpleSolution.searchInsert(intArrayOf(1, 3, 5, 6), 5))
        assertEquals(1, simpleSolution.searchInsert(intArrayOf(1, 3, 5, 6), 2))
        assertEquals(4, simpleSolution.searchInsert(intArrayOf(1, 3, 5, 6), 7))
        assertEquals(0, simpleSolution.searchInsert(intArrayOf(1, 3, 5, 6), 0))
    }

    @Test
    fun searchInsertOptimal() {
        assertEquals(2, optimalSolution.searchInsert(intArrayOf(1, 3, 5, 6), 5))
        assertEquals(1, optimalSolution.searchInsert(intArrayOf(1, 3, 5, 6), 2))
        assertEquals(4, optimalSolution.searchInsert(intArrayOf(1, 3, 5, 6), 7))
        assertEquals(0, optimalSolution.searchInsert(intArrayOf(1, 3, 5, 6), 0))
    }

}
