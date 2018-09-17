package leetcode.hard._076_min_window_substring

import org.junit.Test

import org.junit.Assert.*

class MinWindowSubstringTest {

    private val solution = Solution()

    @Test
    fun minWindow() {
        assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"))
    }
}