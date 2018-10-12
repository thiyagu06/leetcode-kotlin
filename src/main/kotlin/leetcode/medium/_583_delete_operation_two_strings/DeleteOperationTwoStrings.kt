package leetcode.medium._583_delete_operation_two_strings

import extensions.strings.lcs

/**
 * 583 - https://leetcode.com/problems/delete-operation-for-two-strings
 */
class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val lcsLength = lcs(word1, word2).length
        return (word1.length - lcsLength) + (word2.length - lcsLength)
    }
}