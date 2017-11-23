package algorithms.easy._014_longest_common_prefix

/**
 * 14 - https://leetcode.com/problems/longest-common-prefix/
 *
 * @author nrojiani
 * @date 11/9/17
 */
class Solution {
    /**
     * Time: O(S), where S is the sum of all chars in S
     * Space: O(1) - if zip() weren't used
     */
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        var prefix = strs[0]
        for (i in (1..strs.lastIndex)) {
            prefix = longestCommonPrefix(strs[i], prefix)
        }
        return prefix
    }

    internal fun longestCommonPrefix(s1: String, s2: String): String {
        return s1.zip(s2).fold("") { prefix, (c1, c2) ->
            if (c1 == c2) prefix + c1 else return prefix
        }
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