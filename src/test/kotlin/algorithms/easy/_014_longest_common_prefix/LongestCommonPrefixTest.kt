package algorithms.easy._014_longest_common_prefix

import org.junit.Test

import org.junit.Assert.*

class LongestCommonPrefixTest {

    private val lcp = Solution()
    private val optLCP = OptimalSolution()

    @Test
    fun longestCommonPrefix() {
        assertEquals("", lcp.longestCommonPrefix(arrayOf()))
        assertEquals("abc", lcp.longestCommonPrefix(arrayOf("abcdef", "abcxyz")))
        assertEquals("a", lcp.longestCommonPrefix(arrayOf("abcdef", "abcxyz", "axyz")))
        assertEquals("", lcp.longestCommonPrefix(arrayOf("aca", "cba")))
    }

    @Test
    fun longestCommonPrefixTwoStrings() {
        assertEquals("abc", lcp.longestCommonPrefix("abcdef", "abcxyz"))
        assertEquals("", lcp.longestCommonPrefix("aca", "cba"))
    }

    @Test
    fun longestCommonPrefixOptimal() {
        assertEquals("", optLCP.longestCommonPrefix(arrayOf()))
        assertEquals("abc", optLCP.longestCommonPrefix(arrayOf("abcdef", "abcxyz")))
        assertEquals("a", optLCP.longestCommonPrefix(arrayOf("abcdef", "abcxyz", "axyz")))
        assertEquals("", lcp.longestCommonPrefix(arrayOf("aca", "cba")))
    }
}
