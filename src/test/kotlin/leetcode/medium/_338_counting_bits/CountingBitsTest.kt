package leetcode.medium._338_counting_bits

import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore

class CountingBitsTest {

    private val solution = Solution()
    private val solutionTwo = SolutionTwo()
    private val solutionThree = SolutionThree()
    private val followUpSolution = FollowUpSolution()


    @Test
    fun countBits1() {
        assertArrayEquals(intArrayOf(0), solution.countBits(0))
        assertArrayEquals(intArrayOf(0, 1), solution.countBits(1))
        assertArrayEquals(intArrayOf(0, 1, 1), solution.countBits(2))
        assertArrayEquals(intArrayOf(0, 1, 1, 2), solution.countBits(3))
        assertArrayEquals(intArrayOf(0, 1, 1, 2, 1, 2), solution.countBits(5))
    }

    @Test
    fun countBits2() {
        assertArrayEquals(intArrayOf(0), solutionTwo.countBits(0))
        assertArrayEquals(intArrayOf(0, 1), solutionTwo.countBits(1))
        assertArrayEquals(intArrayOf(0, 1, 1), solutionTwo.countBits(2))
        assertArrayEquals(intArrayOf(0, 1, 1, 2), solutionTwo.countBits(3))
        assertArrayEquals(intArrayOf(0, 1, 1, 2, 1, 2), solutionTwo.countBits(5))
    }

    @Test
    fun countBits3() {
        assertArrayEquals(intArrayOf(0), solutionThree.countBits(0))
        assertArrayEquals(intArrayOf(0, 1), solutionThree.countBits(1))
        assertArrayEquals(intArrayOf(0, 1, 1), solutionThree.countBits(2))
        assertArrayEquals(intArrayOf(0, 1, 1, 2), solutionThree.countBits(3))
        assertArrayEquals(intArrayOf(0, 1, 1, 2, 1, 2), solutionThree.countBits(5))
    }

    @Ignore("Unimplemented")
    @Test
    fun countBitsFollowUp() {
        assertArrayEquals(intArrayOf(0), followUpSolution.countBits(0))
        assertArrayEquals(intArrayOf(0, 1), followUpSolution.countBits(1))
        assertArrayEquals(intArrayOf(0, 1, 1), followUpSolution.countBits(2))
        assertArrayEquals(intArrayOf(0, 1, 1, 2), followUpSolution.countBits(3))
        assertArrayEquals(intArrayOf(0, 1, 1, 2, 1, 2), followUpSolution.countBits(5))
    }
}