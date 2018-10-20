package leetcode.medium._392_is_subsequence

import extensions.strings.characterIndices

/**
 * 392 - https://leetcode.com/problems/is-subsequence
 */
class Solution {
    /**
     * Time: O(n) - where n is length of t
     * Space: O(1)
     */
    fun isSubsequence(s: String, t: String): Boolean {
        var sIdx = 0
        var tIdx = 0
        while (sIdx <= s.lastIndex && tIdx <= t.lastIndex) {
            if (t[tIdx] == s[sIdx]) {
                sIdx++
            }
            tIdx++
        }

        return sIdx > s.lastIndex
    }
}

/**
 * **Follow-up**:
 * If there are lots of incoming `S`, say `S1, S2, ... , Sk` where `k >= 1B`, and you want to check one by one to see
 * if `T` has its subsequence. In this scenario, how would you change your code?
 */
class FollowUpSolution1 {
    /**
     * Time: O(n * k) - where n is the length of t, and k is the length of s
     *                  In the worst case, `for (ch in s)` will iterate all chars in s, and for each char we do
     *                  a `firstOrNull` search which will search over at most k indices
     *
     * Space: O(n)
     */
    fun isSubsequence(s: String, t: String): Boolean {
        val charIndices: Map<Char, List<Int>> = t.characterIndices()
        var prevCharIndex = -1  // index in t of the previous char in s
        for (ch in s) {
            if (ch !in charIndices) return false
            // Search the indices where the current char appears in t.
            prevCharIndex = charIndices[ch]!!.firstOrNull { index -> index > prevCharIndex } ?: return false
        }

        return true
    }
}

/**
 * **Follow-up**:
 * If there are lots of incoming `S`, say `S1, S2, ... , Sk` where `k >= 1B`, and you want to check one by one to see
 * if `T` has its subsequence. In this scenario, how would you change your code?
 */
class FollowUpSolution2 {
    /**
     * Improve [FollowUpSolution1] by using Binary Search instead of `firstOrNull`, since we know that the indices
     * will be sorted since they were added to the map in order.
     *
     * Time: O(n * log (k)) - where n is the length of t, and k is the length of s
     *                  In the worst case, `for (ch in s)` will iterate all chars in s, and for each char we do
     *                  a `firstOrNull` search which will search over at most k indices
     *
     * Space: O(n)
     */
    fun isSubsequence(s: String, t: String): Boolean {
        val charIndices: Map<Char, List<Int>> = t.characterIndices()
        var prevCharIndex = -1  // index in t of the previous char in s
        for (ch in s) {
            if (ch !in charIndices) return false
            // Search the indices where the current char appears in t.
            prevCharIndex = binarySearch(prevCharIndex, charIndices[ch]!!)
            if (prevCharIndex == -1) return false
        }

        return true
    }

    /**
     * Modified binary search.
     * From [here](https://leetcode.com/problems/is-subsequence/discuss/87268/Java-code-for-the-follow-up-question).
     */
    private fun binarySearch(index: Int, list: List<Int>): Int {
        var (start, end) = 0 to list.lastIndex
        while (start <= end) {
            val mid = start + ((end - start) / 2)
            when {
                list[mid] < index -> start = mid + 1
                else -> end = mid - 1
            }
        }

        return if (start == list.size) -1 else list[start]
    }

}