package algorithms.easy._035_search_insert_position

import org.junit.Test

import org.junit.Assert.*

/**
 * @author nrojiani
 * @date 11/10/17
 */
class SearchInsertPositionTest {
    @Test
    fun searchInsert() {
        val solution = Solution()
        assertEquals(2, solution.searchInsert(intArrayOf(1, 3, 5, 6), 5))
        assertEquals(1, solution.searchInsert(intArrayOf(1, 3, 5, 6), 2))
        assertEquals(4, solution.searchInsert(intArrayOf(1, 3, 5, 6), 7))
        assertEquals(0, solution.searchInsert(intArrayOf(1, 3, 5, 6), 0))
    }

}