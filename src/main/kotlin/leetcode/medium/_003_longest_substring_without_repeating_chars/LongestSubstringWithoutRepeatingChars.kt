package leetcode.medium._003_longest_substring_without_repeating_chars

import kotlin.math.max

class Solution {
    /**
     * Naive Solution - exceeds time limit
     * Time: O(n^3)
     * Space: O(min(n, m)) - where n is s.length, m is the size of charset/alphabet
     */
    fun lengthOfLongestSubstring(s: String): Int {
        val n = s.length
        var longestNonRepeating = 0
        (0 until n).forEach { i ->
            ((i + 1)..n).forEach { j ->
                if (allUnique(s, i, j)) {
                    longestNonRepeating = max(longestNonRepeating, j - i)
                }
            }
        }
        return longestNonRepeating
    }

    private fun allUnique(s: String, start: Int, end: Int): Boolean {
        val chars = hashSetOf<Char>()
        (start until end).forEach { i ->
            val ch = s[i]
            if (chars.contains(ch)) {
                return false
            }
            chars.add(ch)
        }
        return true
    }
}

class SolutionTwo {
    /**
     * Uses Sliding Window technique
     * Time: O(n)
     * Space: O(min(n, m)) - O(k) needed for windowChars, where n is s.length, m is the size of charset/alphabet
     */
    fun lengthOfLongestSubstring(s: String): Int {
        val n = s.length
        val windowChars = HashSet<Char>()
        var longest = 0
        var i = 0
        var j = 0

        while (i < n && j < n) {
            // Try to extend the range [i, j]
            if (!windowChars.contains(s[j])) {
                windowChars.add(s[j++])
                longest = max(longest, j - i)
            } else {
                windowChars.remove(s[i++])
            }
        }

        return longest
    }
}