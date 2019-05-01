package leetcode.easy._014_longest_common_prefix

import kotlin.test.assertEquals
import org.junit.Test

class LongestCommonPrefixTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val optimal = OptimalSolution()

    @Test
    fun longestCommonPrefix() {
        assertEquals("fl", solution.longestCommonPrefix(arrayOf("flower", "flow", "flight")))
        assertEquals("", solution.longestCommonPrefix(arrayOf()))
        assertEquals("abc", solution.longestCommonPrefix(arrayOf("abcdef", "abcxyz")))
        assertEquals("kotlin", solution.longestCommonPrefix(arrayOf("kotlin")))
        assertEquals("a", solution.longestCommonPrefix(arrayOf("abcdef", "abcxyz", "axyz")))
        assertEquals("abc", solution.longestCommonPrefix(arrayOf("abc")))
        assertEquals("", solution.longestCommonPrefix(arrayOf("aca", "cba")))
    }

    @Test
    fun longestCommonPrefix2() {
        assertEquals("fl", solution2.longestCommonPrefix(arrayOf("flower", "flow", "flight")))
        assertEquals("", solution2.longestCommonPrefix(arrayOf()))
        assertEquals("abc", solution2.longestCommonPrefix(arrayOf("abcdef", "abcxyz")))
        assertEquals("kotlin", solution2.longestCommonPrefix(arrayOf("kotlin")))
        assertEquals("a", solution2.longestCommonPrefix(arrayOf("abcdef", "abcxyz", "axyz")))
        assertEquals("abc", solution2.longestCommonPrefix(arrayOf("abc")))
        assertEquals("", solution2.longestCommonPrefix(arrayOf("aca", "cba")))
    }

    @Test
    fun longestCommonPrefixOptimal() {
        assertEquals("fl", optimal.longestCommonPrefix(arrayOf("flower", "flow", "flight")))
        assertEquals("", optimal.longestCommonPrefix(arrayOf()))
        assertEquals("abc", optimal.longestCommonPrefix(arrayOf("abcdef", "abcxyz")))
        assertEquals("kotlin", optimal.longestCommonPrefix(arrayOf("kotlin")))
        assertEquals("a", optimal.longestCommonPrefix(arrayOf("abcdef", "abcxyz", "axyz")))
        assertEquals("", optimal.longestCommonPrefix(arrayOf("aca", "cba")))
    }
}
