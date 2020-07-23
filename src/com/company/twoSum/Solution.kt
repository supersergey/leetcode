package com.company.twoSum

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in 0..nums.size) {
            for (j in i + 1..nums.size) {
                if (j < nums.size) {
                    if (nums[i] + nums[j] == target) {
                        return intArrayOf(i, j)
                    }
                }
            }
        }
        return IntArray(0)
    }
}

fun main() {
    val arr = intArrayOf(3, 2, 4)
    println(Solution().twoSum(arr, 6).toList())
}