package algorithms.easy._014_longest_common_prefix

import org.junit.Assert.assertEquals
import org.junit.Test

class LongestCommonPrefixTest {

    private val solution = Solution()
    private val optimal = OptimalSolution()

    @Test
    fun longestCommonPrefix() {
        assertEquals("", solution.longestCommonPrefix(arrayOf()))
        assertEquals("abc", solution.longestCommonPrefix(arrayOf("abcdef", "abcxyz")))
        assertEquals("kotlin", solution.longestCommonPrefix(arrayOf("kotlin")))
        assertEquals("a", solution.longestCommonPrefix(arrayOf("abcdef", "abcxyz", "axyz")))
        assertEquals("", solution.longestCommonPrefix(arrayOf("aca", "cba")))
    }

    @Test
    fun longestCommonPrefixTwoStrings() {
        assertEquals("abc", solution.longestCommonPrefix("abcdef", "abcxyz"))
        assertEquals("", solution.longestCommonPrefix("aca", "cba"))
    }

    @Test
    fun longestCommonPrefixOptimal() {
        assertEquals("", optimal.longestCommonPrefix(arrayOf()))
        assertEquals("abc", optimal.longestCommonPrefix(arrayOf("abcdef", "abcxyz")))
        assertEquals("kotlin", optimal.longestCommonPrefix(arrayOf("kotlin")))
        assertEquals("a", optimal.longestCommonPrefix(arrayOf("abcdef", "abcxyz", "axyz")))
        assertEquals("", optimal.longestCommonPrefix(arrayOf("aca", "cba")))
    }
}
