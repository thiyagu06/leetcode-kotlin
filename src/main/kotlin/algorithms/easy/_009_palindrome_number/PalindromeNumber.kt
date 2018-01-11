package algorithms.easy._009_palindrome_number

import extensions.digits
import extensions.nMostSignificantDigits
import extensions.numberOfDigits
import kotlin.math.pow

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

        val digits = x.digits().map { it.toChar() }
        var middle = digits
        while (middle.isNotEmpty()) {
            if (middle.first() != middle.last())
                return false

            middle = middle.drop(1).dropLast(1)
        }
        return true
    }
}


class Solution2 {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false

        val digits = x.numberOfDigits()
        var leftDigit: Int
        var rightDigit: Int

        for (i in 1..(digits / 2)) {
            leftDigit = x.nMostSignificantDigits(i) % 10
            rightDigit = (x / 10.0.pow(i - 1)).toInt() % 10

            if (leftDigit != rightDigit) {
                return false
            }
        }

        return true
    }
}