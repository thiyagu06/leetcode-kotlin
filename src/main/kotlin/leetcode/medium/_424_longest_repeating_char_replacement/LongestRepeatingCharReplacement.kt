package leetcode.medium._424_longest_repeating_char_replacement

import kotlin.math.max

/**
 * 424 - https://leetcode.com/problems/longest-repeating-character-replacement
 */
class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val count = HashMap<Char, Int>()
        var mostFreqCharCount = 0   // the # of the most frequent char
        var longestWindow = 0       // stores the length of the longest substring
        var start = 0

        (0..s.lastIndex).forEach { end ->
            count[s[end]] = (count[s[end]] ?: 0) + 1
            mostFreqCharCount = max(mostFreqCharCount, count[s[end]]!!)

            /* # !mostFreqChar = # chars in window - # most frequent */
            val numDifferent = (end - start + 1) - mostFreqCharCount
            if (numDifferent > k) {     // evict leftmost
                count[s[start]] = count[s[start]]!! - 1
                start++
            }
            longestWindow = max(longestWindow, end - start + 1)
        }

        return longestWindow
    }
}