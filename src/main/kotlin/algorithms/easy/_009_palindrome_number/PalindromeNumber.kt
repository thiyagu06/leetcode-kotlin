package algorithms.easy._009_palindrome_number

import extensions.digitsAsChars

/**
 * 9 - https://leetcode.com/problems/palindrome-number/description/
 *
 * Note: Negative numbers not considered palindromes.
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false

        val digits = x.digitsAsChars()
        var middle = digits
        while (middle.isNotEmpty()) {
            if (middle.first() != middle.last())
                return false
            middle = middle.drop(1).dropLast(1)
        }
        return true
    }
}
