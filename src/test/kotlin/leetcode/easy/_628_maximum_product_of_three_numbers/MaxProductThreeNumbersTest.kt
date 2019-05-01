package leetcode.easy._628_maximum_product_of_three_numbers

import kotlin.test.assertEquals
import org.junit.Test

class MaxProductThreeNumbersTest {

    private val solution = Solution()
    private val solutionTwo = SolutionTwo()

    @Test
    fun maximumProduct() {
        assertEquals(6, solution.maximumProduct(intArrayOf(1, 2, 3)))
        assertEquals(24, solution.maximumProduct(intArrayOf(1, 2, 3, 4)))
        assertEquals(-1, solution.maximumProduct(intArrayOf(-1, -1, -1)))
        assertEquals(7, solution.maximumProduct(intArrayOf(-1, -1, 1, 7)))
        assertEquals(0, solution.maximumProduct(intArrayOf(0, 0, 0)))
        assertEquals(0, solution.maximumProduct(intArrayOf(0, 0, 7)))
        assertEquals(0, solution.maximumProduct(intArrayOf(0, 7, 7)))
        assertEquals(98010, solution.maximumProduct(intArrayOf(-99, -99, 10)))
        assertEquals(6, solution.maximumProduct(intArrayOf(-1, -2, 1, 2, 3)))
        assertEquals(1, solution.maximumProduct(intArrayOf(1, 0, -1, -1)))
        assertEquals(1, solution.maximumProduct(intArrayOf(1, 1, 0, -1, -1)))
        assertEquals(1000, solution.maximumProduct(intArrayOf(10, 0, 10, 10)))
    }

    @Test
    fun maximumProduct2() {
        assertEquals(6, solutionTwo.maximumProduct(intArrayOf(1, 2, 3)))
        assertEquals(24, solutionTwo.maximumProduct(intArrayOf(1, 2, 3, 4)))
        assertEquals(-1, solutionTwo.maximumProduct(intArrayOf(-1, -1, -1)))
        assertEquals(7, solutionTwo.maximumProduct(intArrayOf(-1, -1, 1, 7)))
        assertEquals(0, solutionTwo.maximumProduct(intArrayOf(0, 0, 0)))
        assertEquals(0, solutionTwo.maximumProduct(intArrayOf(0, 0, 7)))
        assertEquals(0, solutionTwo.maximumProduct(intArrayOf(0, 7, 7)))
        assertEquals(98010, solutionTwo.maximumProduct(intArrayOf(-99, -99, 10)))
        assertEquals(6, solutionTwo.maximumProduct(intArrayOf(-1, -2, 1, 2, 3)))
        assertEquals(1, solutionTwo.maximumProduct(intArrayOf(1, 0, -1, -1)))
        assertEquals(1, solutionTwo.maximumProduct(intArrayOf(1, 1, 0, -1, -1)))
        assertEquals(1000, solutionTwo.maximumProduct(intArrayOf(10, 0, 10, 10)))
    }
}