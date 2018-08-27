package leetcode.easy._014_longest_common_prefix

/**
 * 14 - https://leetcode.com/problems/longest-common-prefix/
 */
class Solution {
    /**
     * Time: O(S), where S is the sum of all chars in S
     * Space: O(1) - if zip() weren't used for convenience/cleanness
     */
    fun longestCommonPrefix(strs: Array<String>): String =
        when (strs.size) {
            0 -> ""
            1 -> strs.first()
            else -> (1..strs.lastIndex).fold(strs[0]) { lcp, i ->
                longestCommonPrefix(strs[i], lcp)
            }
        }

    internal fun longestCommonPrefix(s1: String, s2: String): String =
        s1.zip(s2).fold("") { lcp, (c1, c2) ->
            if (c1 == c2) lcp + c1 else return lcp
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
