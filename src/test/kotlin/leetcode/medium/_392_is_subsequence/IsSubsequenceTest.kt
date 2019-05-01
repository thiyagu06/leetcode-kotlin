package leetcode.medium._392_is_subsequence

import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.Test

class IsSubsequenceTest {

    private val solution = Solution()
    private val followup1 = FollowUpSolutionOne()
    private val followup2 = FollowUpSolutionTwo()

    @Test
    fun isSubsequence() {
        assertTrue(solution.isSubsequence(s = "abc", t = "ahbgdc"))
        assertFalse(solution.isSubsequence(s = "axc", t = "ahbgdc"))
        assertTrue(solution.isSubsequence(s = "abc", t = "ac".repeat(10000) + "bc"))
    }

    @Test
    fun isSubsequenceFollowup1() {
        assertTrue(followup1.isSubsequence(s = "abc", t = "ahbgdc"))
        assertFalse(followup1.isSubsequence(s = "axc", t = "ahbgdc"))
        assertTrue(followup1.isSubsequence(s = "abc", t = "ac".repeat(10000) + "bc"))
    }

    @Test
    fun isSubsequenceFollowup2() {
        assertTrue(followup2.isSubsequence(s = "abc", t = "ahbgdc"))
        assertFalse(followup2.isSubsequence(s = "axc", t = "ahbgdc"))
        assertTrue(followup2.isSubsequence(s = "abc", t = "ac".repeat(10000) + "bc"))
    }
}