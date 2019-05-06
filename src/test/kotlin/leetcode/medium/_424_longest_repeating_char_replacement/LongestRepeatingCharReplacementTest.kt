package leetcode.medium._424_longest_repeating_char_replacement

import org.junit.Test
import kotlin.test.assertEquals

class LongestRepeatingCharReplacementTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun characterReplacement() {
        assertEquals(1, solution.characterReplacement(s = "A", k = 0))
        assertEquals(1, solution.characterReplacement(s = "A", k = 1))
        assertEquals(2, solution.characterReplacement(s = "AA", k = 0))
        assertEquals(2, solution.characterReplacement(s = "AA", k = 1))
        assertEquals(1, solution.characterReplacement(s = "AB", k = 0))
        assertEquals(2, solution.characterReplacement(s = "AB", k = 1))
        assertEquals(4, solution.characterReplacement(s = "ABAB", k = 2))
        assertEquals(4, solution.characterReplacement(s = "AABABBA", k = 1))
        assertEquals(3, solution.characterReplacement(s = "ABBCAB", k = 1))
        assertEquals(5, solution.characterReplacement(s = "ABBCAB", k = 2))
    }

    @Test
    fun characterReplacement2() {
        assertEquals(1, solution2.characterReplacement(s = "A", k = 0))
        assertEquals(1, solution2.characterReplacement(s = "A", k = 1))
        assertEquals(2, solution2.characterReplacement(s = "AA", k = 0))
        assertEquals(2, solution2.characterReplacement(s = "AA", k = 1))
        assertEquals(1, solution2.characterReplacement(s = "AB", k = 0))
        assertEquals(2, solution2.characterReplacement(s = "AB", k = 1))
        assertEquals(4, solution2.characterReplacement(s = "ABAB", k = 2))
        assertEquals(4, solution2.characterReplacement(s = "AABABBA", k = 1))
        assertEquals(3, solution2.characterReplacement(s = "ABBCAB", k = 1))
        assertEquals(5, solution2.characterReplacement(s = "ABBCAB", k = 2))
    }
}