package com.company.maximus_subarray

import kotlin.math.max

class Solution2 {
    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty())
            return 0
        var i = 1
        var sum = nums.first()
        while (i < nums.size) {
            nums[i] = max(nums[i], nums[i] + nums[i - 1])
            sum = max(sum, nums[i])
            i++
        }
        return sum
    }
}

fun main() {
//    println(com.company.rotten_oranges.Solution2().maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
//    println(com.company.rotten_oranges.Solution2().maxSubArray(intArrayOf(-2, 1)))

    var s: Double = 0.0
    for(i in 0..187) {
        s += 0.5
    }
    println(s)
}