package leetcode.easy._013_roman_to_int

import org.junit.Test
import kotlin.test.assertEquals

class RomanToIntTest {
    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun romanToInt() {
        assertEquals(0, solution.romanToInt(""))
        assertEquals(1, solution.romanToInt("I"))
        assertEquals(2, solution.romanToInt("II"))
        assertEquals(3, solution.romanToInt("III"))
        assertEquals(4, solution.romanToInt("IV"))
        assertEquals(5, solution.romanToInt("V"))
        assertEquals(6, solution.romanToInt("VI"))
        assertEquals(7, solution.romanToInt("VII"))
        assertEquals(8, solution.romanToInt("VIII"))
        assertEquals(9, solution.romanToInt("IX"))
        assertEquals(10, solution.romanToInt("X"))
        assertEquals(3999, solution.romanToInt("MMMCMXCIX"))
    }

    @Test
    fun romanToInt2() {
        assertEquals(0, solution2.romanToInt(""))
        assertEquals(1, solution2.romanToInt("I"))
        assertEquals(2, solution2.romanToInt("II"))
        assertEquals(3, solution2.romanToInt("III"))
        assertEquals(4, solution2.romanToInt("IV"))
        assertEquals(5, solution2.romanToInt("V"))
        assertEquals(6, solution2.romanToInt("VI"))
        assertEquals(7, solution2.romanToInt("VII"))
        assertEquals(8, solution2.romanToInt("VIII"))
        assertEquals(9, solution2.romanToInt("IX"))
        assertEquals(10, solution2.romanToInt("X"))
        assertEquals(3999, solution2.romanToInt("MMMCMXCIX"))
    }
}
