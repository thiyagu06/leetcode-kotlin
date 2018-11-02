package leetcode.easy._243_shortest_word_distance

import kotlin.math.abs
import kotlin.math.min

/**
 * 243 - https://leetcode.com/problems/shortest-word-distance
 */
class Solution {
    /**
     * Time: O(s * t), where s is freq of word1, t is freq of word2
     * Space: O(n), where n is size of words
     */
    fun shortestDistance(words: Array<String>, word1: String, word2: String): Int {
        val indexMap = words.withIndex().groupBy({ it.value }, { it.index })

        val word1Indices = indexMap[word1]!!
        val word2Indices = indexMap[word2]!!

        var shortestDistance = words.size - 1

        for (i in word1Indices) {
            for (j in word2Indices) {
                shortestDistance = min(shortestDistance, abs(i - j))
            }
        }

        return shortestDistance
    }
}

class SolutionTwo {
    /**
     * Optimal Approach - see [Editorial](https://leetcode.com/articles/shortest-word-distance/)
     * Time: O(n)
     * Space: O(1)
     */
    fun shortestDistance(words: Array<String>, word1: String, word2: String): Int {
        var w1Index: Int? = null
        var w2Index: Int? = null
        var shortestDistance = words.size - 1

        for ((i, word) in words.withIndex()) {
            if (word == word1) {
                w1Index = i
            } else if (word == word2) {
                w2Index = i
            }

            if (w1Index != null && w2Index != null) {
                shortestDistance = min(shortestDistance, abs(w1Index - w2Index))
            }
        }

        return shortestDistance
    }
}
