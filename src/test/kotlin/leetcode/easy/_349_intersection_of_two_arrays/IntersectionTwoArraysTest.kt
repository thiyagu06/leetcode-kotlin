package leetcode.easy._349_intersection_of_two_arrays

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class IntersectionTwoArraysTest {
    private val solution = Solution()
    private val solutionTwo = SolutionTwo()

    @Test
    fun intersection() {
        assertArrayEquals(intArrayOf(), solution.intersection(intArrayOf(1, 1), intArrayOf(2, 2)))
        assertArrayEquals(intArrayOf(2), solution.intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)))
    }

    @Test
    fun intersection2() {
        assertArrayEquals(intArrayOf(), solutionTwo.intersection(intArrayOf(1, 1), intArrayOf(2, 2)))
        assertArrayEquals(intArrayOf(2), solutionTwo.intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)))
    }
}
