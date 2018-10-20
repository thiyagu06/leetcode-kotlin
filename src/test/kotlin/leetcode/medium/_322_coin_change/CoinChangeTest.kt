package leetcode.medium._322_coin_change

import org.junit.Test

import org.junit.Assert.*

class CoinChangeTest {

    private val solution = Solution()

    @Test
    fun coinChange() {
        assertEquals(0, solution.coinChange(intArrayOf(1, 2, 5), 0))
        assertEquals(3, solution.coinChange(intArrayOf(1, 2, 5), 11))
        assertEquals(2, solution.coinChange(intArrayOf(1, 3, 4), 6))
        assertEquals(-1, solution.coinChange(intArrayOf(2), 3))
        assertEquals(20, solution.coinChange(intArrayOf(1, 2, 5), 100))
    }

    @Test
    fun `coinChange - bigInput`() {
        assertEquals(20, solution.coinChange(intArrayOf(186, 419, 83, 408), 6249))
    }

    @Test
    fun `coinChange - Int Overflow`() {
        assertEquals(2, solution.coinChange(intArrayOf(1, Int.MAX_VALUE), 2))
    }

}