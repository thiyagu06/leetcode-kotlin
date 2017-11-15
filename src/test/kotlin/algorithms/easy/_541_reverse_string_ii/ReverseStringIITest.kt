package algorithms.easy._541_reverse_string_ii

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author nrojiani
 * @date 11/14/17
 */
class ReverseStringIITest {

    private val solution = Solution()

    @Test
    fun reverseStr() {
        assertEquals("bacdfeg", solution.reverseStr("abcdefg", 2))
        assertEquals("bacd", solution.reverseStr("abcd", 2))
    }

}