package leetcode.medium._056_merge_intervals

import datastructures.interval.Interval
import datastructures.interval.overlapsWith
import org.junit.Test

import org.junit.Assert.*

class MergeIntervalsTest {

    private val solution = Solution()

    @Test
    fun merge() {
        assertEquals(emptyList<Interval>(), solution.merge(emptyList()))
        assertEquals(listOf(Interval(1, 3)), solution.merge(listOf(Interval(1, 3))))
        assertEquals(
            listOf(Interval(1, 6), Interval(8, 10), Interval(15, 18)),
            solution.merge(listOf(Interval(1, 3), Interval(2, 6), Interval(8, 10), Interval(15, 18)))
        )
        assertEquals(
            listOf(Interval(1, 5)),
            solution.merge(listOf(Interval(1, 4), Interval(4, 5)))
        )
    }

    @Test
    fun overlapsWith() {
        assertTrue(Interval(1, 5).overlapsWith(Interval(2, 3)))
        assertTrue(Interval(2, 3).overlapsWith(Interval(1, 5)))
        assertTrue(Interval(1, 3).overlapsWith(Interval(3, 5)))
        assertTrue(Interval(3, 5).overlapsWith(Interval(1, 3)))
        assertFalse(Interval(1, 2).overlapsWith(Interval(3, 4)))
    }
}