package com.company.rotten_oranges

class Solution {
    val ROTTEN = 2
    val FRESHROTTEN = 3
    val FRESH = 1

    fun orangesRotting(grid: Array<IntArray>): Int {
        var result = 0
        val initialFresh = grid.countFresh()
        if (initialFresh == 0)
            return 0
        var newlyRotten = 0
        do {
            var changed = false
            for (i in grid.indices) {
                for (j in grid[i].indices) {
                    if (grid[i][j] == ROTTEN) {
                        val changedCount = grid.rotNeighbours(i, j)
                        if (changedCount > 0) {
                            changed = true
                            newlyRotten += changedCount
                        }
                    }
                }
            }
            if (changed)
                result++
            else return -1
            grid.freshRottenToRotten()
        } while (changed && newlyRotten != initialFresh)
        return result
    }

    private fun Array<IntArray>.rotNeighbours(i: Int, j: Int): Int {
        var rotten = 0
        rotten += tryRotSingle(i - 1, j)
        rotten += tryRotSingle(i + 1, j)
        rotten += tryRotSingle(i, j - 1)
        rotten += tryRotSingle(i, j + 1)
        return rotten
    }

    private fun Array<IntArray>.tryRotSingle(i: Int, j: Int): Int {
        if (i in this.indices && j in this[i].indices && this[i][j] == FRESH) {
            this[i][j] = FRESHROTTEN
            return 1
        }
        return 0
    }

    private fun Array<IntArray>.freshRottenToRotten() {
        for (i in this.indices) {
            for (j in this[i].indices) {
                if (this[i][j] == FRESHROTTEN)
                    this[i][j] = ROTTEN
            }
        }
    }

    private fun Array<IntArray>.countFresh(): Int =
        this.flatMap { it.asIterable() }.count { it == FRESH }
}

fun main() {
    val input1 = arrayOf(intArrayOf(2, 1, 1), intArrayOf(1, 1, 0), intArrayOf(0, 1, 1))
    val input2 = arrayOf(intArrayOf(2, 1, 1), intArrayOf(0, 1, 1), intArrayOf(1, 0, 1))
    val input3 = arrayOf(intArrayOf(0, 2))
    val input4 = arrayOf(intArrayOf(1), intArrayOf(2))
    println(Solution().orangesRotting(input4))
}