package leetcode.medium._494_target_sum

import org.junit.Test

import kotlin.test.assertEquals

class TargetSumTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    @Test
    fun findTargetSumWays() {
        assertEquals(5, solution.findTargetSumWays(intArrayOf(1, 1, 1, 1, 1), 3))
        assertEquals(14, solution.findTargetSumWays(intArrayOf(1, 3, 5, 2, 1, 3, 2, 5), 10))
        assertEquals(10, solution.findTargetSumWays(intArrayOf(1, 3, 5, 2, 1, 3, 2, 5), 12))
        assertEquals(3, solution.findTargetSumWays(intArrayOf(1, 2, 3, 1), 1))
        assertEquals(0, solution.findTargetSumWays(intArrayOf(1, 2, 3, 1), 2))
        assertEquals(2, solution.findTargetSumWays(intArrayOf(1, 2, 3, 1), 3))
        assertEquals(
            6184,
            solution.findTargetSumWays(
                intArrayOf(27, 33, 4, 43, 31, 44, 47, 6, 6, 11, 39, 37, 15, 16, 8, 19, 48, 17, 18, 39),
                24
            )
        )
        assertEquals(2, solution.findTargetSumWays(intArrayOf(1, 2, 1), 0))
    }

    @Test
    fun findTargetSumWays2() {
        assertEquals(5, solution2.findTargetSumWays(intArrayOf(1, 1, 1, 1, 1), 3))
        assertEquals(14, solution2.findTargetSumWays(intArrayOf(1, 3, 5, 2, 1, 3, 2, 5), 10))
        assertEquals(10, solution2.findTargetSumWays(intArrayOf(1, 3, 5, 2, 1, 3, 2, 5), 12))
        assertEquals(3, solution2.findTargetSumWays(intArrayOf(1, 2, 3, 1), 1))
        assertEquals(0, solution2.findTargetSumWays(intArrayOf(1, 2, 3, 1), 2))
        assertEquals(2, solution2.findTargetSumWays(intArrayOf(1, 2, 3, 1), 3))
        assertEquals(
            6184,
            solution2.findTargetSumWays(
                intArrayOf(27, 33, 4, 43, 31, 44, 47, 6, 6, 11, 39, 37, 15, 16, 8, 19, 48, 17, 18, 39),
                24
            )
        )
        assertEquals(2, solution2.findTargetSumWays(intArrayOf(1, 2, 1), 0))
    }

    @Test
    fun findTargetSumWays3() {
        assertEquals(5, solution3.findTargetSumWays(intArrayOf(1, 1, 1, 1, 1), 3))
        assertEquals(14, solution3.findTargetSumWays(intArrayOf(1, 3, 5, 2, 1, 3, 2, 5), 10))
        assertEquals(10, solution3.findTargetSumWays(intArrayOf(1, 3, 5, 2, 1, 3, 2, 5), 12))
        assertEquals(3, solution3.findTargetSumWays(intArrayOf(1, 2, 3, 1), 1))
        assertEquals(0, solution3.findTargetSumWays(intArrayOf(1, 2, 3, 1), 2))
        assertEquals(2, solution3.findTargetSumWays(intArrayOf(1, 2, 3, 1), 3))
        assertEquals(
            6184,
            solution3.findTargetSumWays(
                intArrayOf(27, 33, 4, 43, 31, 44, 47, 6, 6, 11, 39, 37, 15, 16, 8, 19, 48, 17, 18, 39),
                24
            )
        )
        assertEquals(2, solution3.findTargetSumWays(intArrayOf(1, 2, 1), 0))
    }
}