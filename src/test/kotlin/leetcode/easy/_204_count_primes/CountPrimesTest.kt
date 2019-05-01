package leetcode.easy._204_count_primes

import org.junit.Test

import org.junit.Assert.*

class CountPrimesTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun countPrimes() {
        assertEquals(0, solution.countPrimes(0))
        assertEquals(0, solution.countPrimes(1))
        assertEquals(0, solution.countPrimes(2))
        assertEquals(1, solution.countPrimes(3))
        assertEquals(2, solution.countPrimes(4))
        assertEquals(10, solution.countPrimes(30))
        assertEquals(25, solution.countPrimes(100))
    }

    @Test
    fun countPrimesLarge() {
        assertEquals(95, solution.countPrimes(500))
        assertEquals(168, solution.countPrimes(1000))
        assertEquals(669, solution.countPrimes(5000))
        assertEquals(9592, solution.countPrimes(100000))
        assertEquals(41537, solution.countPrimes(499979))
    }

    @Test
    fun countPrimes2() {
        assertEquals(0, solution2.countPrimes(0))
        assertEquals(0, solution2.countPrimes(1))
        assertEquals(0, solution2.countPrimes(2))
        assertEquals(1, solution2.countPrimes(3))
        assertEquals(2, solution2.countPrimes(4))
        assertEquals(10, solution2.countPrimes(30))
        assertEquals(25, solution2.countPrimes(100))
    }

    @Test
    fun countPrimesLarge2() {
        assertEquals(95, solution2.countPrimes(500))
        assertEquals(168, solution2.countPrimes(1000))
        assertEquals(669, solution2.countPrimes(5000))
        assertEquals(9592, solution2.countPrimes(100000))
        assertEquals(41537, solution2.countPrimes(499979))
    }

}
