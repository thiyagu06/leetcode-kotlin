package algorithms.medium._692_top_k_frequent_words

import org.junit.Test

import org.junit.Assert.*

class TopKFrequentWordsTest {

    private val solution = Solution()

    @Test
    fun topKFrequent() {
        assertEquals(listOf("i", "love"), solution.topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), k = 2))
        assertEquals(listOf("the", "is", "sunny", "day"), solution.topKFrequent(arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"), k = 4))
        assertEquals(listOf("i", "love", "coding"), solution.topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), k = 3))
    }

}