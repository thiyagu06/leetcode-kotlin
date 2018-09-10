package leetcode.easy._434_number_of_segments_string

import org.junit.Test

import org.junit.Assert.*

class NumberOfSegmentsInStringTest {

    private val solution = Solution()

    @Test
    fun countSegments() {
        assertEquals(5, solution.countSegments("Hello, my name is John"))
    }
}