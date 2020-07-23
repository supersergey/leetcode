package com.company.plus_one

class Solution {
    fun plusOne(digits: IntArray): IntArray {
        if (digits.isEmpty()) return intArrayOf()
        if (digits[0] == 0) return intArrayOf(1)
        val result = mutableListOf<Int>()

        var add = 1
        for (d in digits.reversed()) {
            add = if (d + add < 10) {
                result.add(d + add)
                0
            } else {
                result.add((d + add) % 10)
                1
            }
        }
        if (add == 1) {
            result.add(1)
        }
        return result.reversed().toIntArray()
    }
}

fun main() {
    println(Solution().plusOne(intArrayOf(1, 2, 3)).toList())
    println(Solution().plusOne(intArrayOf(-1, 0, 0)).toList())
    println(Solution().plusOne(intArrayOf(-9, -9, -9)).toList())
    println(Solution().plusOne(intArrayOf(-1)).toList())
    println(Solution().plusOne(intArrayOf(9)).toList())
    println(Solution().plusOne(intArrayOf(0)).toList())
    println(Solution().plusOne(intArrayOf(9, 9, 9)).toList())
    println(Solution().plusOne(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)).toList())
}