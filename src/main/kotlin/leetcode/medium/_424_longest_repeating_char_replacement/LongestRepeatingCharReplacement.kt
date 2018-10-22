package leetcode.medium._424_longest_repeating_char_replacement

import kotlin.math.max

/**
 * 424 - https://leetcode.com/problems/longest-repeating-character-replacement
 */
class Solution {
    /**
     * Based on [this Python solution](http://tinyurl.com/yae2alhh).
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun characterReplacement(s: String, k: Int): Int {
        val count = HashMap<Char, Int>()
        var mostFreqCount = 0   // the # of the most frequent char
        var longestWindow = 0       // stores the length of the longest substring
        var left = 0

        (0..s.lastIndex).forEach { right ->
            count[s[right]] = (count[s[right]] ?: 0) + 1
            mostFreqCount = max(mostFreqCount, count[s[right]]!!)

            /* # !mostFreqChar = # chars in window - # most frequent */
            val replacementsNeeded = (right - left + 1) - mostFreqCount
            if (replacementsNeeded > k) {     // evict leftmost
                count[s[left]] = count[s[left]]!! - 1
                left++
            }
            longestWindow = max(longestWindow, right - left + 1)
        }

        return longestWindow
    }
}

class SolutionTwo {
    /**
     * Using Sliding-Window technique
     * Time: O(?)
     * Space: O(?)
     */
    fun characterReplacement(s: String, k: Int): Int {
        val counts: MutableMap<Char, Int> = hashMapOf()
        var mostFreqCount = 0
        var maxLength = 0
        var left = 0
        var right = 0

        while (right <= s.lastIndex) {
            val charR = s[right]
            counts[charR] = counts.getOrDefault(charR, 0) + 1
            mostFreqCount = max(mostFreqCount, counts[charR]!!)
            val windowLength = right - left + 1
            val replacementsNeeded = windowLength - mostFreqCount
            if (replacementsNeeded <= k) {
                // expand window
                right++
                maxLength = max(maxLength, windowLength)
            } else {
                // evict leftmost char
                val charL = s[left]
                counts[charL] = counts[charL]!! - 1
                counts[charR] = counts[charR]!! - 1     // will be re-added next iteration.
                if (mostFreqCount == counts[charR]!!) mostFreqCount--   // reset mostFreqCount
                left++
            }
        }

        return maxLength
    }
}
