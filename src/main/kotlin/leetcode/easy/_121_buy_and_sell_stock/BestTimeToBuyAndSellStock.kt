package leetcode.easy._121_buy_and_sell_stock

import kotlin.math.max
import kotlin.math.min

/**
 * 121 - https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 */
class Solution {
    /**
     * Brute-force solution (Accepted)
     * Time: O(n^2)
     * Space: O(n)
     */
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        (0 until prices.lastIndex).forEach { i ->
            ((i + 1)..prices.lastIndex).forEach { j ->
                val profit = prices[j] - prices[i]
                maxProfit = max(maxProfit, profit)
            }
        }
        return maxProfit
    }
}

class SolutionTwo {
    /**
     * Dynamic Programming solution
     * Time: O(n)
     * Space: O(n)
     */
    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) return 0

        /* maxProfits[i] = the max profit for prices[0..i] */
        var maxProfits = IntArray(prices.size)
        maxProfits[0] = 0
        maxProfits[1] = max(prices[1] - prices[0], maxProfits[0])
        var minBuyPrice = prices[0]

        for (i in 1..prices.lastIndex) {
            minBuyPrice = min(minBuyPrice, prices[i])
            maxProfits[i] = max(maxProfits[i - 1], prices[i] - minBuyPrice)
        }
        return maxProfits.last()
    }
}

class SolutionThree {
    /**
     * Dynamic Programming solution, optimize space
     * Time: O(n)
     * Space: O(1)
     */
    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) return 0

        var maxProfit = 0
        var minBuyPrice = prices[0]

        (1..prices.lastIndex).forEach { i ->
            minBuyPrice = min(minBuyPrice, prices[i])
            maxProfit = max(maxProfit, prices[i] - minBuyPrice)
        }
        return maxProfit
    }
}