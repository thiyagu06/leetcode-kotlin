package leetcode.easy._020_valid_parentheses

import java.util.ArrayDeque
import java.util.Deque

/**
 * 20 - https://leetcode.com/problems/valid-parentheses/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun isValid(s: String): Boolean {
        if (s.isEmpty()) return true

        val stack: Deque<Char> = ArrayDeque()
        s.forEach { c ->
            when {
                c.isOpeningBrace() -> stack.push(c)
                c.isClosingBrace() ->
                    if (stack.isEmpty() || !c.isClosingBraceFor(stack.pop())) {
                        return false
                    }
            }
        }
        return stack.isEmpty()
    }

    private fun Char.isOpeningBrace(): Boolean = this in setOf('(', '[', '{')
    private fun Char.isClosingBrace(): Boolean = this in setOf(')', ']', '}')
    private fun Char.isClosingBraceFor(openingBrace: Char): Boolean = when (this to openingBrace) {
        ')' to '(' -> true
        ']' to '[' -> true
        '}' to '{' -> true
        else -> false
    }
}
