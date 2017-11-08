package algorithms.easy._013_roman_to_int

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author nrojiani
 * @date 11/7/17
 */
class RomanToIntTest {
    private val roman = Solution()

    @Test
    fun testRomanToInt() {
        assertEquals(0, roman.romanToInt(""))
        assertEquals(1, roman.romanToInt("I"))
        assertEquals(2, roman.romanToInt("II"))
        assertEquals(3, roman.romanToInt("III"))
        assertEquals(4, roman.romanToInt("IV"))
        assertEquals(5, roman.romanToInt("V"))
        assertEquals(6, roman.romanToInt("VI"))
        assertEquals(7, roman.romanToInt("VII"))
        assertEquals(8, roman.romanToInt("VIII"))
        assertEquals(9, roman.romanToInt("IX"))
        assertEquals(10, roman.romanToInt("X"))
        assertEquals(3999, roman.romanToInt("MMMCMXCIX"))
    }

}