package leetcode.easy._122_buy_and_sell_stock_ii

import java.util.*
import kotlin.math.max

/**
 * 122 - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
 */
class Solution {
    /**
     * Brute-force (Time-Limit Exceeded)
     *
     * Time: O(n^n)
     * Space: O(n)
     */
    fun maxProfit(prices: IntArray, startIndex: Int = 0): Int {
        if (startIndex > prices.lastIndex) return 0

        var max = 0     // max for prices[startIndex:]
        for (buyIndex in startIndex..prices.lastIndex) {
            var maxProfit = 0
            for (sellIndex in buyIndex + 1..prices.lastIndex) {
                if (prices[buyIndex] < prices[sellIndex]) {
                    val profit = (prices[sellIndex] - prices[buyIndex]) + maxProfit(prices, sellIndex + 1)
                    maxProfit = max(maxProfit, profit)
                }
            }
            max = max(max, maxProfit)
        }

        return max
    }
}

class SolutionTwo {
    /**
     * Peak-Valley Approach (http://tinyurl.com/yberbbju)
     * Time: O(n)
     * Space: O(n)
     */
    fun maxProfit(prices: IntArray): Int {
        val (peaks, valleys) = peakAndValleyIndices(prices)
        val firstValleyIndex = valleys.first()
        val peaksAfterFirstValley = peaks.dropWhile { it < firstValleyIndex }
        return (peaksAfterFirstValley zip valleys).sumBy { (peak, valley) ->
            prices[peak] - prices[valley]
        }
    }

    internal fun peakAndValleyIndices(prices: IntArray): Pair<List<Int>, List<Int>> {
        if (prices.size < 2) return Pair(emptyList(), emptyList())
        val peaks = LinkedList<Int>()
        val valleys = LinkedList<Int>()

        peaks.add(if (prices[0] > prices[1]) 0 else 1)
        valleys.add(if (prices[0] < prices[1]) 0 else 1)

        (2..prices.lastIndex).forEach { i ->
            if (prices[i] < prices[i - 1]) {
                if (valleys.last == i - 1) {
                    valleys.removeLast()
                }
                valleys += i
            } else if (prices[i] > prices[i - 1]) {
                if (peaks.last == i - 1) {
                    peaks.removeLast()
                }
                peaks += i
            }
        }

        return (peaks to valleys)
    }
}

class SolutionThree {
    /**
     * Approach 3 (http://tinyurl.com/yberbbju)
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun maxProfit(prices: IntArray): Int = prices.foldIndexed(0) { i, profit, _ ->
        if (i > 0 && prices[i] > prices[i - 1])
            profit + (prices[i] - prices[i - 1])
        else profit
    }
}