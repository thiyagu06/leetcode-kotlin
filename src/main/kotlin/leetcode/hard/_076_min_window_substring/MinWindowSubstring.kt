package leetcode.hard._076_min_window_substring

import extensions.strings.characterFrequencies

/**
 * 76 - https://leetcode.com/problems/minimum-window-substring/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun minWindow(s: String, t: String): String {
        if (s.length < t.length || s.isEmpty() || t.isEmpty()) return ""

        val tChars = hashMapOf<Char, Int>()
        t.forEach {
            tChars[it] = tChars.getOrDefault(it, 0) + 1
        }

        var found = 0
        var left = 0
        var right = 0
        var minSubstring = s

        while (right <= s.lastIndex) {
            // Check if it is a match.
            val charR = s[right]
            if (charR !in tChars) {
                right++
            } else {
                tChars[charR] = tChars[charR]!! - 1
                if (tChars[charR]!! >= 0) { // found shouldn't be incremented if we've found extras of that letter.
                    found++
                }

                // Check if all chars have been found
                if (found != t.length) {
                    right++
                } else {
                    val substr = s.substring(left..right)
                    if (substr.length < minSubstring.length) {
                        minSubstring = substr
                    }
                    val charL = s[left]
                    if (charL in tChars) {
                        tChars[charL] = tChars[charL]!! + 1
                        if (tChars[charL]!! > 0) {
                            found--     // reduce found only if not an extra
                        }
                    }
                    // charR is a match, and next iteration will re-add it to found. Reset.
                    found--
                    tChars[charR] = tChars[charR]!! + 1
                    // Evict left to see if a shorter substring still contains all chars.
                    left++
                }
            }
        }

        // If
        if (minSubstring == s) {
            val sCharFreqs = s.characterFrequencies()
            val tCharFreqs = t.characterFrequencies()
            val allInS = tCharFreqs.all { (char, freq) ->
                (sCharFreqs[char] ?: 0) >= freq
            }
            return if (allInS) s else ""
        }

        return minSubstring
    }
}