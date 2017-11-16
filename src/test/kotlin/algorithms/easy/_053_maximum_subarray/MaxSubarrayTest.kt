package algorithms.easy._053_maximum_subarray

import org.junit.Test

import org.junit.Assert.*
import kotlin.system.measureTimeMillis

/**
 * @author nrojiani
 * @date 11/15/17
 */
class MaxSubarrayTest {

    @Test
    fun maxSubArray() {
        val solution = Solution()
        val ms = measureTimeMillis {
            assertEquals(-1, solution.maxSubArray(intArrayOf(-1)))
            assertEquals(-1, solution.maxSubArray(intArrayOf(-1, -1, -1)))
            assertEquals(6, solution.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
        }
        println("$ms ms")
    }

    @Test
    fun maxSubArray2() {
        val solution2 = Solution2()
        val ms = measureTimeMillis {
            assertEquals(-1, solution2.maxSubArray(intArrayOf(-1)))
            assertEquals(-1, solution2.maxSubArray(intArrayOf(-1, -1, -1)))
            assertEquals(6, solution2.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
        }
        println("$ms ms")
    }

    @Test
    fun maxSubArrayDP() {
        val solutionDP = DPSolution()
        val ms = measureTimeMillis {
            assertEquals(-1, solutionDP.maxSubArray(intArrayOf(-1)))
            assertEquals(-1, solutionDP.maxSubArray(intArrayOf(-1, -1, -1)))
            assertEquals(6, solutionDP.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
        }
        println("$ms ms")
    }
}