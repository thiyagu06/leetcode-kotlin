package algorithms.easy._371_sum_of_two_integers

import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore

class SumOfTwoIntegersTest {

    private val solution = Solution()

    @Ignore
    @Test
    fun getSum() {
        assertEquals(3, solution.getSum(1, 2))
        assertEquals(1, solution.getSum(-2, 3))
    }
}