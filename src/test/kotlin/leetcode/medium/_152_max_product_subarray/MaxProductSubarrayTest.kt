package leetcode.medium._152_max_product_subarray

import kotlin.test.assertEquals
import org.junit.Test

class MaxProductSubarrayTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun maxProduct() {
        assertEquals(6, solution.maxProduct(intArrayOf(2, 3, -2, 4)))
        assertEquals(0, solution.maxProduct(intArrayOf(-2, 0, -1)))
        assertEquals(0, solution.maxProduct(intArrayOf()))
        assertEquals(24, solution.maxProduct(intArrayOf(-2, 3, -4)))
        assertEquals(12, solution.maxProduct(intArrayOf(-4, -3, -2)))
    }

    @Test
    fun maxProductSubarray() {
        assertEquals(4, solution.maxProductSubarray(intArrayOf(2, 3, -2, 4), k = 1))
        assertEquals(6, solution.maxProductSubarray(intArrayOf(2, 3, -2, 4), k = 2))
        assertEquals(-12, solution.maxProductSubarray(intArrayOf(2, 3, -2, 4), k = 3))
        assertEquals(-48, solution.maxProductSubarray(intArrayOf(2, 3, -2, 4), k = 4))
        assertEquals(0, solution.maxProductSubarray(intArrayOf(-2, 0, -1), k = 1))
        assertEquals(0, solution.maxProductSubarray(intArrayOf(-2, 0, -1), k = 2))
        assertEquals(0, solution.maxProductSubarray(intArrayOf(-2, 0, -1), k = 3))
        assertEquals(2, solution.maxProductSubarray(intArrayOf(-2, -1, 0), k = 2))
        assertEquals(0, solution.maxProductSubarray(intArrayOf(), k = 0))
    }

    @Test
    fun maxProduct2() {
        assertEquals(6, solution2.maxProduct(intArrayOf(2, 3, -2, 4)))
        assertEquals(0, solution2.maxProduct(intArrayOf(-2, 0, -1)))
        assertEquals(0, solution2.maxProduct(intArrayOf()))
        assertEquals(24, solution2.maxProduct(intArrayOf(-2, 3, -4)))
        assertEquals(12, solution2.maxProduct(intArrayOf(-4, -3, -2)))
    }
}