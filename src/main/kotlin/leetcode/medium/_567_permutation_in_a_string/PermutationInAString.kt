package leetcode.medium._567_permutation_in_a_string

import extensions.strings.characterFrequencies

/**
 * 567 - https://leetcode.com/problems/permutation-in-string
 */
class Solution {
    /**
     * Time: O(n) - where n is the length of s2
     * Space: O(n)
     */
    fun checkInclusion(s1: String, s2: String): Boolean {
        val s1CharFreqs: Map<Char, Int> = s1.groupingBy { it }.eachCount()
        var remainingChars: MutableMap<Char, Int> = s1CharFreqs.toMutableMap()
        var found = 0
        var l = 0
        var r = 0

        while (r <= s2.lastIndex && found < s1.length) {
            val charR = s2[r]
            when {
                // charR is in s1, and we haven't found all of that letter in s2.
                charR in remainingChars && remainingChars[charR]!! > 0 -> {
                    remainingChars[charR] = remainingChars[charR]!! - 1
                    found++
                    r++
                }

                // charR is in s1, but we've already found all occurrences of it in s2
                charR in remainingChars && remainingChars[charR]!! == 0 -> {
                    val charL = s2[l]
                    remainingChars[charL] = remainingChars.getValue(charL) + 1
                    found--
                    l++
                }

                // charR not in s2. Window can't be a permutation of s1 if it contains any
                // chars that aren't in s2, so evict the entire window.
                charR !in remainingChars -> {
                    remainingChars = s1CharFreqs.toMutableMap()
                    found = 0
                    r++
                    l = r
                }
            }
        }

        return found == s1.length
    }
}

class SolutionTwo {
    /**
     * Same as the solution above, uses if instead of when
     *
     * Time: O(?)
     * Space: O(?)
     */
    fun checkInclusion(s1: String, s2: String): Boolean {
        var count = s1.length
        val n = s2.length
        val hash = s1.characterFrequencies().toMutableMap()
        var leftIdx = 0
        var rightIdx = 0

        var loops = 0
        while (count > 0 && leftIdx < n && rightIdx < n) {
            val (charL, charR) = (s2[leftIdx] to s2[rightIdx])
            // charR is in s1, and is not "overused" in current window.
            // modify hash & count, and expand window to the right.
            if (charR in hash && hash[charR]!! > 0) {
                count--
                hash[charR] = hash[charR]!! - 1
                rightIdx++
            } else {
                // Two Possibilities:
                // 1. charR isn't in hash (i.e., not in s1)
                // 2. charR is in hash, but overused (hash[charR] <= 0)
                // For either, evict charL and shorten window (leftIdx++)

                if (charL in hash) {
                    // If charL was in hash, modify hash & count since its no longer in the window.
                    count++
                    hash[charL] = hash[charL]!! + 1
                } else {
                    rightIdx++     // move to next r only if charL not in hash (window size is 1)
                }
                leftIdx++           // evict charL & shorten the window.
            }
            loops++
        }

        return count == 0
    }
}

class SolutionThree {
    /**
     * Approach 6:
     * https://leetcode.com/problems/permutation-in-string/solution/
     *
     * Time: O(l1 + (l2 - l1))
     * Space: O(1)
     */
    fun checkInclusion(s1: String, s2: String): Boolean {
        val l1 = s1.length
        val l2 = s2.length

        var loops = 0

        if (l1 > l2) return false

        val s1Map = IntArray(26)
        val s2Map = IntArray(26)

        (0..s1.lastIndex).forEach { i ->
            s1Map[s1[i].alphaIndex]++
            s2Map[s2[i].alphaIndex]++
            loops++
        }

        var count = 0

        (0 until 26).forEach { i ->
            if (s1Map[i] == s2Map[i]) {
                count++
            }
            loops++
        }

        (0 until (l2 - l1)).forEach { i ->
            // int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            val r = s2[i + l1].alphaIndex
            val l = s2[i].alphaIndex

            if (count == 26) {
                return true
            }

            s2Map[r]++
            if (s2Map[r] == s1Map[r])
                count++
            else if (s2Map[r] == s1Map[r] + 1)
                count--

            s2Map[l]--
            if (s2Map[l] == s1Map[l])
                count++
            else if (s2Map[l] == s1Map[l] - 1)
                count--

            loops++
        }

        return count == 26
    }

    private val Char.alphaIndex get() = this - 'a'
}