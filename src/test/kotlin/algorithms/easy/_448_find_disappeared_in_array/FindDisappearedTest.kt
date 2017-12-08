package algorithms.easy._448_find_disappeared_in_array

import org.junit.Test

import org.junit.Assert.*

class FindDisappearedTest {

    private val solution = Solution()

    @Test
    fun findDisappearedNumbers() {
        assertEquals(listOf(5, 6), solution.findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
        assertEquals(emptyList<Int>(), solution.findDisappearedNumbers(intArrayOf()))
//        assertEquals(emptyList<Int>(), solution.findDisappearedNumbers(intArrayOf(1)))
        assertEquals(listOf(1), solution.findDisappearedNumbers(intArrayOf(2)))
        assertEquals(listOf(2), solution.findDisappearedNumbers(intArrayOf(1, 3)))
    }
}