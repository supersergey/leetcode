package com.company.combination_sum

class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        if (candidates.isEmpty())
            return emptyList()
        val result = mutableSetOf<List<Int>>()
        findNext(emptyList(), candidates.sortedArray(), target, result)
        return result.toList()
    }

    private fun findNext(current: List<Int>, candidates: IntArray, target: Int, result: MutableSet<List<Int>>) {
        if (target == 0) {
            result.add(current.sorted())
        }
        for (c in candidates) {
            if (c <= target) {
                findNext(current + c, candidates, target - c, result)
            }
        }
    }
}

fun main() {
    println(Solution().combinationSum(intArrayOf(2, 3, 6, 7), 7))
}