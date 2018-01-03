package algorithms.medium._692_top_k_frequent_words

/**
 * 692 - https://leetcode.com/problems/top-k-frequent-words/description/
 */
class Solution {
    /**
     * Time: O(n log n)
     * Space: O(n)
     */
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val frequencies = words.groupingBy { it }.eachCount().entries

        val comparator = compareByDescending { (_, freq): Map.Entry<String, Int> -> freq }
                            .thenBy { (word, _) -> word }
        return frequencies.sortedWith(comparator)
                .take(k)
                .map { (word, _) -> word }
    }
}

