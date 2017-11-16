package algorithms.easy._387_first_unique_char_in_string

/**
 * 387 - https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * Note: You may assume the string contain only lowercase letters.
 *
 * @author nrojiani
 * @date 11/15/17
 */
class Solution {
    fun firstUniqChar(s: String): Int {
        val frequencies = s.groupingBy { it }.eachCount()
        return s.withIndex().firstOrNull { (i, c) ->
            frequencies[c] == 1
        }?.index ?: -1
    }
}