package leetcode.easy._821_shortest_distance_to_character

import kotlin.math.abs

/**
 * 821 - https://leetcode.com/problems/shortest-distance-to-a-character/
 */
class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    fun shortestToChar(S: String, C: Char): IntArray {
        val cIndices = S.foldIndexed(mutableListOf<Int>()) { index, acc, char ->
            if (char == C)
                acc += index
            acc
        }

        return S.mapIndexed { index, _ ->
            cIndices.asSequence().map { abs(index - it) }.min() ?: 0
        }.toIntArray()
    }
}