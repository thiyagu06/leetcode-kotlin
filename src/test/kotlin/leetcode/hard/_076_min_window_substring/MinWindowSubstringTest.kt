package leetcode.hard._076_min_window_substring

import kotlin.test.assertEquals
import org.junit.Test

class MinWindowSubstringTest {

    private val solution = Solution()

    @Test
    fun minWindow() {
        assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"))
        assertEquals("ACB", solution.minWindow("ABAACBAB", "ABC"))
        assertEquals("", solution.minWindow("A", "AA"))
        assertEquals("AA", solution.minWindow("AA", "AA"))
        assertEquals("", solution.minWindow("AA", "ZZ"))
        assertEquals("AXBYC", solution.minWindow("AXBYC", "ABC"))
        assertEquals("", solution.minWindow("aXBYC", "ABC"))
        assertEquals("", solution.minWindow("ab", "A"))
        assertEquals("abc", solution.minWindow("abc", "cba"))
        assertEquals("ba", solution.minWindow("bba", "ab"))
        assertEquals("", solution.minWindow("babb", "baba"))
        assertEquals("a", solution.minWindow("a", "a"))
    }
}