package leetcode.easy._001_two_sum

import org.junit.Test

import org.junit.Assert.*
import java.lang.IllegalArgumentException

class TwoSumTest {

    private val solution = Solution()
    private val altSolution = AltSolution()

    @Test
    fun twoSum() {
        assertArrayEquals(intArrayOf(0, 1), solution.twoSum(intArrayOf(2, 7, 11, 15), target = 9))
        assertArrayEquals(intArrayOf(0, 3), solution.twoSum(intArrayOf(2, 7, 11, 2), target = 4))
        assertArrayEquals(intArrayOf(1, 2), solution.twoSum(intArrayOf(3, 2, 4), target = 6))
    }

    @Test(expected = IllegalArgumentException::class)
    fun twoSumInvalid() {
        solution.twoSum(intArrayOf(2, 7, 11, 2), target = 99)
    }

    @Test
    fun twoSumAlt() {
        assertArrayEquals(intArrayOf(0, 1), altSolution.twoSum(intArrayOf(2, 7, 11, 15), target = 9))
        assertArrayEquals(intArrayOf(0, 3), altSolution.twoSum(intArrayOf(2, 7, 11, 2), target = 4))
        assertArrayEquals(intArrayOf(1, 2), altSolution.twoSum(intArrayOf(3, 2, 4), target = 6))
    }

    @Test(expected = IllegalArgumentException::class)
    fun twoSumInvalidAlt() {
        altSolution.twoSum(intArrayOf(2, 7, 11, 2), target = 99)
    }
}