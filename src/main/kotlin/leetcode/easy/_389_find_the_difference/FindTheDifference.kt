package leetcode.easy._389_find_the_difference

import extensions.strings.characterFrequencies

/**
 * 389 - https://leetcode.com/problems/find-the-difference/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun findTheDifference(s: String, t: String): Char {
        val sFreq = s.characterFrequencies(caseSensitive = false)
        val tFreq = t.characterFrequencies(caseSensitive = false)

        t.forEach { c ->
            if ((tFreq[c] ?: 0) > (sFreq[c] ?: 0)) {
                return c
            }
        }

        throw IllegalArgumentException("No characters in t occur more frequently than in s. (s, t) = ($s, $t)")
    }
}