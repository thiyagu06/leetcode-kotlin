package leetcode.easy._053_maximum_subarray

import org.junit.Assert.assertEquals
import org.junit.Test

class MaxSubarrayTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()
    private val solution4 = SolutionFour()
    private val solutionDP = DPSolution()

    @Test
    fun maxSubArray() {
        assertEquals(-1, solution.maxSubArray(intArrayOf(-1)))
        assertEquals(-1, solution.maxSubArray(intArrayOf(-1, -2, -3)))
        assertEquals(19, solution.maxSubArray(intArrayOf(0, 1, 2, 4, 5, 7)))
        assertEquals(Int.MIN_VALUE, solution.maxSubArray(intArrayOf(Int.MIN_VALUE)))
        assertEquals(6, solution.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    }

    @Test
    fun maxSubArray2() {
        assertEquals(-1, solution2.maxSubArray(intArrayOf(-1)))
        assertEquals(-1, solution2.maxSubArray(intArrayOf(-1, -2, -3)))
        assertEquals(19, solution2.maxSubArray(intArrayOf(0, 1, 2, 4, 5, 7)))
        assertEquals(Int.MIN_VALUE, solution2.maxSubArray(intArrayOf(Int.MIN_VALUE)))
        assertEquals(6, solution2.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    }

    @Test
    fun maxSubArray3() {
        assertEquals(-1, solution3.maxSubArray(intArrayOf(-1)))
        assertEquals(-1, solution3.maxSubArray(intArrayOf(-1, -2, -3)))
        assertEquals(19, solution3.maxSubArray(intArrayOf(0, 1, 2, 4, 5, 7)))
        assertEquals(Int.MIN_VALUE, solution3.maxSubArray(intArrayOf(Int.MIN_VALUE)))
        assertEquals(6, solution3.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    }

    @Test
    fun maxSubArray4() {
        assertEquals(-1, solution4.maxSubArray(intArrayOf(-1)))
        assertEquals(-1, solution4.maxSubArray(intArrayOf(-1, -2, -3)))
        assertEquals(19, solution4.maxSubArray(intArrayOf(0, 1, 2, 4, 5, 7)))
        assertEquals(Int.MIN_VALUE, solution4.maxSubArray(intArrayOf(Int.MIN_VALUE)))
        assertEquals(6, solution4.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    }

    @Test
    fun maxSubArrayDP() {
        assertEquals(-1, solutionDP.maxSubArray(intArrayOf(-1)))
        assertEquals(-1, solutionDP.maxSubArray(intArrayOf(-1, -2, -3)))
        assertEquals(19, solutionDP.maxSubArray(intArrayOf(0, 1, 2, 4, 5, 7)))
        assertEquals(Int.MIN_VALUE, solutionDP.maxSubArray(intArrayOf(Int.MIN_VALUE)))
        assertEquals(6, solutionDP.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    }
}
