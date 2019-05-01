package leetcode.easy._266_palindrome_permutation

import extensions.math.isEven
import extensions.math.isOdd
import extensions.strings.characterFrequencies

/**
 * 266 - https://leetcode.com/problems/palindrome-permutation
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     *
     * Runtime: 192 ms
     */
    fun canPermutePalindrome(s: String): Boolean {
        val freqs = s.characterFrequencies(caseSensitive = true)
        val isEvenLength = s.length.isEven
        var oddFreqs = 0
        for (freq in freqs.values) {
            if (freq.isOdd) {
                oddFreqs++
                if (isEvenLength || (!isEvenLength && oddFreqs > 1)) return false
            }
        }

        return true
    }
}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(n)
     *
     * Runtime: 216 ms
     */
    fun canPermutePalindrome(s: String): Boolean {
        val freqs = s.characterFrequencies(caseSensitive = true)
        return if (s.length.isEven) {
            freqs.values.all { it.isEven }
        } else {
            freqs.values.count { it.isOdd } <= 1
        }
    }
}