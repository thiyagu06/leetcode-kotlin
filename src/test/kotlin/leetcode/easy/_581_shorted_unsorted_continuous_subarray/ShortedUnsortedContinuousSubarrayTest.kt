package leetcode.easy._581_shorted_unsorted_continuous_subarray

import kotlin.test.assertEquals
import org.junit.Test

class ShortedUnsortedContinuousSubarrayTest {

    private val solution = Solution()

    @Test
    fun findUnsortedSubarray() {
        assertEquals(5, solution.findUnsortedSubarray(intArrayOf(2, 6, 4, 8, 10, 9, 15)))
        assertEquals(7, solution.findUnsortedSubarray(intArrayOf(2, 6, 17, 4, 8, 10, 9, 15)))
    }
}