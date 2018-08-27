package leetcode.easy._070_climbing_stairs

import org.junit.Test

import org.junit.Assert.*

class ClimbingStairsTest {
    private val naiveSolution = NaiveSolution()
    private val memo = MemoizedSolution()
    private val tabulation = TabulationSolution()
    private val optimal = OptimalSolution()

    @Test
    fun climbStairs() {
        assertEquals(1, naiveSolution.climbStairs(1))
        assertEquals(2, naiveSolution.climbStairs(2))
        assertEquals(3, naiveSolution.climbStairs(3))
        assertEquals(5, naiveSolution.climbStairs(4))
        assertEquals(34, naiveSolution.climbStairs(8))
    }

    @Test
    fun climbStairsMemoized() {
        assertEquals(1, memo.climbStairs(1))
        assertEquals(2, memo.climbStairs(2))
        assertEquals(3, memo.climbStairs(3))
        assertEquals(5, memo.climbStairs(4))
        assertEquals(34, memo.climbStairs(8))
    }

    @Test
    fun climbStairsTabulation() {
        assertEquals(1, tabulation.climbStairs(1))
        assertEquals(2, tabulation.climbStairs(2))
        assertEquals(3, tabulation.climbStairs(3))
        assertEquals(5, tabulation.climbStairs(4))
        assertEquals(34, tabulation.climbStairs(8))
    }

    @Test
    fun climbStairsOptimal() {
        assertEquals(1, optimal.climbStairs(1))
        assertEquals(2, optimal.climbStairs(2))
        assertEquals(3, optimal.climbStairs(3))
        assertEquals(5, optimal.climbStairs(4))
        assertEquals(34, optimal.climbStairs(8))
    }

}
