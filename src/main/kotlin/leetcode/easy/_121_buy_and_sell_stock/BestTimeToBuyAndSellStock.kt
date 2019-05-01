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
     * Space: O(1)
     *
     * Runtime: 572 ms
     */
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        for (i in prices.indices) {
            for (j in (i + 1)..prices.lastIndex) {
                maxProfit = max(maxProfit, prices[j] - prices[i])
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
     *
     * Runtime: 244 ms
     */
    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) return 0

        /* maxProfits[i] = the max profit for prices[0..i] */
        val maxProfits = IntArray(prices.size)
        maxProfits[0] = 0
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

        for (i in 1..prices.lastIndex) {
            minBuyPrice = min(minBuyPrice, prices[i])
            maxProfit = max(maxProfit, prices[i] - minBuyPrice)
        }
        return maxProfit
    }
}