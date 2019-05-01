package leetcode.medium._487_max_consecutive_ones_ii

import kotlin.test.assertEquals
import org.junit.Test

class MaxConsecutiveOnesIITest {

    private val solution = Solution()
    private val input1 = IntArray(12) { i ->
        when (i) {
            in setOf(2, 7) -> 0
            else -> 1
        }
    }
    private val bigInput = IntArray(10000) { i ->
        if (i == 378 || i == 1491) 0
        else 1
    }

    @Test
    fun findMaxConsecutiveOnes() {
        assertEquals(4, solution.findMaxConsecutiveOnes(intArrayOf(1, 0, 1, 1, 0)))
        assertEquals(3, solution.findMaxConsecutiveOnes(intArrayOf(1, 0, 1, 0, 1, 0, 1)))
        assertEquals(8, solution.findMaxConsecutiveOnes(intArrayOf(1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1)))
        assertEquals(9, solution.findMaxConsecutiveOnes(input1))
        assertEquals(9621, solution.findMaxConsecutiveOnes(bigInput))
    }
}