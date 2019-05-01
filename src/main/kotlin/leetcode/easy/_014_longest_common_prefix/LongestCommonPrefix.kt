package leetcode.easy._014_longest_common_prefix

/**
 * 14 - https://leetcode.com/problems/longest-common-prefix/
 */
class Solution {
    /**
     * Horizontal Scanning (Approach 1)
     * Time: O(S), where S is the sum of all chars in strs
     * Space: O(1) - if zip() weren't used for convenience/cleanness
     */
    fun longestCommonPrefix(strs: Array<String>): String = when (strs.size) {
        0 -> ""
        else -> (1..strs.lastIndex).fold(strs[0]) { lcp, i ->
            longestCommonPrefix(strs[i], lcp)
        }
    }

    private fun longestCommonPrefix(s1: String, s2: String): String =
        s1.zip(s2).fold("") { lcp, (c1, c2) ->
            if (c1 == c2) lcp + c1 else return lcp
        }
}

class SolutionTwo {
    /**
     * Vertical Scanning (Approach 2)
     * Time: O(S), where S is the sum of all chars in strs; in best case only n * minLength comparison are made.
     * Space: O(1)
     */
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        var prefix = ""
        var charIndex = 0
        while (charIndex < Int.MAX_VALUE) {
            if (charIndex !in strs[0].indices) return prefix
            val currentChar = strs[0][charIndex]

            for (stringIndex in 1..strs.lastIndex) {
                if (charIndex !in strs[stringIndex].indices || strs[stringIndex][charIndex] != currentChar) {
                    return prefix
                }
            }
            prefix += currentChar
            charIndex++
        }

        return prefix
    }
}

/**
 * Using divide & conquer - binary search of the space (0..minLen)
 * Note: the execution time on LeetCode is actually longer
 * https://leetcode.com/problems/longest-common-prefix/solution/
 */
class OptimalSolution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        val minLen: Int = strs.minBy { it.length }?.length ?: 0
        var low = 0
        var high = minLen
        while (low <= high) {
            val mid = (low + high) / 2
            if (hasCommonPrefix(strs, mid)) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        return strs[0].substring(0, (low + high) / 2)
    }

    private fun hasCommonPrefix(strs: Array<String>, prefixLength: Int): Boolean {
        val prefix = strs[0].substring(0, prefixLength)
        return strs.drop(1).all { it.startsWith(prefix) }
    }
}
