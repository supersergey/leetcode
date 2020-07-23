package com.company.climb_stairs

import java.time.Duration
import java.time.Instant

class SolutionTailrec {
    fun climbStairs(n: Int): Long = findRec(n, 1, 2)

    private tailrec fun findRec(n: Int, first: Long, second: Long): Long {
        if (n == 1) return first
        if (n == 2) return second

        return findRec(n - 1, second, second + first)
    }
}

fun main() {
    val start = Instant.now()
    repeat(100000) {
        SolutionTailrec().climbStairs(200)
    }
    println(Duration.between(start, Instant.now()).toMillis())
}