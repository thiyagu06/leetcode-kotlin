package leetcode.medium._424_longest_repeating_char_replacement

import org.junit.Assert.*
import org.junit.Test

class LongestRepeatingCharReplacementTest {

    private val solution = Solution()

    @Test
    fun characterReplacement() {
        assertEquals(4, solution.characterReplacement(s = "ABAB", k = 2))
        assertEquals(4, solution.characterReplacement(s = "AABABBA", k = 1))
        assertEquals(3, solution.characterReplacement(s = "ABBCAB", k = 1))
        assertEquals(5, solution.characterReplacement(s = "ABBCAB", k = 2))
    }
}