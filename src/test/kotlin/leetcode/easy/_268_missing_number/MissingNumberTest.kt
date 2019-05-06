package leetcode.easy._268_missing_number

import org.junit.Test
import kotlin.test.assertEquals

class MissingNumberTest {
    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val followup = FollowUpSolution()
    private val followup2 = FollowUpSolutionTwo()
    private val followup3 = FollowUpSolution3()

    @Test
    fun missingNumber1() {
        assertEquals(0, solution.missingNumber(intArrayOf(1, 2, 3)))
        assertEquals(1, solution.missingNumber(intArrayOf(0, 2, 3)))
        assertEquals(2, solution.missingNumber(intArrayOf(0, 1, 3)))
        assertEquals(3, solution.missingNumber(intArrayOf(0, 1, 2, 4)))
        assertEquals(2, solution.missingNumber(intArrayOf(3, 0, 1)))
        assertEquals(1, solution.missingNumber(intArrayOf(0)))
        assertEquals(8, solution.missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))
    }

    @Test
    fun missingNumber2() {
        assertEquals(0, solution2.missingNumber(intArrayOf(1, 2, 3)))
        assertEquals(1, solution2.missingNumber(intArrayOf(0, 2, 3)))
        assertEquals(2, solution2.missingNumber(intArrayOf(0, 1, 3)))
        assertEquals(3, solution2.missingNumber(intArrayOf(0, 1, 2)))
        assertEquals(8, solution2.missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))
    }

    @Test
    fun missingNumberFollowUp() {
        assertEquals(0, followup.missingNumber(intArrayOf(1, 2, 3)))
        assertEquals(1, followup.missingNumber(intArrayOf(0, 2, 3)))
        assertEquals(2, followup.missingNumber(intArrayOf(0, 1, 3)))
        assertEquals(3, followup.missingNumber(intArrayOf(0, 1, 2)))
        assertEquals(8, followup.missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))
    }

    @Test
    fun missingNumberFollowUp2() {
        assertEquals(0, followup2.missingNumber(intArrayOf(1, 2, 3)))
        assertEquals(1, followup2.missingNumber(intArrayOf(0, 2, 3)))
        assertEquals(2, followup2.missingNumber(intArrayOf(0, 1, 3)))
        assertEquals(3, followup2.missingNumber(intArrayOf(0, 1, 2)))
        assertEquals(8, followup2.missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))
    }

    @Test
    fun missingNumberFollowUp3() {
        assertEquals(0, followup3.missingNumber(intArrayOf(1, 2, 3)))
        assertEquals(1, followup3.missingNumber(intArrayOf(0, 2, 3)))
        assertEquals(2, followup3.missingNumber(intArrayOf(0, 1, 3)))
        assertEquals(3, followup3.missingNumber(intArrayOf(0, 1, 2)))
        assertEquals(8, followup3.missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))
    }
}