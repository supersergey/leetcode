package com.company.maxArea

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxArea(height: IntArray): Int {
        var first = 0
        var last = height.size - 1
        var result = 0
        while (first < last) {
            result = max(result, (last - first) * min(height[first], height[last]))
            if (height[first] < height[last])
                first++
            else
                last--
        }
        return result
    }
}

fun main() {
    println(Solution().maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
    println(Solution().maxArea(intArrayOf()))
    println(Solution().maxArea(intArrayOf(1)))
}