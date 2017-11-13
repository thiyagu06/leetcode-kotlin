package algorithms.easy._066_plus_one

import org.junit.Assert.assertEquals
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
        assertEquals(arr1.toList(), solution.plusOne(arr0).toList())
        assertEquals(arr2.toList(), solution.plusOne(arr1).toList())
        assertEquals(arr10.toList(), solution.plusOne(arr9).toList())
        assertEquals(arr100.toList(), solution.plusOne(arr99).toList())
        assertEquals(intArrayOf(9, 9, 0, 0).toList(), solution.plusOne(intArrayOf(9, 8, 9, 9)).toList())
    }

    @Test
    fun plusOneRecursive() {
        val rSolution = RecursiveSolution()
        assertEquals(arr1.toList(), rSolution.plusOne(arr0).toList())
        assertEquals(arr2.toList(), rSolution.plusOne(arr1).toList())
        assertEquals(arr10.toList(), rSolution.plusOne(arr9).toList())
        assertEquals(arr100.toList(), rSolution.plusOne(arr99).toList())
        assertEquals(intArrayOf(9, 9, 0, 0).toList(), rSolution.plusOne(intArrayOf(9, 8, 9, 9)).toList())
    }

}