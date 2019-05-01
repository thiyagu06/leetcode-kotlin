package leetcode.medium._016_three_sum_closest

import org.junit.Test

import kotlin.test.assertEquals

class ThreeSumClosestTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun threeSumClosest() {
        assertEquals(2, solution.threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
        assertEquals(3, solution.threeSumClosest(intArrayOf(1, 1, 1), 3))
        assertEquals(3, solution.threeSumClosest(intArrayOf(1, 1, 1, 0), 100))
    }

    @Test
    fun threeSumClosest2() {
        assertEquals(2, solution2.threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
        assertEquals(3, solution2.threeSumClosest(intArrayOf(1, 1, 1), 3))
        assertEquals(3, solution2.threeSumClosest(intArrayOf(1, 1, 1, 0), 100))
    }
}