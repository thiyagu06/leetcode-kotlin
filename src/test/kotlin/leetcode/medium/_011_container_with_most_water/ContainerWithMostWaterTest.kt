package leetcode.medium._011_container_with_most_water

import org.junit.Test

import kotlin.test.assertEquals

class ContainerWithMostWaterTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun maxArea() {
        assertEquals(49, solution.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    }

    @Test
    fun maxArea2() {
        assertEquals(49, solution2.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    }
}