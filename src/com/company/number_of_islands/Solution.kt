package com.company.number_of_islands

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty())
            return 0
        var result = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    findIsland(grid, i, j)
                    result++
                }
            }
        }
        return result
    }

    private fun findIsland(grid: Array<CharArray>, i: Int, j: Int) {
        if (i in grid.indices && j in grid[i].indices && grid[i][j] == '1') {
            grid[i][j] = '*'
            findIsland(grid, i + 1, j)
            findIsland(grid, i - 1, j)
            findIsland(grid, i, j + 1)
            findIsland(grid, i, j - 1)
        }
    }
}

fun main() {
    val grid1 = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )

    val grid2 = arrayOf(
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '1', '0', '0'),
        charArrayOf('0', '0', '0', '1', '1')
    )

    println(Solution().numIslands(grid1))
    println(Solution().numIslands(grid2))
}