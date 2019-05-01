package leetcode.easy._485_max_consecutive_ones

import org.junit.Test

import org.junit.Assert.*

class MaxConsecutiveOnesTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun findMaxConsecutiveOnes() {
        assertEquals(0, solution.findMaxConsecutiveOnes(intArrayOf()))
        assertEquals(0, solution.findMaxConsecutiveOnes(intArrayOf(0)))
        assertEquals(0, solution.findMaxConsecutiveOnes(intArrayOf(0, 0, 0, 0)))
        assertEquals(1, solution.findMaxConsecutiveOnes(intArrayOf(1)))
        assertEquals(1, solution.findMaxConsecutiveOnes(intArrayOf(0, 0, 1, 0)))
        assertEquals(3, solution.findMaxConsecutiveOnes(intArrayOf(1, 1, 1, 0)))
        assertEquals(3, solution.findMaxConsecutiveOnes(intArrayOf(0, 1, 1, 1)))
        assertEquals(3, solution.findMaxConsecutiveOnes(intArrayOf(1, 1, 0, 1, 1, 1)))
    }

    @Test
    fun findMaxConsecutiveOnes2() {
        assertEquals(0, solution2.findMaxConsecutiveOnes(intArrayOf()))
        assertEquals(0, solution2.findMaxConsecutiveOnes(intArrayOf(0)))
        assertEquals(0, solution2.findMaxConsecutiveOnes(intArrayOf(0, 0, 0, 0)))
        assertEquals(1, solution2.findMaxConsecutiveOnes(intArrayOf(1)))
        assertEquals(1, solution2.findMaxConsecutiveOnes(intArrayOf(0, 0, 1, 0)))
        assertEquals(3, solution2.findMaxConsecutiveOnes(intArrayOf(1, 1, 1, 0)))
        assertEquals(3, solution2.findMaxConsecutiveOnes(intArrayOf(0, 1, 1, 1)))
        assertEquals(3, solution2.findMaxConsecutiveOnes(intArrayOf(1, 1, 0, 1, 1, 1)))
    }

}