package leetcode.medium._022_generate_parentheses

import org.junit.Assert.*
import org.junit.Test

class GenerateParenthesesTest {

    private val solution = Solution()
    private val debugSolution = DebugSolution()

    private val expected3 = listOf("((()))", "(()())", "(())()", "()(())", "()()()")
    private val expected4 = listOf("(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())",
        "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"
    )
    private val expected5 = listOf("((((()))))", "(((()())))", "(((())()))", "(((()))())", "(((())))()",
        "((()(())))", "((()()()))", "((()())())", "((()()))()", "((())(()))", "((())()())", "((())())()",
        "((()))(())", "((()))()()", "(()((())))", "(()(()()))", "(()(())())", "(()(()))()", "(()()(()))",
        "(()()()())", "(()()())()", "(()())(())", "(()())()()", "(())((()))", "(())(()())", "(())(())()",
        "(())()(())", "(())()()()", "()(((())))", "()((()()))", "()((())())", "()((()))()", "()(()(()))",
        "()(()()())", "()(()())()", "()(())(())", "()(())()()", "()()((()))", "()()(()())", "()()(())()",
        "()()()(())", "()()()()()"
    )
    private val expected6 = listOf("(((((())))))", "((((()()))))", "((((())())))", "((((()))()))",
        "((((())))())", "((((()))))()", "(((()(()))))", "(((()()())))", "(((()())()))", "(((()()))())",
        "(((()())))()", "(((())(())))", "(((())()()))", "(((())())())", "(((())()))()", "(((()))(()))",
        "(((()))()())", "(((()))())()", "(((())))(())", "(((())))()()", "((()((()))))", "((()(()())))",
        "((()(())()))", "((()(()))())", "((()(())))()", "((()()(())))", "((()()()()))", "((()()())())",
        "((()()()))()", "((()())(()))", "((()())()())", "((()())())()", "((()()))(())", "((()()))()()",
        "((())((())))", "((())(()()))", "((())(())())", "((())(()))()", "((())()(()))", "((())()()())",
        "((())()())()", "((())())(())", "((())())()()", "((()))((()))", "((()))(()())", "((()))(())()",
        "((()))()(())", "((()))()()()", "(()(((()))))", "(()((()())))", "(()((())()))", "(()((()))())",
        "(()((())))()", "(()(()(())))", "(()(()()()))", "(()(()())())", "(()(()()))()", "(()(())(()))",
        "(()(())()())", "(()(())())()", "(()(()))(())", "(()(()))()()", "(()()((())))", "(()()(()()))",
        "(()()(())())", "(()()(()))()", "(()()()(()))", "(()()()()())", "(()()()())()", "(()()())(())",
        "(()()())()()", "(()())((()))", "(()())(()())", "(()())(())()", "(()())()(())", "(()())()()()",
        "(())(((())))", "(())((()()))", "(())((())())", "(())((()))()", "(())(()(()))", "(())(()()())",
        "(())(()())()", "(())(())(())", "(())(())()()", "(())()((()))", "(())()(()())", "(())()(())()",
        "(())()()(())", "(())()()()()", "()((((()))))", "()(((()())))", "()(((())()))", "()(((()))())",
        "()(((())))()", "()((()(())))", "()((()()()))", "()((()())())", "()((()()))()", "()((())(()))",
        "()((())()())", "()((())())()", "()((()))(())", "()((()))()()", "()(()((())))", "()(()(()()))",
        "()(()(())())", "()(()(()))()", "()(()()(()))", "()(()()()())", "()(()()())()", "()(()())(())",
        "()(()())()()", "()(())((()))", "()(())(()())", "()(())(())()", "()(())()(())", "()(())()()()",
        "()()(((())))", "()()((()()))", "()()((())())", "()()((()))()", "()()(()(()))", "()()(()()())",
        "()()(()())()", "()()(())(())", "()()(())()()", "()()()((()))", "()()()(()())", "()()()(())()",
        "()()()()(())", "()()()()()()"
    )

    @Test
    fun generateParenthesis() {
        assertEquals(listOf(""), solution.generateParenthesis(0))
        assertEquals(listOf("()"), solution.generateParenthesis(1))

        val result2 = solution.generateParenthesis(2)
        val expected2 = listOf("(())", "()()")
        assertEquals(expected2.size, result2.size)
        assertEquals(expected2.toSet(), result2.toSet())

        val result3 = solution.generateParenthesis(3)
        assertEquals(expected3.size, result3.size)
        assertEquals(expected3.toSet(), result3.toSet())

        val result4 = solution.generateParenthesis(4)
        assertEquals(expected4.size, result4.size)
        assertEquals(expected4.toSet(), result4.toSet())

        val result5 = solution.generateParenthesis(5)
        assertEquals(expected5.size, result5.size)
        assertEquals(expected5.toSet(), result5.toSet())

        val result6 = solution.generateParenthesis(6)
        assertEquals(expected6.size, result6.size)
        assertEquals(expected6.toSet(), result6.toSet())
    }

    @Test
    fun generateParenthesisDebug() {
        assertEquals(listOf(""), debugSolution.generateParenthesis(0))
        assertEquals(listOf("()"), debugSolution.generateParenthesis(1))

        val result2 = debugSolution.generateParenthesis(2)
        val expected2 = listOf("(())", "()()")
        assertEquals(expected2.size, result2.size)
        assertEquals(expected2.toSet(), result2.toSet())

        val result3 = debugSolution.generateParenthesis(3)
        assertEquals(expected3.size, result3.size)
        assertEquals(expected3.toSet(), result3.toSet())

        val result4 = debugSolution.generateParenthesis(4)
        assertEquals(expected4.size, result4.size)
        assertEquals(expected4.toSet(), result4.toSet())

        val result5 = debugSolution.generateParenthesis(5)
        assertEquals(expected5.size, result5.size)
        assertEquals(expected5.toSet(), result5.toSet())

        val result6 = debugSolution.generateParenthesis(6)
        assertEquals(expected6.size, result6.size)
        assertEquals(expected6.toSet(), result6.toSet())
    }
}