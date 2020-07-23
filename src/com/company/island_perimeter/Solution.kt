package com.company.island_perimeter

class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var p = 0
        if (grid.isEmpty())
            return p
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    if (i > 0 && grid[i - 1][j] == 1)
                        p -= 2
                    if (j > 0 && grid[i][j - 1] == 1)
                        p -= 2
                    p += 4
                }
            }
        }
        return p
    }
}

fun main() {
    val grid = arrayOf(
        intArrayOf(1)
//        intArrayOf(1, 1, 1, 0),
//        intArrayOf(0, 1, 0, 0),
//        intArrayOf(1, 1, 0, 0)
    )
    println(Solution().islandPerimeter(grid))
}