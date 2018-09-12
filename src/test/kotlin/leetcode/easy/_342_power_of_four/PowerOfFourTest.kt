package leetcode.easy._342_power_of_four

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PowerOfFourTest {

    private val solution = Solution()
    private val solutionTwo = SolutionTwo()
    private val powersOfFour = setOf(1, 4, 16, 64, 256, 1024)

    @Test
    fun isPowerOfFour() {
        (0..1024).forEach { n ->
            if (n in powersOfFour) {
                assertTrue(solution.isPowerOfFour(n))
            } else {
                assertFalse(solution.isPowerOfFour(n))
            }
        }
        (-1 downTo -10).forEach { n ->
            assertFalse(solution.isPowerOfFour(n))
        }
    }

    @Test
    fun isPowerOfFour2() {
        (0..1024).forEach { n ->
            if (n in powersOfFour) {
                println(n)
                assertTrue(solutionTwo.isPowerOfFour(n))
            } else {
                assertFalse(solutionTwo.isPowerOfFour(n))
            }
        }
        (-1 downTo -10).forEach { n ->
            assertFalse(solutionTwo.isPowerOfFour(n))
        }
    }

}