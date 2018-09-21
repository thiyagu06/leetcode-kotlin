package leetcode.medium._005_longest_palindromic_substring

import org.junit.Assert.*
import org.junit.Test

class LongestPalindromicSubstringTest {

    private val solution = Solution()

    @Test
    fun longestPalindrome() {
        assertEquals("bab", solution.longestPalindrome("babad"))
        assertEquals("bb", solution.longestPalindrome("cbbd"))
    }
}