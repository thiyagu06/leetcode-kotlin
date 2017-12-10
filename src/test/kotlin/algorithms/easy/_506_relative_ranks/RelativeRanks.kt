package algorithms.easy._506_relative_ranks

import org.junit.Test

import org.junit.Assert.*

class RelativeRanks {

    private val solution = Solution()

    @Test
    fun findRelativeRanks() {
        assertArrayEquals(arrayOf(),
                solution.findRelativeRanks(intArrayOf()))
        assertArrayEquals(arrayOf("Gold Medal"),
                solution.findRelativeRanks(intArrayOf(1)))
        assertArrayEquals(arrayOf("Silver Medal", "Gold Medal"),
                solution.findRelativeRanks(intArrayOf(1, 2)))
        assertArrayEquals(arrayOf("Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"),
                solution.findRelativeRanks(intArrayOf(5, 4, 3, 2, 1)))
        assertArrayEquals(arrayOf("Gold Medal", "Bronze Medal", "4", "5", "Silver Medal"),
                solution.findRelativeRanks(intArrayOf(5, 3, 2, 1, 4)))
        assertArrayEquals(arrayOf("Silver Medal", "Bronze Medal", "4", "5", "6", "Gold Medal"),
                solution.findRelativeRanks(intArrayOf(5, 4, 3, 2, 1, 6)))
        assertArrayEquals(arrayOf("5", "4", "Bronze Medal", "Silver Medal", "Gold Medal"),
                solution.findRelativeRanks(intArrayOf(1, 2, 3, 4, 5)))
    }
}