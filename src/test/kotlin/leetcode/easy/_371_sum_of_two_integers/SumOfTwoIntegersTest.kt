package leetcode.easy._371_sum_of_two_integers

import org.junit.Test
import kotlin.test.assertEquals

class SumOfTwoIntegersTest {

    private val solution = Solution()
    private val solutionTwo = SolutionTwo()

    @Test
    fun getSum() {
        assertEquals(3, solution.getSum(1, 2))
        assertEquals(1, solution.getSum(-2, 3))
        assertEquals(0, solution.getSum(0, 0))
        assertEquals(7, solution.getSum(7, 0))
        assertEquals(7, solution.getSum(0, 7))
        assertEquals(Int.MAX_VALUE, solution.getSum(Int.MAX_VALUE, 0))
        assertEquals(Int.MIN_VALUE, solution.getSum(Int.MAX_VALUE, 1))
        assertEquals(Int.MAX_VALUE, solution.getSum(Int.MIN_VALUE, -1))
        assertEquals(-2, solution.getSum(-1, -1))
    }

    @Test
    fun getSum2() {
        assertEquals(3, solutionTwo.getSum(1, 2))
        assertEquals(1, solutionTwo.getSum(-2, 3))
        assertEquals(0, solutionTwo.getSum(0, 0))
        assertEquals(7, solutionTwo.getSum(7, 0))
        assertEquals(7, solutionTwo.getSum(0, 7))
        assertEquals(Int.MAX_VALUE, solutionTwo.getSum(Int.MAX_VALUE, 0))
        assertEquals(Int.MIN_VALUE, solutionTwo.getSum(Int.MAX_VALUE, 1))
        assertEquals(Int.MAX_VALUE, solutionTwo.getSum(Int.MIN_VALUE, -1))
        assertEquals(-2, solutionTwo.getSum(-1, -1))
    }
}