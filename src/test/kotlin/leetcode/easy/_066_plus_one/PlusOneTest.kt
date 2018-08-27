package algorithms.easy._066_plus_one

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class PlusOneTest {

    @Test
    fun plusOne() {
        val solution = Solution()
        assertArrayEquals(intArrayOf(1), solution.plusOne(intArrayOf(0)))
        assertArrayEquals(intArrayOf(2), solution.plusOne(intArrayOf(1)))
        assertArrayEquals(intArrayOf(1, 0), solution.plusOne(intArrayOf(9)))
        assertArrayEquals(intArrayOf(1, 0, 0), solution.plusOne(intArrayOf(9, 9)))
        assertArrayEquals(intArrayOf(1, 2, 4), solution.plusOne(intArrayOf(1, 2, 3)))
        assertArrayEquals(intArrayOf(9, 9, 0, 0), solution.plusOne(intArrayOf(9, 8, 9, 9)))
    }

    @Test
    fun plusOneRecursive() {
        val rSolution = RecursiveSolution()
        assertArrayEquals(intArrayOf(1), rSolution.plusOne(intArrayOf(0)))
        assertArrayEquals(intArrayOf(2), rSolution.plusOne(intArrayOf(1)))
        assertArrayEquals(intArrayOf(1, 0), rSolution.plusOne(intArrayOf(9)))
        assertArrayEquals(intArrayOf(1, 0, 0), rSolution.plusOne(intArrayOf(9, 9)))
        assertArrayEquals(intArrayOf(1, 2, 4), rSolution.plusOne(intArrayOf(1, 2, 3)))
        assertArrayEquals(intArrayOf(9, 9, 0, 0), rSolution.plusOne(intArrayOf(9, 8, 9, 9)))
    }

}
