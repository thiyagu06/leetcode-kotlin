package leetcode.easy._349_intersection_of_two_arrays

import org.junit.Test

import org.junit.Assert.*

class IntersectionTwoArraysTest {
    private val solution = Solution()

    @Test
    fun intersection() {
        assertArrayEquals(intArrayOf(), solution.intersection(intArrayOf(1, 1), intArrayOf(2, 2)))
        assertArrayEquals(intArrayOf(2), solution.intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)))
    }
}
