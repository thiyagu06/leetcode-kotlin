package algorithms.easy._747_largest_num_greater_than_twice

import org.junit.Test

import org.junit.Assert.*

class LargestNumberGreaterThanTwiceOthersTest {

    private val solution = Solution()
    private val solution2 = Solution2()

    @Test
    fun dominantIndex() {
        assertEquals(1, solution.dominantIndex(intArrayOf(3, 6, 1, 0)))
        assertEquals(-1, solution.dominantIndex(intArrayOf(1, 2, 3, 4)))
        assertEquals(0, solution.dominantIndex(intArrayOf(1)))
        assertEquals(1, solution.dominantIndex(intArrayOf(1, 2)))
        assertEquals(-1, solution.dominantIndex(intArrayOf(2, 3)))
        assertEquals(3, solution.dominantIndex(intArrayOf(0, 0, 0, 1)))
    }

    @Test
    fun dominantIndex2() {
        assertEquals(1, solution2.dominantIndex(intArrayOf(3, 6, 1, 0)))
        assertEquals(-1, solution2.dominantIndex(intArrayOf(1, 2, 3, 4)))
        assertEquals(0, solution2.dominantIndex(intArrayOf(1)))
        assertEquals(1, solution2.dominantIndex(intArrayOf(1, 2)))
        assertEquals(-1, solution2.dominantIndex(intArrayOf(2, 3)))
        assertEquals(3, solution2.dominantIndex(intArrayOf(0, 0, 0, 1)))
    }
}