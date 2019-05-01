package leetcode.easy._258_add_digits

import org.junit.Test

import org.junit.Assert.*

class AddDigitsTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    @Test
    fun addDigits() {
        assertEquals(0, solution.addDigits(0))
        assertEquals(1, solution.addDigits(1))
        assertEquals(9, solution.addDigits(9))
        assertEquals(2, solution.addDigits(38))
        assertEquals(6, solution.addDigits(492))
        assertEquals(5, solution.addDigits(374))
        assertEquals(9, solution.addDigits(999999))
        assertEquals(1, solution.addDigits(19))
    }

    @Test
    fun addDigits2() {
        assertEquals(0, solution2.addDigits(0))
        assertEquals(1, solution2.addDigits(1))
        assertEquals(9, solution2.addDigits(9))
        assertEquals(2, solution2.addDigits(38))
        assertEquals(6, solution2.addDigits(492))
        assertEquals(5, solution2.addDigits(374))
        assertEquals(9, solution2.addDigits(999999))
        assertEquals(1, solution2.addDigits(19))
    }

    @Test
    fun addDigits3() {
        assertEquals(0, solution3.addDigits(0))
        assertEquals(1, solution3.addDigits(1))
        assertEquals(9, solution3.addDigits(9))
        assertEquals(2, solution3.addDigits(38))
        assertEquals(6, solution3.addDigits(492))
        assertEquals(5, solution3.addDigits(374))
        assertEquals(9, solution3.addDigits(999999))
        assertEquals(1, solution3.addDigits(19))
    }
}