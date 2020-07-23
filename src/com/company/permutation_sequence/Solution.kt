package com.company.permutation_sequence

class Solution {
    var count = 0
    var max = 0
    fun getPermutation(n: Int, k: Int): String {
        max = k
        val result = helper(emptyList(), (1..n).map { it })
        return result?.joinToString("") ?: ""
    }

    private fun helper(current: List<Int>, numbers: List<Int>): List<Int>? {
        if (numbers.size == 1) {
            count++
            if (count == max) {
                return current + numbers.first()
            }
            return null
        }
        for (n in numbers) {
            val result = helper(current + n, numbers - n)
            if (result != null)
                return result
        }
        return null
    }
}

fun main() {
    Solution().apply {
        println(getPermutation(3, 1))
    }
    Solution().apply {
        println(getPermutation(3, 3))
    }
    Solution().apply {
        println(getPermutation(4, 9))
    }
}