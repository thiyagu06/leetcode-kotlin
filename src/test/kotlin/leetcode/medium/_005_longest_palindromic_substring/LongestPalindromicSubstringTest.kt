package leetcode.medium._005_longest_palindromic_substring

import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Test

class LongestPalindromicSubstringTest {

    private val solution = Solution()

    @Ignore // Not Implemented
    @Test
    fun longestPalindrome() {
        assertEquals("bab", solution.longestPalindrome("babad"))
        assertEquals("bb", solution.longestPalindrome("cbbd"))
    }
}