package com.company.two_sum

fun main() {
    val numbers = intArrayOf(2, 4, -3, 5, 7, 8, 9, 1)
    println(Solution().findTwoSum(numbers, 9))
}

class Solution {

    fun findTwoSum(numbers: IntArray, sum: Int): Set<Pair<Int, Int>> {
        val diff = mutableSetOf<Int>()
        val result = mutableSetOf<Pair<Int, Int>>()
        for (n in numbers) {
            if (sum - n !in diff) {
                diff.add(n)
            } else {
                result.add(Pair(n, sum - n))
            }
        }
        return result
    }
}

/* 3 5 2 8
> 3
> 5 3
>

 */
