package leetcode.medium._003_longest_substring_without_repeating_chars

import kotlin.test.assertEquals
import org.junit.Test

class LongestSubstringWithoutRepeatingCharsTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun lengthOfLongestSubstring() {
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"))
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"))
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"))
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkewwwwwwwwwwwwwwwww"))
        assertEquals(6, solution.lengthOfLongestSubstring("abcABC"))
    }

    @Test
    fun lengthOfLongestSubstring2() {
        assertEquals(3, solution2.lengthOfLongestSubstring("abcabcbb"))
        assertEquals(1, solution2.lengthOfLongestSubstring("bbbbb"))
        assertEquals(3, solution2.lengthOfLongestSubstring("pwwkew"))
        assertEquals(3, solution2.lengthOfLongestSubstring("pwwkewwwwwwwwwwwwwwwww"))
        assertEquals(6, solution2.lengthOfLongestSubstring("abcABC"))
    }
}