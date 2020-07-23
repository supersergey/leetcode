package com.company.largest_rectangle_in_the_histogram

import kotlin.math.max

class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        if (heights.isEmpty())
            return 0
        var maxHeight = Int.MIN_VALUE
        for(i in heights.indices) {
            val currentHeight = heights[i]
            var l = i
            var h = i
            while (l > 0) {
                if (heights[l - 1] < currentHeight) {
                    break
                }
                l--
            }
            while (h < heights.lastIndex) {
                if (heights[h + 1] < currentHeight) {
                    break
                }
                h++
            }
            maxHeight = max(maxHeight, currentHeight * (h - l + 1))
        }
        return maxHeight
    }
}

fun main() {
    println(
        Solution().largestRectangleArea(intArrayOf(2,1,5,6,2,3))
    )
}