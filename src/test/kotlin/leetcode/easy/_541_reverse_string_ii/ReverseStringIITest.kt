package leetcode.easy._541_reverse_string_ii

import kotlin.test.assertEquals
import org.junit.Test

class ReverseStringIITest {

    private val solution = Solution()

    @Test
    fun reverseStr() {
        assertEquals("bacdfeg", solution.reverseStr("abcdefg", 2))
        assertEquals("bacd", solution.reverseStr("abcd", 2))
    }
}
