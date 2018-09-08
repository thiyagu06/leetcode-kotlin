package algorithms.easy._020_valid_parentheses

import org.junit.Test

import org.junit.Assert.*

class ValidParenthesesTest {

    private val solution = Solution()

    @Test
    fun isValid() {
        assertTrue(solution.isValid("()"))
        assertTrue(solution.isValid("()[]{}"))
        assertFalse(solution.isValid("(]"))
        assertFalse(solution.isValid("([)]"))
        assertTrue(solution.isValid("{[]}"))
    }
}