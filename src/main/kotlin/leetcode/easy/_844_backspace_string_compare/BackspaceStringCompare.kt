package leetcode.easy._844_backspace_string_compare

/**
 * 844 - https://leetcode.com/problems/backspace-string-compare/
 */
class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    fun backspaceCompare(S: String, T: String): Boolean = transcribe(S) == transcribe(T)

    private fun transcribe(inputString: String): String = inputString.fold("") { acc, c ->
        when (c) {
            '#' -> acc.dropLast(1)
            else -> acc + c
        }
    }
}

/**
 * Follow-up: Can you solve it in O(N) time and O(1) space?
 */
class FollowUpSolution {
    fun backspaceCompare(S: String, T: String): Boolean {
        TODO()
    }
}