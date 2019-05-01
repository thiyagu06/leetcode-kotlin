package leetcode.easy._020_valid_parentheses

import org.junit.Test

import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidParenthesesTest {

    private val solution = Solution()

    @Test
    fun isValid() {
        assertTrue(solution.isValid(""))
        assertTrue(solution.isValid("()"))
        assertTrue(solution.isValid("()[]{}"))
        assertTrue(solution.isValid("{[]}"))

        assertFalse(solution.isValid("([)]"))
        assertFalse(solution.isValid("(]"))
        assertFalse(solution.isValid("("))
        assertFalse(solution.isValid("]"))
    }
}