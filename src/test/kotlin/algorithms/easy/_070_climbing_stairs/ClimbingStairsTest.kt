package algorithms.easy._070_climbing_stairs

import org.junit.Test

import org.junit.Assert.*

/**
 * @author nrojiani
 * @date 11/12/17
 */
class ClimbingStairsTest {
    private val solution = Solution()

    @Test
    fun climbStairs() {
        assertEquals(0, solution.climbStairs(0))
        assertEquals(1, solution.climbStairs(1))
        assertEquals(2, solution.climbStairs(2))
        assertEquals(3, solution.climbStairs(3))
        assertEquals(5, solution.climbStairs(4))
    }

    @Test
    fun climbStairsMemoized() {
        assertEquals(0, solution.climbStairsMemoized(0))
        assertEquals(1, solution.climbStairsMemoized(1))
        assertEquals(2, solution.climbStairsMemoized(2))
        assertEquals(3, solution.climbStairsMemoized(3))
        assertEquals(5, solution.climbStairsMemoized(4))
    }

}