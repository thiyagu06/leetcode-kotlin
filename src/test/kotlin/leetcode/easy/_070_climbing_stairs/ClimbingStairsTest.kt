package leetcode.easy._070_climbing_stairs

import org.junit.Test

import kotlin.test.assertEquals

class ClimbingStairsTest {
    private val naiveSolution = NaiveSolution()
    private val memo1 = MemoizedSolutionOne()
    private val memo2 = MemoizedSolutionTwo()
    private val memo3 = MemoizedSolutionThree()
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
    fun climbStairsMemoized1() {
        assertEquals(1, memo1.climbStairs(1))
        assertEquals(2, memo1.climbStairs(2))
        assertEquals(3, memo1.climbStairs(3))
        assertEquals(5, memo1.climbStairs(4))
        assertEquals(34, memo1.climbStairs(8))
    }

    @Test
    fun climbStairsMemoized2() {
        assertEquals(1, memo2.climbStairs(1))
        assertEquals(2, memo2.climbStairs(2))
        assertEquals(3, memo2.climbStairs(3))
        assertEquals(5, memo2.climbStairs(4))
        assertEquals(34, memo2.climbStairs(8))
    }

    @Test
    fun climbStairsMemoized3() {
        assertEquals(1, memo3.climbStairs(1))
        assertEquals(2, memo3.climbStairs(2))
        assertEquals(3, memo3.climbStairs(3))
        assertEquals(5, memo3.climbStairs(4))
        assertEquals(34, memo3.climbStairs(8))
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
