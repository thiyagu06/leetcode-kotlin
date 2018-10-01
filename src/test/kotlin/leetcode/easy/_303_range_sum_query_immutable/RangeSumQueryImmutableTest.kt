package leetcode.easy._303_range_sum_query_immutable

import org.junit.Assert.assertEquals
import org.junit.Test

class RangeSumQueryImmutableTest {

    private val arr1 = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))
    private val arr2 = NumArray2(intArrayOf(-2, 0, 3, -5, 2, -1))
    private val arr3 = NumArray3(intArrayOf(-2, 0, 3, -5, 2, -1))

    @Test
    fun sumRange() {
        assertEquals(1, arr1.sumRange(0, 2))
        assertEquals(-1, arr1.sumRange(2, 5))
        assertEquals(-3, arr1.sumRange(0, 5))
    }

    @Test
    fun sumRange2() {
        assertEquals(1, arr2.sumRange(0, 2))
        assertEquals(-1, arr2.sumRange(2, 5))
        assertEquals(-3, arr2.sumRange(0, 5))
    }

    @Test
    fun sumRange3() {
        assertEquals(1, arr3.sumRange(0, 2))
        assertEquals(-1, arr3.sumRange(2, 5))
        assertEquals(-3, arr3.sumRange(0, 5))
    }
}