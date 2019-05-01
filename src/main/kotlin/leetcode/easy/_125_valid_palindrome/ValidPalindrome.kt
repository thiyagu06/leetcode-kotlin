package leetcode.easy._125_valid_palindrome

import extensions.strings.isPalindrome

/**
 * 125 - https://leetcode.com/problems/valid-palindrome/
 */
class Solution {
    /**
     * Time: O(n) - Two passes
     * Space: O(1)
     */
    fun isPalindrome(s: String): Boolean = s.fold("") { acc, c ->
        if (c.isLetterOrDigit()) acc + c.toLowerCase()
        else acc
    }.isPalindrome()
}


class SolutionTwo {
    /**
     * Time: O(n) - Single Pass
     * Space: O(1)
     */
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.lastIndex
        while (left < right) {
            when {
                !s[left].isLetterOrDigit() -> left++
                !s[right].isLetterOrDigit() -> right--
                !s[left].equals(s[right], ignoreCase = true) -> return false
                else -> {
                    left++
                    right--
                }
            }
        }

        return true
    }
}