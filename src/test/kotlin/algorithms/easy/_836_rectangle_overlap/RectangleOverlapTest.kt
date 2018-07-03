package algorithms.easy._836_rectangle_overlap

import org.junit.Assert.*
import org.junit.Test

class RectangleOverlapTest {

    private val solution = Solution()

    @Test
    fun isRectangleOverlap() {
        assertTrue(solution.isRectangleOverlap(intArrayOf(0, 0, 2, 2), intArrayOf(1, 1, 3, 3)))
        assertTrue(solution.isRectangleOverlap(intArrayOf(0, 0, 4, 4), intArrayOf(1, 1, 3, 3)))
        assertFalse(solution.isRectangleOverlap(intArrayOf(0, 0, 1, 1), intArrayOf(1, 0, 2, 1)))
    }

}