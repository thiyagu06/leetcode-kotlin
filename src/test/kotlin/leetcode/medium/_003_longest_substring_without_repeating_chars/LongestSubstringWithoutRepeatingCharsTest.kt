package leetcode.medium._003_longest_substring_without_repeating_chars

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LongestSubstringWithoutRepeatingCharsTest {

    private val solution = Solution()

    @Test
    fun lengthOfLongestSubstring() {
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"))
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"))
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"))
    }

    @Test
    fun longestSubstringWithoutRepeating() {
        assertEquals("abc", solution.longestSubstringWithoutRepeating("abcabcbb"))
        assertEquals("b", solution.longestSubstringWithoutRepeating("bbbbb"))
        assertTrue(solution.longestSubstringWithoutRepeating("pwwkew") in setOf("wke", "kew"))
    }
}