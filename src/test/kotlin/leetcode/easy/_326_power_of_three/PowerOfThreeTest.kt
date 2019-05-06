package leetcode.easy._326_power_of_three

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PowerOfThreeTest {
    private val solution = Solution()
    private val solutionTwo = SolutionTwo()
    private val solutionThree = SolutionThree()
    private val followUpSolution = FollowUpSolution()

    @Test
    fun isPowerOfThree() {
        assertTrue(solution.isPowerOfThree(1))
        assertTrue(solution.isPowerOfThree(3))
        assertTrue(solution.isPowerOfThree(9))
        assertTrue(solution.isPowerOfThree(27))
        assertTrue(solution.isPowerOfThree(81))
        assertTrue(solution.isPowerOfThree(243))
        assertTrue(solution.isPowerOfThree(729))
        assertTrue(solution.isPowerOfThree(1162261467))

        assertFalse(solution.isPowerOfThree(0))
        assertFalse(solution.isPowerOfThree(2))
        assertFalse(solution.isPowerOfThree(4))
        assertFalse(solution.isPowerOfThree(10))
        assertFalse(solution.isPowerOfThree(100))
        assertFalse(solution.isPowerOfThree(730))
        assertFalse(solution.isPowerOfThree(1594322))
        assertFalse(solution.isPowerOfThree(Int.MAX_VALUE))
        assertFalse(solution.isPowerOfThree(Int.MAX_VALUE - 1))
        assertFalse(solution.isPowerOfThree(Int.MAX_VALUE - 2))
    }

    @Test
    fun isPowerOfThree2() {
        assertTrue(solutionTwo.isPowerOfThree(1))
        assertTrue(solutionTwo.isPowerOfThree(3))
        assertTrue(solutionTwo.isPowerOfThree(9))
        assertTrue(solutionTwo.isPowerOfThree(27))
        assertTrue(solutionTwo.isPowerOfThree(81))
        assertTrue(solutionTwo.isPowerOfThree(243))
        assertTrue(solutionTwo.isPowerOfThree(729))
        assertTrue(solutionTwo.isPowerOfThree(1162261467))

        assertFalse(solutionTwo.isPowerOfThree(0))
        assertFalse(solutionTwo.isPowerOfThree(2))
        assertFalse(solutionTwo.isPowerOfThree(4))
        assertFalse(solutionTwo.isPowerOfThree(10))
        assertFalse(solutionTwo.isPowerOfThree(100))
        assertFalse(solutionTwo.isPowerOfThree(730))
        assertFalse(solutionTwo.isPowerOfThree(1594322))
        assertFalse(solutionTwo.isPowerOfThree(Int.MAX_VALUE))
        assertFalse(solutionTwo.isPowerOfThree(Int.MAX_VALUE - 1))
        assertFalse(solutionTwo.isPowerOfThree(Int.MAX_VALUE - 2))
    }

    @Test
    fun isPowerOfThree3() {
        assertTrue(solutionThree.isPowerOfThree(1))
        assertTrue(solutionThree.isPowerOfThree(3))
        assertTrue(solutionThree.isPowerOfThree(9))
        assertTrue(solutionThree.isPowerOfThree(27))
        assertTrue(solutionThree.isPowerOfThree(81))
        assertTrue(solutionThree.isPowerOfThree(243))
        assertTrue(solutionThree.isPowerOfThree(729))
        assertTrue(solutionThree.isPowerOfThree(1162261467))

        assertFalse(solutionThree.isPowerOfThree(0))
        assertFalse(solutionThree.isPowerOfThree(2))
        assertFalse(solutionThree.isPowerOfThree(4))
        assertFalse(solutionThree.isPowerOfThree(10))
        assertFalse(solutionThree.isPowerOfThree(100))
        assertFalse(solutionThree.isPowerOfThree(730))
        assertFalse(solutionThree.isPowerOfThree(1594322))
        assertFalse(solutionThree.isPowerOfThree(Int.MAX_VALUE))
        assertFalse(solutionThree.isPowerOfThree(Int.MAX_VALUE - 1))
        assertFalse(solutionThree.isPowerOfThree(Int.MAX_VALUE - 2))
    }

    @Test
    fun isPowerOfThreeFollowup() {
        assertTrue(followUpSolution.isPowerOfThree(1))
        assertTrue(followUpSolution.isPowerOfThree(3))
        assertTrue(followUpSolution.isPowerOfThree(9))
        assertTrue(followUpSolution.isPowerOfThree(27))
        assertTrue(followUpSolution.isPowerOfThree(81))
        assertTrue(followUpSolution.isPowerOfThree(243))
        assertTrue(followUpSolution.isPowerOfThree(729))
        assertTrue(followUpSolution.isPowerOfThree(1162261467))

        assertFalse(followUpSolution.isPowerOfThree(0))
        assertFalse(followUpSolution.isPowerOfThree(2))
        assertFalse(followUpSolution.isPowerOfThree(4))
        assertFalse(followUpSolution.isPowerOfThree(10))
        assertFalse(followUpSolution.isPowerOfThree(100))
        assertFalse(followUpSolution.isPowerOfThree(730))
        assertFalse(followUpSolution.isPowerOfThree(1594322))
        assertFalse(followUpSolution.isPowerOfThree(1594324))
        assertFalse(followUpSolution.isPowerOfThree(Int.MAX_VALUE))
        assertFalse(followUpSolution.isPowerOfThree(Int.MAX_VALUE - 1))
        assertFalse(followUpSolution.isPowerOfThree(Int.MAX_VALUE - 2))
    }
}