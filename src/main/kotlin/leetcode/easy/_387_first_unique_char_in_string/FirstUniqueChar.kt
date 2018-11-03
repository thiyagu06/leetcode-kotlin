package leetcode.easy._387_first_unique_char_in_string

import extensions.arrays.NOT_FOUND
import extensions.strings.characterFrequencies

/**
 * 387 - https://leetcode.com/problems/first-unique-character-in-a-string/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun firstUniqChar(s: String): Int {
        val frequencies = s.groupingBy { it }.eachCount()

        s.forEachIndexed { i, ch ->
            if (frequencies[ch]!! == 1) return i
        }

        return NOT_FOUND
    }
}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun firstUniqChar(s: String): Int {
        val frequencies = s.characterFrequencies()
        return s.withIndex().firstOrNull { (_, c) ->
            frequencies[c] == 1
        }?.index ?: NOT_FOUND
    }
}