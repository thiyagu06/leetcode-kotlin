package algorithms.easy._645_set_mismatch

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class SetMismatchTest {

    private val solution = Solution()
    private val optimal = OptimalSolution()

    @Test
    fun findErrorNums() {
        assertArrayEquals(intArrayOf(1, 2), solution.findErrorNums(intArrayOf(4, 1, 3, 1)))
        assertArrayEquals(intArrayOf(2, 3), solution.findErrorNums(intArrayOf(1, 2, 2, 4)))
    }


    @Test
    fun findErrorNumsOptimal() {
        assertArrayEquals(intArrayOf(1, 2), optimal.findErrorNums(intArrayOf(4, 1, 3, 1)))
        assertArrayEquals(intArrayOf(2, 3), optimal.findErrorNums(intArrayOf(1, 2, 2, 4)))
    }
}