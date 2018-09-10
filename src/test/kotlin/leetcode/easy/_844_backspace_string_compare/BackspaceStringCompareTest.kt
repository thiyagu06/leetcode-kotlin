package leetcode.easy._844_backspace_string_compare

import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore

class BackspaceStringCompareTest {

    private val solution = Solution()
    private val followup = FollowUpSolution()

    @Test
    fun backspaceCompare() {
        assertTrue(solution.backspaceCompare(S = "ab#c", T = "ad#c"))
        assertTrue(solution.backspaceCompare(S = "ab##", T = "c#d#"))
        assertTrue(solution.backspaceCompare(S = "a##c", T = "#a#c"))
        assertFalse(solution.backspaceCompare(S = "a#c", T = "b"))
        assertFalse(solution.backspaceCompare(S = "ab##", T = "ccd#"))

    }

    // TODO
    @Ignore
    @Test
    fun backspaceCompareFollowUp() {
        assertTrue(followup.backspaceCompare(S = "ab#c", T = "ad#c"))
        assertTrue(followup.backspaceCompare(S = "ab##", T = "c#d#"))
        assertTrue(followup.backspaceCompare(S = "a##c", T = "#a#c"))
        assertFalse(followup.backspaceCompare(S = "a#c", T = "b"))
        assertFalse(followup.backspaceCompare(S = "ab##", T = "ccd#"))
    }
}