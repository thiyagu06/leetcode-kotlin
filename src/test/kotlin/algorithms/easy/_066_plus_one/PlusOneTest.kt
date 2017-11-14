package algorithms.easy._066_plus_one

import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 * @author nrojiani
 * @date 11/12/17
 */
class PlusOneTest {
    private val arr0 = intArrayOf(0)
    private val arr1 = intArrayOf(1)
    private val arr2 = intArrayOf(2)
    private val arr9 = intArrayOf(9)
    private val arr10 = intArrayOf(1, 0)
    private val arr99 = intArrayOf(9, 9)
    private val arr100 = intArrayOf(1, 0, 0)


    @Test
    fun plusOne() {
        val solution = Solution()
        assertArrayEquals(arr1, solution.plusOne(arr0))
        assertArrayEquals(arr2, solution.plusOne(arr1))
        assertArrayEquals(arr10, solution.plusOne(arr9))
        assertArrayEquals(arr100, solution.plusOne(arr99))
        assertArrayEquals(intArrayOf(9, 9, 0, 0), solution.plusOne(intArrayOf(9, 8, 9, 9)))
    }

    @Test
    fun plusOneRecursive() {
        val rSolution = RecursiveSolution()
        assertArrayEquals(arr1, rSolution.plusOne(arr0))
        assertArrayEquals(arr2, rSolution.plusOne(arr1))
        assertArrayEquals(arr10, rSolution.plusOne(arr9))
        assertArrayEquals(arr100, rSolution.plusOne(arr99))
        assertArrayEquals(intArrayOf(9, 9, 0, 0), rSolution.plusOne(intArrayOf(9, 8, 9, 9)))
    }

}