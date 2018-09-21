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
        var longest = 0
        var l = 0   // left index
        var r = 0   // right index
        val substrChars = HashSet<Char>()

        while (l < n && r < n) {
            if (s[r] !in substrChars) {
                // add to set
                substrChars += s[r]
                r++
                longest = max(longest, substrChars.size)    // or max(longest, r - l), if r already incremented.
            } else {
                // Evict leftmost char
                substrChars -= s[l]
                l++
            }
        }

        return longest
    }
}
