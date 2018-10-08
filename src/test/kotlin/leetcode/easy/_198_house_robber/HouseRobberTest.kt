package leetcode.easy._198_house_robber

import org.junit.Test

import org.junit.Assert.*

class HouseRobberTest {
    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    private val expected = mapOf(
        intArrayOf(2, 4, 2, 4) to 8,
        intArrayOf(2, 1, 1, 2) to 4,
        intArrayOf(2, 7, 9, 3, 1) to 12,
        intArrayOf(2, 7, 9, 99, 1) to 106
    )

    @Test
    fun rob() {
        expected.forEach { (input, output) ->
            assertEquals(output, solution.rob(input))
        }
    }

    @Test
    fun rob2() {
        expected.forEach { (input, output) ->
            assertEquals(output, solution2.rob(input))
        }
    }

    @Test
    fun rob3() {
        expected.forEach { (input, output) ->
            assertEquals(output, solution3.rob(input))
        }
    }

}
