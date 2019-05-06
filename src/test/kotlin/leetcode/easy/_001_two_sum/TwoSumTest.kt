package leetcode.easy._001_two_sum

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class TwoSumTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun twoSum() {
        assertArrayEquals(intArrayOf(0, 1), solution.twoSum(intArrayOf(2, 7, 11, 15), target = 9))
        assertArrayEquals(intArrayOf(0, 3), solution.twoSum(intArrayOf(2, 7, 11, 2), target = 4))
        assertArrayEquals(intArrayOf(1, 2), solution.twoSum(intArrayOf(3, 2, 4), target = 6))
        assertArrayEquals(intArrayOf(0, 2), solution.twoSum(intArrayOf(4, 1, 4, 2), target = 8))
    }

    @Test(expected = IllegalArgumentException::class)
    fun twoSumInvalid() {
        solution.twoSum(intArrayOf(2, 7, 11, 2), target = 99)
    }

    @Test
    fun twoSum2() {
        assertArrayEquals(intArrayOf(0, 1), solution2.twoSum(intArrayOf(2, 7, 11, 15), target = 9))
        assertArrayEquals(intArrayOf(0, 3), solution2.twoSum(intArrayOf(2, 7, 11, 2), target = 4))
        assertArrayEquals(intArrayOf(1, 2), solution2.twoSum(intArrayOf(3, 2, 4), target = 6))
        assertArrayEquals(intArrayOf(0, 2), solution2.twoSum(intArrayOf(4, 1, 4, 2), target = 8))
    }

    @Test(expected = IllegalArgumentException::class)
    fun twoSumInvalidAlt() {
        solution2.twoSum(intArrayOf(2, 7, 11, 2), target = 99)
    }
}