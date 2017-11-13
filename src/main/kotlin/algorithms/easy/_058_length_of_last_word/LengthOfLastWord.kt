package algorithms.easy._058_length_of_last_word

/**
 * 58 - https://leetcode.com/problems/length-of-last-word/description/
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * @author nrojiani
 * @date 11/12/17
 */
class Solution {
    fun lengthOfLastWord(s: String): Int =
        if (s.isBlank()) 0
        else s.split(" ")
                    .filter { it.isNotEmpty() }
                    .last()
                    .length
}