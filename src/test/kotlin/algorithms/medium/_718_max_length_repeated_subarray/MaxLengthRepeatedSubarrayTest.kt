package algorithms.medium._718_max_length_repeated_subarray

import org.junit.Test

import org.junit.Assert.*

class MaxLengthRepeatedSubarrayTest {

    private val solution = Solution()

    @Test
    fun findLength() {
        assertEquals(0, solution.findLength(intArrayOf(1, 2), intArrayOf()))
        assertEquals(2, solution.findLength(intArrayOf(1, 2), intArrayOf(1, 2)))
        assertEquals(1, solution.findLength(intArrayOf(1, 2), intArrayOf(2, 1)))
        assertEquals(3, solution.findLength(intArrayOf(1, 2, 3, 2, 1), intArrayOf(1, 2, 3, 4, 7)))
        assertEquals(3, solution.findLength(intArrayOf(1, 2, 3, 2, 1), intArrayOf(3, 2, 1, 4, 7)))
        assertEquals(5, solution.findLength(intArrayOf(7, 7, 7, 7, 7), intArrayOf(7, 7, 7, 7, 7)))
        assertEquals(3, solution.findLength(intArrayOf(7, 7, 7, 7, 7), intArrayOf(7, 7, 7, 4, 7)))
        assertEquals(0, solution.findLength(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
        assertEquals(4, solution.findLength(intArrayOf(0, 0, 0, 0, 1), intArrayOf(1, 0, 0, 0, 0)))
    }
}