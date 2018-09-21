package leetcode.easy._387_first_unique_char_in_string

import extensions.arrays.NOT_FOUND
import extensions.strings.characterFrequencies

/**
 * 387 - https://leetcode.com/problems/first-unique-character-in-a-string/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun firstUniqChar(s: String): Int {
        val charFrequencies = s.fold(mutableMapOf<Char, Int>()) { acc, c ->
            acc[c] = (acc[c] ?: 0) + 1
            acc
        }
        // or val charFrequencies = s.characterFrequencies()

        s.forEachIndexed { i, c ->
            if (charFrequencies[c] == 1) {
                return i
            }
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
        }?.index ?: -1
    }
}