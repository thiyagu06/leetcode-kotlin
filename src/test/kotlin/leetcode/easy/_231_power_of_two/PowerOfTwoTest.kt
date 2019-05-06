package leetcode.easy._231_power_of_two

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PowerOfTwoTest {
    private val solution = Solution()
    private val solutionTwo = SolutionTwo()

    @Test
    fun isPowerOfTwo() {
        assertTrue(solution.isPowerOfTwo(1))
        assertTrue(solution.isPowerOfTwo(2))
        assertTrue(solution.isPowerOfTwo(4))
        assertTrue(solution.isPowerOfTwo(8))
        assertTrue(solution.isPowerOfTwo(32))
        assertTrue(solution.isPowerOfTwo(128))
        assertFalse(solution.isPowerOfTwo(218))
        assertFalse(solution.isPowerOfTwo(0))
        assertFalse(solution.isPowerOfTwo(-1))
        assertFalse(solution.isPowerOfTwo(3))
    }

    @Test
    fun isPowerOfTwoAlt() {
        assertTrue(solutionTwo.isPowerOfTwo(1))
        assertTrue(solutionTwo.isPowerOfTwo(2))
        assertTrue(solutionTwo.isPowerOfTwo(4))
        assertTrue(solutionTwo.isPowerOfTwo(8))
        assertTrue(solutionTwo.isPowerOfTwo(32))
        assertTrue(solutionTwo.isPowerOfTwo(128))
        assertFalse(solutionTwo.isPowerOfTwo(218))
        assertFalse(solutionTwo.isPowerOfTwo(0))
        assertFalse(solutionTwo.isPowerOfTwo(-1))
        assertFalse(solutionTwo.isPowerOfTwo(3))
    }
}