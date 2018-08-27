package leetcode.easy._557_reverse_words_in_string_III

/**
 * 557 - https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 *
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun reverseWords(s: String): String = s.split(" ").joinToString(" ", transform = { it.reversed() })
}
