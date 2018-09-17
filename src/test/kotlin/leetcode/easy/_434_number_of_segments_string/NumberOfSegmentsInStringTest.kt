package leetcode.easy._434_number_of_segments_string

import org.junit.Test

import org.junit.Assert.*

class NumberOfSegmentsInStringTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun countSegments() {
        assertEquals(0, solution.countSegments(""))
        assertEquals(1, solution.countSegments("a"))
        assertEquals(5, solution.countSegments("Hello, my name is John"))
    }

    @Test
    fun countSegments2() {
        assertEquals(0, solution2.countSegments(""))
        assertEquals(1, solution2.countSegments("a"))
        assertEquals(5, solution2.countSegments("Hello, my name is John"))
    }
}