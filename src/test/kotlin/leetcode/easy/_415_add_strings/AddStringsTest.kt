package leetcode.easy._415_add_strings

import org.junit.Assert.assertEquals
import org.junit.Test

class AddStringsTest {

    private val solution = Solution()

    @Test
    fun addStrings() {
        assertEquals("0", solution.addStrings("0", "0"))
        assertEquals("1", solution.addStrings("0", "1"))
        assertEquals("1", solution.addStrings("1", "0"))
        assertEquals("2", solution.addStrings("1", "1"))
        assertEquals("9", solution.addStrings("1", "8"))
        assertEquals("10", solution.addStrings("1", "9"))
        assertEquals("22", solution.addStrings("11", "11"))
        assertEquals("100", solution.addStrings("1", "99"))
        assertEquals("99", solution.addStrings("50", "49"))
        assertEquals("100", solution.addStrings("50", "50"))
        assertEquals("124", solution.addStrings("123", "1"))
        assertEquals("1333", solution.addStrings("1234", "99"))
    }
}