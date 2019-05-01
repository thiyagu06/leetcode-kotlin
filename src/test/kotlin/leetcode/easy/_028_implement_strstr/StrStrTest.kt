package leetcode.easy._028_implement_strstr

import org.junit.Assert.assertEquals
import org.junit.Test

class StrStrTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    @Test
    fun strStr() {
        assertEquals(2, solution.strStr(haystack = "hello", needle = "ll"))
        assertEquals(0, solution.strStr(haystack = "hello", needle = ""))
        assertEquals(-1, solution.strStr(haystack = "aaaaa", needle = "bba"))
    }

    @Test
    fun strStr2() {
        assertEquals(2, solution2.strStr(haystack = "hello", needle = "ll"))
        assertEquals(0, solution2.strStr(haystack = "hello", needle = ""))
        assertEquals(-1, solution2.strStr(haystack = "aaaaa", needle = "bba"))
    }

    @Test
    fun strStr3() {
        assertEquals(2, solution3.strStr(haystack = "hello", needle = "ll"))
        assertEquals(0, solution3.strStr(haystack = "hello", needle = ""))
        assertEquals(-1, solution3.strStr(haystack = "aaaaa", needle = "bba"))
    }
}