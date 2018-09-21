package leetcode.easy._283_move_zeroes

import org.junit.Test

import org.junit.Assert.*

class MoveZeroesTest {
    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    @Test
    fun moveZeroes() {
        val expectedInputOutput = hashMapOf(
                intArrayOf() to intArrayOf(),
                intArrayOf(0) to intArrayOf(0),
                intArrayOf(1) to intArrayOf(1),
                intArrayOf(1, 0) to intArrayOf(1, 0),
                intArrayOf(0, 1) to intArrayOf(1, 0),
                intArrayOf(1, 0, 0) to intArrayOf(1, 0, 0),
                intArrayOf(0, 1, 0, 3, 12) to intArrayOf(1, 3, 12, 0, 0),
                intArrayOf(0, 12, 0, 3, 1) to intArrayOf(12, 3, 1, 0, 0),
                intArrayOf(7, 9, 0, 1, 3, 0, 4) to intArrayOf(7, 9, 1, 3, 4, 0, 0)
        )

        expectedInputOutput.forEach { (input, output) ->
            solution.moveZeroes(input)
            assertArrayEquals(output, input)
        }
    }

    @Test
    fun moveZeroes2() {
        val expectedInputOutput = hashMapOf(
            intArrayOf() to intArrayOf(),
            intArrayOf(0) to intArrayOf(0),
            intArrayOf(1) to intArrayOf(1),
            intArrayOf(1, 0) to intArrayOf(1, 0),
            intArrayOf(0, 1) to intArrayOf(1, 0),
            intArrayOf(1, 0, 0) to intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0, 3, 12) to intArrayOf(1, 3, 12, 0, 0),
            intArrayOf(0, 12, 0, 3, 1) to intArrayOf(12, 3, 1, 0, 0),
            intArrayOf(7, 9, 0, 1, 3, 0, 4) to intArrayOf(7, 9, 1, 3, 4, 0, 0)
        )

        expectedInputOutput.forEach { (input, output) ->
            solution2.moveZeroes(input)
            assertArrayEquals(output, input)
        }
    }

    @Test
    fun moveZeroes3() {
        val expectedInputOutput = hashMapOf(
            intArrayOf() to intArrayOf(),
            intArrayOf(0) to intArrayOf(0),
            intArrayOf(1) to intArrayOf(1),
            intArrayOf(1, 0) to intArrayOf(1, 0),
            intArrayOf(0, 1) to intArrayOf(1, 0),
            intArrayOf(1, 0, 0) to intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0, 3, 12) to intArrayOf(1, 3, 12, 0, 0),
            intArrayOf(0, 12, 0, 3, 1) to intArrayOf(12, 3, 1, 0, 0),
            intArrayOf(7, 9, 0, 1, 3, 0, 4) to intArrayOf(7, 9, 1, 3, 4, 0, 0)
        )

        expectedInputOutput.forEach { (input, output) ->
            solution3.moveZeroes(input)
            assertArrayEquals(output, input)
        }
    }

}