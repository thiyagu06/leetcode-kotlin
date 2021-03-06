package leetcode.easy._541_reverse_string_ii

import org.junit.Test
import kotlin.test.assertEquals

class ReverseStringIITest {

    private val solution = Solution()

    @Test
    fun reverseStr() {
        assertEquals("bacdfeg", solution.reverseStr("abcdefg", 2))
        assertEquals("bacd", solution.reverseStr("abcd", 2))
    }
}
