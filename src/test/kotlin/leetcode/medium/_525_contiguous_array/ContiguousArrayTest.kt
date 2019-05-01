package leetcode.medium._525_contiguous_array

import org.junit.Test

import kotlin.test.assertEquals

class ContiguousArrayTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    @Test
    fun findMaxLength() {
        assertEquals(0, solution.findMaxLength(intArrayOf()))
        assertEquals(0, solution.findMaxLength(intArrayOf(0)))
        assertEquals(2, solution.findMaxLength(intArrayOf(0, 1)))
        assertEquals(2, solution.findMaxLength(intArrayOf(1, 0)))
        assertEquals(2, solution.findMaxLength(intArrayOf(0, 1, 0)))
        assertEquals(4, solution.findMaxLength(intArrayOf(1, 1, 1, 0, 1, 0, 1)))
    }

    @Test
    fun findMaxLength2() {
        assertEquals(0, solution2.findMaxLength(intArrayOf()))
        assertEquals(0, solution2.findMaxLength(intArrayOf(0)))
        assertEquals(2, solution2.findMaxLength(intArrayOf(0, 1)))
        assertEquals(2, solution2.findMaxLength(intArrayOf(1, 0)))
        assertEquals(2, solution2.findMaxLength(intArrayOf(0, 1, 0)))
        assertEquals(4, solution2.findMaxLength(intArrayOf(1, 1, 1, 0, 1, 0, 1)))
    }

    @Test
    fun findMaxLength3() {
        assertEquals(0, solution3.findMaxLength(intArrayOf()))
        assertEquals(0, solution3.findMaxLength(intArrayOf(0)))
        assertEquals(2, solution3.findMaxLength(intArrayOf(0, 1)))
        assertEquals(2, solution3.findMaxLength(intArrayOf(1, 0)))
        assertEquals(2, solution3.findMaxLength(intArrayOf(0, 1, 0)))
        assertEquals(4, solution3.findMaxLength(intArrayOf(1, 1, 1, 0, 1, 0, 1)))
    }
}