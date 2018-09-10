package leetcode.medium._451_sort_characters_by_freq

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class SortCharsByFreqTest {
    private val solution = Solution()

    @Test
    fun frequencySort() {
        val result = solution.frequencySort("tree")
        assertTrue(result in setOf("eert", "eetr"))
        assertEquals("cccaaa", solution.frequencySort("cccaaa"))
        assertEquals("bbAa", solution.frequencySort("Aabb"))
    }
}