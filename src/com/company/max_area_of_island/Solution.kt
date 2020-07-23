package com.company.max_area_of_island

import kotlin.math.max

class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        if (grid.isEmpty())
            return 0
        val visited = Array(grid.size) {
            BooleanArray(grid[0].size) { false }
        }
        var result = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    result = max(result, findCells(grid, i, j, visited, 1))
                }
            }
        }
        return result
    }

    private fun findCells(
        grid: Array<IntArray>,
        i: Int,
        j: Int,
        visited: Array<BooleanArray>,
        square: Int): Int {
        return if (i in grid.indices && j in grid[i].indices && grid[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true
            square + findCells(grid, i - 1, j, visited, square) +
                findCells(grid, i + 1, j, visited, square) +
                findCells(grid, i, j + 1, visited, square) +
                findCells(grid, i, j - 1, visited, square)
        } else 0
    }
}

fun Array<IntArray>.print() {
    this.forEach { println(it.joinToString(" ")) }
}

fun main() {
    val grid = arrayOf(
        intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
    )

    val grid2 = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 1)
    )

    println(Solution().maxAreaOfIsland(grid))
    println(Solution().maxAreaOfIsland(grid2))
}