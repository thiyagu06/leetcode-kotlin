package leetcode.easy._350_intersection_of_two_arrays_ii

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class IntersectionTwoArraysIITest {
    private val solution = Solution()

    @Test
    fun intersect() {
        assertArrayEquals(intArrayOf(), solution.intersect(intArrayOf(1, 1), intArrayOf(2, 2)))
        assertArrayEquals(intArrayOf(1), solution.intersect(intArrayOf(1), intArrayOf(1)))
        assertArrayEquals(intArrayOf(1), solution.intersect(intArrayOf(1, 1), intArrayOf(1, 2, 2)))
        assertArrayEquals(intArrayOf(1, 1), solution.intersect(intArrayOf(1, 1), intArrayOf(1, 1, 2, 2)))
        assertArrayEquals(intArrayOf(1, 1), solution.intersect(intArrayOf(1, 1), intArrayOf(1, 1, 1, 2, 2)))
        assertArrayEquals(intArrayOf(2, 2), solution.intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)))
    }

}
