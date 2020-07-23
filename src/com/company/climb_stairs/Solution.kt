package com.company.climb_stairs

class Solution {
    fun climbStairs(n: Int): Int {
        if (n==1) return 1
        if (n==2) return 2

        var result = 0
        var first = 1
        var second = 2

        repeat(n-2) {
            result = first + second
            first = second
            second = result
        }
        return result
    }
}

fun main() {
    println(SolutionTailrec().climbStairs(3))
    println(SolutionTailrec().climbStairs(4))
}