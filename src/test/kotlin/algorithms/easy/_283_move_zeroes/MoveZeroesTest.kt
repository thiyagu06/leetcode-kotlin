package algorithms.easy._283_move_zeroes

import org.junit.Test

import org.junit.Assert.*

class MoveZeroesTest {
    private val solution = Solution()

    @Test
    fun moveZeroes() {
        val expectedInputOutput = hashMapOf(
                intArrayOf(0) to intArrayOf(0),
                intArrayOf(1) to intArrayOf(1),
                intArrayOf(1, 0) to intArrayOf(1, 0),
                intArrayOf(0, 1) to intArrayOf(1, 0),
                intArrayOf(1, 0, 0) to intArrayOf(1, 0, 0),
                intArrayOf(0, 1, 0, 3, 12) to intArrayOf(1, 3, 12, 0, 0)
        )

        expectedInputOutput.forEach { (input, output) ->
            var arr = input
            solution.moveZeroes(arr)
            assertArrayEquals(output, arr)
        }
    }

}