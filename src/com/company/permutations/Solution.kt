package com.company.permutations

class Solution {
    private val result = mutableListOf<List<Int>>()
    fun permute(nums: IntArray): List<List<Int>> {
        next(intArrayOf(), nums)
        return result
    }

    fun next(current: IntArray, remaining: IntArray) {
        if (remaining.isEmpty())
            result.add(current.toList())
        for (i in remaining.indices) {
            next(current + remaining[i], remaining.sliceArray((remaining.indices) - i))
        }
    }
}

fun main() {
    println(Solution().permute(intArrayOf(1, 2, 3)))
    println(Solution().permute(intArrayOf(1)))
    println(Solution().permute(intArrayOf()))
}