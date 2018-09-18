package leetcode.medium._692_top_k_frequent_words

import org.junit.Test

import org.junit.Assert.*

class TopKFrequentWordsTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun topKFrequent() {
        assertEquals(listOf("love"), solution.topKFrequent(arrayOf("love", "leetcode", "love", "coding"), k = 1))
        assertEquals(listOf("love", "coding"), solution.topKFrequent(arrayOf("love", "leetcode", "love", "coding"), k = 2))
        assertEquals(listOf("i", "love"), solution.topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), k = 2))
        assertEquals(listOf("the", "is", "sunny", "day"), solution.topKFrequent(arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"), k = 4))
        assertEquals(listOf("i", "love", "coding"), solution.topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), k = 3))
    }

    @Test
    fun topKFrequent2() {
        assertEquals(listOf("love"), solution2.topKFrequent(arrayOf("love", "leetcode", "love", "coding"), k = 1))
        assertEquals(listOf("love", "coding"), solution2.topKFrequent(arrayOf("love", "leetcode", "love", "coding"), k = 2))
        assertEquals(listOf("i", "love"), solution2.topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), k = 2))
        assertEquals(listOf("the", "is", "sunny", "day"), solution2.topKFrequent(arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"), k = 4))
        assertEquals(listOf("i", "love", "coding"), solution2.topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), k = 3))

    }

}