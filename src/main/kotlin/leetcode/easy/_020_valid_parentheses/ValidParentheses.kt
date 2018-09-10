package leetcode.easy._020_valid_parentheses

/**
 * 20 - https://leetcode.com/problems/valid-parentheses/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun isValid(s: String): Boolean =
            s.fold(emptyList<Bracket?>()) { stack, char ->
                when {
                    char.isOpeningBracket() -> stack + Bracket.fromChar(char)
                    char.isClosingBracket() -> {
                        if (stack.isEmpty() || stack.last() != Bracket.fromChar(char))
                            return false
                        stack.dropLast(1)
                    }
                    else -> stack
                }
            }.isEmpty()
}

enum class Bracket(val braces: Pair<Char, Char>) {
    PARENTHESES('(' to ')'),
    CURLY('{' to '}'),
    SQUARE('[' to ']');

    companion object {
        fun fromChar(c: Char): Bracket? {
            val matches = fun Char.(bracket: Bracket): Boolean = this in bracket.braces.toList()
            return when {
                c.matches(SQUARE) -> SQUARE
                c.matches(CURLY) -> CURLY
                c.matches(PARENTHESES) -> PARENTHESES
                else -> null
            }
        }
    }
}

private fun Char.isOpeningBracket() = Bracket.values().any { it.braces.first == this }
private fun Char.isClosingBracket() = Bracket.values().any { it.braces.second == this }
