package leetcode.easy._303_range_sum_query_immutable

import org.junit.Test

import org.junit.Assert.*

class RangeSumQueryImmutableTest {

    private val arr = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))

    @Test
    fun sumRange() {
        assertEquals(1, arr.sumRange(0, 2))
        assertEquals(-1, arr.sumRange(2, 5))
        assertEquals(-3, arr.sumRange(0, 5))
    }
}