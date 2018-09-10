package leetcode.hard._239_sliding_window_maximum

import org.junit.Assert.assertArrayEquals
import org.junit.Ignore
import org.junit.Test

class SlidingWindowMaximumTest {

    private val solution = Solution()
    private val followup = FollowUp()

    @Test
    fun maxSlidingWindow() {
        assertArrayEquals(intArrayOf(3, 3, 5, 5, 6, 7),
            solution.maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3))
        assertArrayEquals(intArrayOf(), solution.maxSlidingWindow(intArrayOf(), 0))
    }

    // TODO
    @Ignore
    @Test
    fun maxSlidingWindowOptimal() {
        assertArrayEquals(intArrayOf(3, 3, 5, 5, 6, 7),
            followup.maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3))

        assertArrayEquals(intArrayOf(), followup.maxSlidingWindow(intArrayOf(), 0))
    }
}