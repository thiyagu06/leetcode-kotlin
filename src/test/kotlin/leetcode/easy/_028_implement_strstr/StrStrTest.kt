package leetcode.easy._028_implement_strstr

import org.junit.Test

import org.junit.Assert.*

class StrStrTest {

    private val solution = Solution()
    private val solutionNoLib = SolutionWithoutLibraryMethods()

    @Test
    fun strStr() {
        assertEquals(2, solution.strStr("hello", "ll"))
        assertEquals(-1, solution.strStr("aaaaa", "bba"))
    }

    @Test
    fun strStrNoLib() {
        assertEquals(2, solutionNoLib.strStr("hello", "ll"))
        assertEquals(-1, solutionNoLib.strStr("aaaaa", "bba"))
    }
}