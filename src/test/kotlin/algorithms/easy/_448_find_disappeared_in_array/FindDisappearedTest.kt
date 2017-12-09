package algorithms.easy._448_find_disappeared_in_array

import org.junit.Test

import org.junit.Assert.*

class FindDisappearedTest {

    private val solution = Solution()
    private val followup = FollowUpSolution()

    @Test
    fun findDisappearedNumbers() {
        assertEquals(listOf(5, 6), solution.findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
        assertEquals(emptyList<Int>(), solution.findDisappearedNumbers(intArrayOf()))
        assertEquals(listOf(2), solution.findDisappearedNumbers(intArrayOf(1, 1)))
        assertEquals(listOf(2), solution.findDisappearedNumbers(intArrayOf(3, 1, 3)))
        assertEquals(listOf(1), solution.findDisappearedNumbers(intArrayOf(3, 3, 2)))
    }

    @Test
    fun findDisappearedNumbersFollowup() {
        assertEquals(listOf(5, 6), followup.findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
        assertEquals(emptyList<Int>(), followup.findDisappearedNumbers(intArrayOf()))
        assertEquals(listOf(2), followup.findDisappearedNumbers(intArrayOf(1, 1)))
        assertEquals(listOf(2), followup.findDisappearedNumbers(intArrayOf(3, 1, 3)))
        assertEquals(listOf(1), followup.findDisappearedNumbers(intArrayOf(3, 3, 2)))
    }
}