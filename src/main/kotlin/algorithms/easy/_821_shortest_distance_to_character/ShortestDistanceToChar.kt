package algorithms.easy._821_shortest_distance_to_character

import kotlin.math.abs

class Solution {
    fun shortestToChar(S: String, C: Char): IntArray {
        val cIndices = S.foldIndexed(mutableListOf<Int>()) { index, acc, char ->
            if (char == C)
                acc += index
            acc
        }

        return S.mapIndexed { index, _ ->
            cIndices.map { abs(index - it) }.min() ?: 0
        }.toIntArray()
    }
}