package leetcode.easy._696_count_binary_substrings

import extensions.math.isOdd
import kotlin.math.min

/**
 * 696 - https://leetcode.com/problems/count-binary-substrings
 */
class Solution {
    /**
     * Exceeds Time Limit
     */
    fun countBinarySubstrings(s: String): Int {
        var valid = 0
        for (i in s.indices) {
            for (j in i..s.lastIndex) {
                if (isValid(s, i..j)) valid++
            }
        }
        return valid
    }

    /**
     * Can't pass substring as parameter - will exceed memory size
     */
    internal fun isValid(s: String, range: IntRange = s.indices): Boolean {
        if (range.isEmpty()) return true
        val rangeLength = (range.endInclusive - range.start) + 1
        if (rangeLength.isOdd) return false

        var zeroes = 0
        var ones = 0
        var currentSection = s[range.start]
        var sectionsSeen = 1

        for (i in range) {
            when (s[i]) {
                currentSection -> if (s[i] == '0') zeroes++ else ones++
                else -> {
                    currentSection = s[i]
                    if (s[i] == '0') zeroes++ else ones++
                    if (++sectionsSeen > 2) return false
                }
            }
        }

        return zeroes == ones
    }
}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(1)
     *
     * https://leetcode.com/problems/count-binary-substrings/discuss/108600/Java-O(n)-Time-O(1)-Space
     */
    fun countBinarySubstrings(s: String): Int {
        var prevRunLength = 0
        var currentRunLength = 1
        var valid = 0

        for (i in (1..s.lastIndex)) {
            if (s[i] == s[i - 1]) {
                currentRunLength++
            } else {
                prevRunLength = currentRunLength
                currentRunLength = 1
            }

            if (prevRunLength >= currentRunLength) {
                valid++
            }
        }
        return valid
    }
}

class SolutionThree {
    /**
     * Time: O(n)
     * Space: O(n)
     *
     * http://tinyurl.com/ydyon545
     */
    fun countBinarySubstrings(s: String): Int =
        s.replace("01", "0 1")
            .replace("10", "1 0")
            .split(" ")                         // List of contiguous 0 or 1 segments
            .asSequence()
            .map { it.length }                  // The lengths of each segment
            .zipWithNext()                      // Take in pairs [(0, 1), (1, 2), (2, 3), ...]
            .sumBy { (segment1, segment2) ->    // for any possible substrings with 1 and 0 grouped consecutively,
                min(segment1, segment2)         // the number of valid substring will be the minimum segment length.
            }
}