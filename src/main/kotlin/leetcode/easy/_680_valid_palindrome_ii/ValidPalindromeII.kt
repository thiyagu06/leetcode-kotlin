package leetcode.easy._680_valid_palindrome_ii

/**
 * 680 - https://leetcode.com/problems/valid-palindrome-ii/
 */
class Solution {
    fun validPalindrome(s: String): Boolean = isValidPalindrome(s, s.indices)

    /**
     * Time: O(n)
     * Space: O(1)
     */
    private fun isValidPalindrome(s: String, indexRange: IntRange, tolerance: Int = 1): Boolean {
        if (indexRange.isEmpty())
            return true

        var i = indexRange.start
        var j = indexRange.endInclusive

        while (i < j) {
            if (s[i] != s[j]) {
                return if (tolerance == 0) false
                else isValidPalindrome(s, i until j, 0) || isValidPalindrome(s, (i + 1)..j, 0)
            }
            i++
            j--
        }

        return true
    }
}