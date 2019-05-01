package leetcode.medium._347_top_k_frequent_elements

import org.junit.Test

import kotlin.test.assertEquals

class TopKFrequentElementsTest {

    private val solution = Solution()

    @Test
    fun topKFrequent() {
        assertEquals(listOf(1), solution.topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), k = 1))
        assertEquals(listOf(1, 2), solution.topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), k = 2))
        assertEquals(listOf(1, 2, 3), solution.topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), k = 3))
        assertEquals(listOf(1, 2, 3), solution.topKFrequent(intArrayOf(1, 3, 1, 1, 2, 2), k = 3))
    }
}