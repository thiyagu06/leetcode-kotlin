package leetcode.easy._884_uncommon_words

import extensions.iterable.frequencyMap

/**
 * 884 - https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
 */
class Solution {
    /**
     * Time: O(m + n) - where m & n are the # of words in A and B
     * Space: O(m + n)
     */
    fun uncommonFromSentences(A: String, B: String): Array<String> {
        val wordsA = A.split(" ")
        val wordsB = B.split(" ")
        val frequencies = HashMap<String, Int>()

        for (word in wordsA + wordsB) {
            frequencies[word] = (frequencies[word] ?: 0) + 1
        }

        return frequencies.filter { (_, freq) -> freq == 1 }
            .keys.toTypedArray()
    }
}

class SolutionTwo {
    /**
     * Same solution, more concise
     *
     * Time: O(m + n) - where m & n are the # of words in A and B
     * Space: O(m + n)
     */
    fun uncommonFromSentences(A: String, B: String): Array<String> =
        (A.split(" ") + B.split(" "))
            .frequencyMap()
            .filter { (_, freq) -> freq == 1 }
            .keys
            .toTypedArray()
}