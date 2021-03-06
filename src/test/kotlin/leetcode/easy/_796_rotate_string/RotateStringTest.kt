package leetcode.easy._796_rotate_string

import org.junit.Test

import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RotateStringTest {

    private val solution = Solution()

    @Test
    fun rotateString() {
        assertTrue(solution.rotateString("", ""))
        assertTrue(solution.rotateString("a", "a"))
        assertTrue(solution.rotateString("abcde", "cdeab"))
        assertFalse(solution.rotateString("a", "b"))
        assertFalse(solution.rotateString("abcde", "abced"))
    }
}