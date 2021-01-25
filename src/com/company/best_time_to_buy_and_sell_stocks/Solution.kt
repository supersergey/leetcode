package com.company.best_time_to_buy_and_sell_stocks

import java.lang.Integer.max
import java.lang.Integer.min
import kotlin.test.assertEquals

class Solution {

    fun maxProfit(prices: IntArray): Int {
        var min = prices.first()
        var profit = 0
        for (n in prices) {
            if (min > n) {
                min = n
            } else {
                profit = max(profit, n - min)
            }
        }
        return profit
    }
}

fun main() {
    Solution().apply {
        assertEquals(3, maxProfit(intArrayOf(2, 1, 4)))
        assertEquals(1, maxProfit(intArrayOf(1, 2)))
        assertEquals(5, maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
        assertEquals(0, maxProfit(intArrayOf(7, 6, 4, 3, 1)))
        assertEquals(2, maxProfit(intArrayOf(2, 4, 1)))
    }
}