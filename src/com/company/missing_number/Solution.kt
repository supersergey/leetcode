package com.company.missing_number

class Solution {
    fun missingNumber(nums: IntArray): Int {
        return (nums.size + 1) * nums.size / 2 - nums.sum()
    }
}

fun main() {
    println(Solution().missingNumber(intArrayOf(3,0,1)))
}