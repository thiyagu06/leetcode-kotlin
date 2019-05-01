package leetcode.easy._283_move_zeroes

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class MoveZeroesTest {
    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()
    private val solution4 = SolutionFour()

    private val expected = linkedMapOf(
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

    @Test
    fun moveZeroes() {
        expected.forEach { (input, output) ->
            println("Testing input ${input.toList()}")
            solution.moveZeroes(input)
            assertArrayEquals(output, input)
        }
    }

    @Test
    fun moveZeroes2() {
        expected.forEach { (input, output) ->
            println("Testing input ${input.toList()}")
            solution2.moveZeroes(input)
            assertArrayEquals(output, input)
        }
    }

    @Test
    fun moveZeroes3() {
        expected.forEach { (input, output) ->
            println("Testing input ${input.toList()}")
            solution3.moveZeroes(input)
            assertArrayEquals(output, input)
        }
    }

    @Test
    fun moveZeroes4() {
        expected.forEach { (input, output) ->
            println("Testing input ${input.toList()}")
            solution4.moveZeroes(input)
            assertArrayEquals(output, input)
        }
    }
}