package leetcode.easy._674_longest_continuous_increasing_sub

import org.junit.Test

import org.junit.Assert.*

class LongestContinuousIncreasingSubsequenceTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    @Test
    fun findLengthOfLCIS() {
        assertEquals(3, solution.findLengthOfLCIS(intArrayOf(1, 3, 5, 4, 7)))
        assertEquals(1, solution.findLengthOfLCIS(intArrayOf(2, 2, 2, 2, 2)))
        assertEquals(4, solution.findLengthOfLCIS(intArrayOf(1, 3, 7, 3, 7, 1, 3, 7, 9)))
        assertEquals(1, solution.findLengthOfLCIS(intArrayOf(7)))
    }

    @Test
    fun findLengthOfLCIS2() {
        assertEquals(3, solution2.findLengthOfLCIS(intArrayOf(1, 3, 5, 4, 7)))
        assertEquals(1, solution2.findLengthOfLCIS(intArrayOf(2, 2, 2, 2, 2)))
        assertEquals(4, solution2.findLengthOfLCIS(intArrayOf(1, 3, 7, 3, 7, 1, 3, 7, 9)))
        assertEquals(1, solution2.findLengthOfLCIS(intArrayOf(7)))
    }

    @Test
    fun findLengthOfLCIS3() {
        assertEquals(3, solution3.findLengthOfLCIS(intArrayOf(1, 3, 5, 4, 7)))
        assertEquals(1, solution3.findLengthOfLCIS(intArrayOf(2, 2, 2, 2, 2)))
        assertEquals(4, solution3.findLengthOfLCIS(intArrayOf(1, 3, 7, 3, 7, 1, 3, 7, 9)))
        assertEquals(1, solution3.findLengthOfLCIS(intArrayOf(7)))
    }
}