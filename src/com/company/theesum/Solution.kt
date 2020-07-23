package com.company.theesum

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()
        val sorted = nums.sorted()
        for (i in sorted.indices) {
            var j = i + 1
            var k = sorted.size - 1
            while (j < k) {
                val x = sorted[j] + sorted[k]
                when {
                    x == -sorted[i] -> {
                        result.add(listOf(sorted[i], sorted[j], sorted[k]).sorted())
                        j++
                        k--
                    }
                    x < -sorted[i] -> {
                        j++
                    }
                    else -> k--
                }
            }
        }
        return result.toList()
    }
}

fun main() {
    println(Solution().threeSum(intArrayOf(
        3,0,-2,-1,1,2
    )))
}