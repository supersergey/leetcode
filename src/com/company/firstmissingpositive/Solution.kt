package com.company.firstmissingpositive

class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val hset = nums.toHashSet()
        for (i in 1..nums.size + 1)  //iterate from 1 to find first missing element
            if (!hset.contains(i)) return i
        return 1
    }
}

fun main() {
    println(Solution().firstMissingPositive(intArrayOf(1, 2))) // 3
    println(Solution().firstMissingPositive(intArrayOf(1, 2, 0))) // 3
    println(Solution().firstMissingPositive(intArrayOf(3, 4, -1, 1))) // 2
    println(Solution().firstMissingPositive(intArrayOf(7, 8, 9, 11, 12))) // 1
    println(Solution().firstMissingPositive(intArrayOf(2, 1))) // 3
    println(Solution().firstMissingPositive(intArrayOf(1, 1000))) // 2
    println(Solution().firstMissingPositive(intArrayOf(2147483647, 1, 2, 3, 10, 9))) // 2
}