package leetcode.easy._125_valid_palindrome

/**
 * 125 - https://leetcode.com/problems/valid-palindrome/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.lastIndex
        while (i < j) {
            when {
                !s[i].isLetterOrDigit() -> i++
                !s[j].isLetterOrDigit() -> j--
                s[i].toLowerCase() != s[j].toLowerCase() -> return false
                else -> {
                    i++
                    j--
                }
            }
        }

        return true
    }
}


class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun isPalindrome(s: String): Boolean {
        val stripped = s.filter { it.isLetterOrDigit() }
        val indices = stripped.indices
        indices.zip(indices.reversed()).forEach { (i, j) ->
            if (i >= j) return true
            if (stripped[i].toLowerCase() != stripped[j].toLowerCase()) return false
        }

        return true
    }
}