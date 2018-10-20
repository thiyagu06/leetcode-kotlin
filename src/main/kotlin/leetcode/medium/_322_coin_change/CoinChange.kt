package leetcode.medium._322_coin_change

import kotlin.math.min

/**
 * 322 - https://leetcode.com/problems/coin-change
 */
class Solution {
    /**
     * Dynamic Programming (Bottom-up)
     * Time: O(S * n) - where S is the amount, n is the number of coin denominations
     * Space: O(S)
     */
    fun coinChange(coins: IntArray, amount: Int): Int {
        /*
        dp size = amount + 1: will store results for amounts 0..amount
        dp values = set each to amount + 1. If we use Int.MAX_VALUE, it can cause overflow since we add 1 to some
                    dp values when taking the min(). Setting it to amount + 1 instead will work, since the highest
                    possible amount of coins for any n is n (all 1s).
         */
        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0

        for (i in 1..amount) {
            for (coin in coins) {
                if (coin <= i) {
                    dp[i] = min(dp[i], 1 + dp[i - coin])
                }
            }
        }

        return if (dp[amount] > amount) -1 else dp[amount]
    }
}