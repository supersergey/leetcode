package com.company.unique_paths

class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        if (m * n == 0)
            return 1
        val arr: Array<IntArray> = Array(m) {
            IntArray(n) { 0 }
        }
        arr[0][0] = 1
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i > 0 && j > 0)
                    arr[i][j] += (arr[i - 1][j] + arr[i][j - 1])
                if (i > 0 && j == 0)
                    arr[i][j] += arr[i - 1][j]
                if (i == 0 && j > 0)
                    arr[i][j] += arr[i][j - 1]
            }
        }
        return arr[m - 1][n - 1]
    }
}

fun Array<IntArray>.print() {
    println("____________________")
    this.forEach { println(it.joinToString(" ")) }
    println("____________________")
}

fun main() {
    println(Solution().uniquePaths(5, 0))
}