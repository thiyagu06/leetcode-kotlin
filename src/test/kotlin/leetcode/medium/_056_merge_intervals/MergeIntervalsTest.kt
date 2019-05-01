package leetcode.medium._056_merge_intervals

import datastructures.interval.Interval
import org.junit.Assert.assertEquals
import org.junit.Test

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
            listOf(Interval(1, 6), Interval(8, 10), Interval(15, 18)),
            solution.merge(listOf(Interval(2, 6), Interval(15, 18), Interval(1, 3), Interval(8, 10)))
        )

        assertEquals(
            listOf(Interval(1, 5)),
            solution.merge(listOf(Interval(1, 4), Interval(4, 5)))
        )

        assertEquals(
            listOf(Interval(0, 9), Interval(10, 16)),
            solution.merge(listOf(Interval(0, 4), Interval(2, 8), Interval(7, 9), Interval(10, 12), Interval(11, 16)))
        )

        assertEquals(
            listOf(Interval(0, 10), Interval(12, 14)),
            solution.merge(
                listOf(Interval(0, 8), Interval(2, 6), Interval(4, 10), Interval(12, 14), Interval(6, 8))
            )
        )
    }
}