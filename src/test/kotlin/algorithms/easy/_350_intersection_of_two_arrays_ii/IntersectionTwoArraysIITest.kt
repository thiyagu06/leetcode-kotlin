package algorithms.easy._350_intersection_of_two_arrays_ii

import org.junit.Test

import org.junit.Assert.*

/**
 * @author nrojiani
 * @date 11/15/17
 */
class IntersectionTwoArraysIITest {
    private val solution = Solution()
    private val solutionWithExt = SolutionUsingExtensions()

    @Test
    fun intersect() {
        assertArrayEquals(intArrayOf(), solution.intersect(intArrayOf(1, 1), intArrayOf(2, 2)))
        assertArrayEquals(intArrayOf(1), solution.intersect(intArrayOf(1), intArrayOf(1)))
        assertArrayEquals(intArrayOf(1), solution.intersect(intArrayOf(1, 1), intArrayOf(1, 2, 2)))
        assertArrayEquals(intArrayOf(1, 1), solution.intersect(intArrayOf(1, 1), intArrayOf(1, 1, 2, 2)))
        assertArrayEquals(intArrayOf(1, 1), solution.intersect(intArrayOf(1, 1), intArrayOf(1, 1, 1, 2, 2)))
        assertArrayEquals(intArrayOf(2, 2), solution.intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)))
    }

    @Test
    fun intersectUsingExtensions() {
        assertArrayEquals(intArrayOf(), solutionWithExt.intersect(intArrayOf(1, 1), intArrayOf(2, 2)))
        assertArrayEquals(intArrayOf(1), solutionWithExt.intersect(intArrayOf(1), intArrayOf(1)))
        assertArrayEquals(intArrayOf(1), solutionWithExt.intersect(intArrayOf(1, 1), intArrayOf(1, 2, 2)))
        assertArrayEquals(intArrayOf(1, 1), solutionWithExt.intersect(intArrayOf(1, 1), intArrayOf(1, 1, 2, 2)))
        assertArrayEquals(intArrayOf(1, 1), solutionWithExt.intersect(intArrayOf(1, 1), intArrayOf(1, 1, 1, 2, 2)))
        assertArrayEquals(intArrayOf(2, 2), solutionWithExt.intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)))
    }

}