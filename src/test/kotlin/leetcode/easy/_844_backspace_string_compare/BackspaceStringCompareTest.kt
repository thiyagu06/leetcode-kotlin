package leetcode.easy._844_backspace_string_compare

import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

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

    @Ignore("Unimplemented")
    @Test
    fun backspaceCompareFollowUp() {
        assertTrue(followup.backspaceCompare(S = "ab#c", T = "ad#c"))
        assertTrue(followup.backspaceCompare(S = "ab##", T = "c#d#"))
        assertTrue(followup.backspaceCompare(S = "a##c", T = "#a#c"))
        assertFalse(followup.backspaceCompare(S = "a#c", T = "b"))
        assertFalse(followup.backspaceCompare(S = "ab##", T = "ccd#"))
    }
}