package com.company.minpathsum

import kotlin.math.min

class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (i > 0 && j > 0)
                    grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])
                else {
                    if (i != 0)
                        grid[i][j] += grid[i - 1][j]
                    else
                        if (j != 0)
                            grid[i][j] += grid[i][j - 1]
                }
            }
        }
        return grid[grid.size - 1][grid[grid.size - 1].size - 1]
    }
}

fun main() {
    val grid = arrayOf(
        intArrayOf(1, 3, 1),
        intArrayOf(1, 5, 1),
        intArrayOf(4, 2, 1)
    )
    println(Solution().minPathSum(grid))
}

