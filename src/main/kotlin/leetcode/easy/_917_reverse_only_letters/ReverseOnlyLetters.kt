package leetcode.easy._917_reverse_only_letters

import extensions.arrays.swap

/**
 * 917 - https://leetcode.com/problems/reverse-only-letters
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun reverseOnlyLetters(S: String): String {
        val chars = S.toCharArray()
        var i = 0
        var j = S.lastIndex

        while (i < j) {
            when {
                S[i].isLetter() && S[j].isLetter() -> chars.swap(i++, j--)
                !S[i].isLetter() -> i++
                !S[j].isLetter() -> j--
            }
        }

        return String(chars)
    }
}