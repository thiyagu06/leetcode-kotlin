package algorithms.medium._012_int_to_roman

import org.junit.Assert.*
import org.junit.Test

class IntToRomanTest {
    private val solution = Solution()

    @Test
    fun convertToRoman() {
        assertEquals("III", solution.convertToRoman(3))
        assertEquals("IV", solution.convertToRoman(4))
        assertEquals("IX", solution.convertToRoman(9))
        assertEquals("LVIII", solution.convertToRoman(58))
        assertEquals("MCMXCIV", solution.convertToRoman(1994))
    }
}