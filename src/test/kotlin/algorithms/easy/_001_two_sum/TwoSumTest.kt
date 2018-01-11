package algorithms.easy._001_two_sum

import org.junit.Test

import org.junit.Assert.*

class TwoSumTest {

    private val solution = Solution()

    @Test
    fun twoSum() {
        assertArrayEquals(intArrayOf(0, 1), solution.twoSum(intArrayOf(2, 7, 11, 15), target = 9))
    }
}