package algorithms.easy._643_max_avg_subarray_I

import org.junit.Test

import org.junit.Assert.*

class MaxAvgSubarrayTest {

    private val solution = Solution()
    private val solution2 = Solution2()

    @Test
    fun findMaxAverage() {
        assertEquals(12.75, solution.findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4), 0.001)
        assertEquals(12.75, solution.findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3, -30, 25), 4), 0.001)
        assertEquals(5.0, solution.findMaxAverage(intArrayOf(5), 1), 0.001)
        assertEquals(5.0, solution.findMaxAverage(intArrayOf(5, 5), 2), 0.1)
    }

    @Test
    fun findMaxAverage2() {
        assertEquals(12.75, solution2.findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4), 0.001)
        assertEquals(12.75, solution2.findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3, -30, 25), 4), 0.001)
        assertEquals(5.0, solution2.findMaxAverage(intArrayOf(5), 1), 0.1)
        assertEquals(5.0, solution2.findMaxAverage(intArrayOf(5, 5), 2), 0.1)
    }
}