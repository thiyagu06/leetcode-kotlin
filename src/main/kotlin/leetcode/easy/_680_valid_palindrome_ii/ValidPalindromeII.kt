package leetcode.easy._680_valid_palindrome_ii

/**
 * 680 - https://leetcode.com/problems/valid-palindrome-ii/description/
 */
class Solution {
    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun validPalindrome(s: String, missedOnce: Boolean = false): Boolean {
        var i = 0
        var j = s.lastIndex
        while (i <= j) {
            if (s[i] != s[j]) {
                return if (missedOnce)
                    false
                else validPalindrome(s.substring(i + 1..j), true) || validPalindrome(s.substring(i until j), true)
            }
            i++
            j--
        }

        return true
    }
}

// optimization: don't copy string (length can be up to 50000). use index range.
class Solution2 {
    /**
     * Time: O(n) - where n is the # of characters in the string
     * Space: O(1) - max 1 recursive call
     */
    fun validPalindrome(s: String, indices: IntRange = (0..s.lastIndex), missedOnce: Boolean = false): Boolean {
        var i = indices.start
        var j = indices.endInclusive
        while (i <= j) {
            if (s[i] != s[j]) {
                return if (missedOnce)
                    false
                else validPalindrome(s, indices = (i + 1..j), missedOnce = true)
                        || validPalindrome(s, indices = (i until j), missedOnce = true)
            }
            i++
            j--
        }

        return true
    }
}