
import leetcode.medium._012_int_to_roman.Solution
import leetcode.medium._012_int_to_roman.SolutionTwo
import kotlin.test.assertEquals
import org.junit.Test

class IntToRomanTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun intToRoman() {
        assertEquals("III", solution.intToRoman(3))
        assertEquals("IV", solution.intToRoman(4))
        assertEquals("IX", solution.intToRoman(9))
        assertEquals("LVIII", solution.intToRoman(58))
        assertEquals("MCMXCIV", solution.intToRoman(1994))
    }

    @Test
    fun intToRoman2() {
        assertEquals("III", solution2.intToRoman(3))
        assertEquals("IV", solution2.intToRoman(4))
        assertEquals("IX", solution2.intToRoman(9))
        assertEquals("LVIII", solution2.intToRoman(58))
        assertEquals("MCMXCIV", solution2.intToRoman(1994))
    }
}