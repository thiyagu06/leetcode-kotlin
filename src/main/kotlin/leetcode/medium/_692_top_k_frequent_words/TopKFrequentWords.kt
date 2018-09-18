package leetcode.medium._692_top_k_frequent_words

import extensions.arrays.frequencyMap

/**
 * 692 - https://leetcode.com/problems/top-k-frequent-words/description/
 */
class Solution {
    /**
     * Time: O(n log n)
     * Space: O(n)
     */
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val frequencies = words.frequencyMap()

        val comparator = compareByDescending<Map.Entry<String, Int>> { (word, freq) -> freq }
            .thenBy { (word, freq) -> word }

        return frequencies.asSequence()
            .sortedWith(comparator)
            .take(k)
            .map { (word, freq) -> word }
            .toList()
    }
}

/**
 * Same solution, without using Kotlin's standard library functions that make it easier.
 */
class SolutionTwo {

    object FrequencyComparator : Comparator<Map.Entry<String, Int>> {
        override fun compare(o1: Map.Entry<String, Int>, o2: Map.Entry<String, Int>): Int = when {
            o1.value > o2.value -> 1
            o1.value < o2.value -> -1
            else -> o2.key.compareTo(o1.key)    // since sort will use reversed comparator
        }
    }

    /**
     * Time: O(n log k)
     * Space: O(n)
     */
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val frequencies = words.wordFrequencies()
        val comparator = FrequencyComparator
        return frequencies.asSequence()
            .sortedWith(comparator.reversed())
            .take(k)
            .map { (word, freq) -> word }
            .toList()
    }

    private fun Array<String>.wordFrequencies(): Map<String, Int> {
        val frequencies = hashMapOf<String, Int>()
        forEach { word ->
            frequencies[word] = frequencies.getOrDefault(word, 0) + 1
        }
        return frequencies
    }
}
