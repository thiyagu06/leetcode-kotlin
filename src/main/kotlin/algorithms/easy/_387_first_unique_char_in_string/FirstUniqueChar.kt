package algorithms.easy._387_first_unique_char_in_string

/**
 * 387 - https://leetcode.com/problems/first-unique-character-in-a-string/description/
 */
class Solution {
    fun firstUniqChar(s: String): Int {
        val frequencies = s.groupingBy { it }.eachCount()
        return s.withIndex().firstOrNull { (_, c) ->
            frequencies[c] == 1
        }?.index ?: -1
    }
}
