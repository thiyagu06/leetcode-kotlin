package leetcode.hard._004_median_of_two_sorted_arrays

import extensions.math.EPSILON
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test

class MedianOfTwoSortedArraysTest {

    private val solution = Solution()

    @Ignore("Unimplemented")
    @Test
    fun findMedianSortedArrays() {
        assertEquals(2.0, solution.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)), EPSILON)
        assertEquals(2.5, solution.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)), EPSILON)
    }
}