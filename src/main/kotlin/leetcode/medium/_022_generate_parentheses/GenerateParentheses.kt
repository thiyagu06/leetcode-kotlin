package leetcode.medium._022_generate_parentheses

import extensions.debug.printlnWithIndent

/**
 * 22 - https://leetcode.com/problems/generate-parentheses/description/
 */
class Solution {
    /**
     * Backtracking
     * https://leetcode.com/problems/generate-parentheses/discuss/10098/Java-DFS-way-solution
     *
     * Time: O(?)
     * Space: O(?)
     */
    fun generateParenthesis(n: Int): List<String> {
        val result = ArrayList<String>()
        generateOneByOne("", n, n, result)
        return result
    }

    private fun generateOneByOne(
        substring: String,
        openBraces: Int,
        closeBraces: Int,
        result: MutableList<String>,
        depth: Int = 0
    ) {
        // Opening braces should be added to the substring first, so if the # of openBraces > # of closeBraces,
        // there is a problem.
        if (openBraces > closeBraces) {
            return
        }

        if (openBraces == 0 && closeBraces == 0) {
            result.add(substring)
        }

        if (openBraces > 0) generateOneByOne("$substring(", openBraces - 1, closeBraces, result, depth + 1)

        if (closeBraces > 0) generateOneByOne("$substring)", openBraces, closeBraces - 1, result, depth + 1)
    }
}

class DebugSolution {
    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun generateParenthesis(n: Int): List<String> {
        val result = ArrayList<String>()
        generateOneByOne("", n, n, result)
        return result
    }

    private fun generateOneByOne(
        substring: String,
        openBraces: Int,
        closeBraces: Int,
        result: MutableList<String>,
        depth: Int = 0
    ) {
        printlnWithIndent(depth, "f(substring = $substring, (open, close) = ($openBraces, $closeBraces), result = $result")
        // Opening braces should be added to the substring first, so if the # of openBraces > # of closeBraces,
        // there is a problem.
        if (openBraces > closeBraces) {
            printlnWithIndent(depth, "openBraces > closeBraces (substring: $substring) -> return")
            return
        }

        if (openBraces == 0 && closeBraces == 0) {
            result.add(substring)
        }

        if (openBraces > 0) {
            printlnWithIndent(depth + 1, "\"$substring\" -> \"$substring(\"")
            generateOneByOne("$substring(", openBraces - 1, closeBraces, result, depth + 1)
        }

        if (closeBraces > 0) {
            printlnWithIndent(depth + 1, "\"$substring\" -> \"$substring)\"")
            generateOneByOne("$substring)", openBraces, closeBraces - 1, result, depth + 1)
        }
    }
}
