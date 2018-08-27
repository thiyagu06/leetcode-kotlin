package algorithms.easy._326_power_of_three

import org.junit.Test

import org.junit.Assert.*

class PowerOfThreeTest {
    private val solution = Solution()
    private val solutionAlt = SolutionAlt()

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
        assertFalse(solution.isPowerOfThree(Int.MAX_VALUE))
        assertFalse(solution.isPowerOfThree(Int.MAX_VALUE - 1))
        assertFalse(solution.isPowerOfThree(Int.MAX_VALUE - 2))
    }

    @Test
    fun isPowerOfThreeAlt() {
        assertTrue(solutionAlt.isPowerOfThree(1))
        assertTrue(solutionAlt.isPowerOfThree(3))
        assertTrue(solutionAlt.isPowerOfThree(9))
        assertTrue(solutionAlt.isPowerOfThree(27))
        assertTrue(solutionAlt.isPowerOfThree(81))
        assertTrue(solutionAlt.isPowerOfThree(243))
        assertTrue(solutionAlt.isPowerOfThree(729))
        assertTrue(solutionAlt.isPowerOfThree(1162261467))

        assertFalse(solutionAlt.isPowerOfThree(0))
        assertFalse(solutionAlt.isPowerOfThree(2))
        assertFalse(solutionAlt.isPowerOfThree(4))
        assertFalse(solutionAlt.isPowerOfThree(10))
        assertFalse(solutionAlt.isPowerOfThree(100))
        assertFalse(solutionAlt.isPowerOfThree(730))
        assertFalse(solutionAlt.isPowerOfThree(Int.MAX_VALUE))
        assertFalse(solutionAlt.isPowerOfThree(Int.MAX_VALUE - 1))
        assertFalse(solutionAlt.isPowerOfThree(Int.MAX_VALUE - 2))
    }

}