package leetcode.medium._005_longest_palindromic_substring

import extensions.chars.repeated
import extensions.strings.repeated
import kotlin.test.assertEquals
import org.junit.Test
import kotlin.test.assertTrue

class LongestPalindromicSubstringTest {

    private val solution = Solution()
    private val bigInput = 'a'.repeated(1000)
    private val bigInput2 = "ab".repeated(499) + 'a'

    @Test
    fun longestPalindrome() {
        assertEquals("", solution.longestPalindrome(""))
        assertEquals("a", solution.longestPalindrome("a"))
        assertTrue(solution.longestPalindrome("ab") in setOf("a", "b"))
        assertTrue(solution.longestPalindrome("babad") in setOf("bab", "aba"))
        assertEquals("bb", solution.longestPalindrome("cbbd"))
        assertEquals("abcba", solution.longestPalindrome("abcba"))
        assertEquals("bcb", solution.longestPalindrome("abcbz"))
        assertEquals("a", solution.longestPalindrome("abcda"))
        assertEquals("anana", solution.longestPalindrome("banana"))
        assertEquals(bigInput, solution.longestPalindrome(bigInput))
        assertEquals(bigInput2, solution.longestPalindrome(bigInput2))
    }
}