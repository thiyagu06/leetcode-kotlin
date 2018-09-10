package leetcode.easy._628_maximum_product_of_three_numbers

import org.junit.Test

import org.junit.Assert.*
import kotlin.system.measureTimeMillis

class MaxProductThreeNumbersTest {

    private val solution = Solution()
    private val solution2 = Solution2()

    @Test
    fun maximumProduct() {
        val ms = measureTimeMillis {
            assertEquals(6, solution.maximumProduct(intArrayOf(1, 2, 3)))
            assertEquals(24, solution.maximumProduct(intArrayOf(1, 2, 3, 4)))
            assertEquals(-1, solution.maximumProduct(intArrayOf(-1, -1, -1)))
            assertEquals(7, solution.maximumProduct(intArrayOf(-1, -1, 1, 7)))
            assertEquals(0, solution.maximumProduct(intArrayOf(0, 0, 0)))
            assertEquals(0, solution.maximumProduct(intArrayOf(0, 0, 7)))
            assertEquals(0, solution.maximumProduct(intArrayOf(0, 7, 7)))
            assertEquals(98010, solution.maximumProduct(intArrayOf(-99, -99, 10)))
            assertEquals(6, solution.maximumProduct(intArrayOf(-1, -2, 1, 2, 3)))
        }
        println("$ms ms")
    }

    @Test
    fun maximumProduct2() {
        val ms = measureTimeMillis {
            assertEquals(6, solution2.maximumProduct(intArrayOf(1, 2, 3)))
            assertEquals(24, solution2.maximumProduct(intArrayOf(1, 2, 3, 4)))
            assertEquals(-1, solution2.maximumProduct(intArrayOf(-1, -1, -1)))
            assertEquals(7, solution2.maximumProduct(intArrayOf(-1, -1, 1, 7)))
            assertEquals(0, solution2.maximumProduct(intArrayOf(0, 0, 0)))
            assertEquals(0, solution2.maximumProduct(intArrayOf(0, 0, 7)))
            assertEquals(0, solution2.maximumProduct(intArrayOf(0, 7, 7)))
            assertEquals(98010, solution2.maximumProduct(intArrayOf(-99, -99, 10)))
            assertEquals(6, solution2.maximumProduct(intArrayOf(-1, -2, 1, 2, 3)))
        }
        println("$ms ms")
    }
}