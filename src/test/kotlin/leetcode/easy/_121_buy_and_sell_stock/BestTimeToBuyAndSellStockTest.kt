package leetcode.easy._121_buy_and_sell_stock

import org.junit.Assert.*
import org.junit.Test

class BestTimeToBuyAndSellStockTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    @Test
    fun maxProfit() {
        assertEquals(5, solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
        assertEquals(0, solution.maxProfit(intArrayOf(7, 6, 4, 3, 1)))
        assertEquals(0, solution.maxProfit(intArrayOf(3, 3, 3, 3)))
        assertEquals(0, solution.maxProfit(intArrayOf(3)))
        assertEquals(0, solution.maxProfit(intArrayOf()))
    }

    @Test
    fun maxProfit2() {
        assertEquals(5, solution2.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
        assertEquals(0, solution2.maxProfit(intArrayOf(7, 6, 4, 3, 1)))
        assertEquals(0, solution2.maxProfit(intArrayOf(3, 3, 3, 3)))
        assertEquals(0, solution2.maxProfit(intArrayOf(3)))
        assertEquals(0, solution2.maxProfit(intArrayOf()))
    }

    @Test
    fun maxProfit3() {
        assertEquals(5, solution3.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
        assertEquals(0, solution3.maxProfit(intArrayOf(7, 6, 4, 3, 1)))
        assertEquals(0, solution3.maxProfit(intArrayOf(3, 3, 3, 3)))
        assertEquals(0, solution3.maxProfit(intArrayOf(3)))
        assertEquals(0, solution3.maxProfit(intArrayOf()))
    }
}