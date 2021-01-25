package com.company.rotten_oranges

class Solution2 {

    fun orangesRotting(grid: Array<IntArray>): Int {
        var iterations = 0
        while (true) {
            var changed = false
            for(i in grid.indices) {
                for(j in grid[i].indices) {
                    if(grid[i][j] == 2) {
                        changed = grid.rotAround(i, j) || changed
                    }
                }
            }
            for(i in grid.indices) {
                for(j in grid[i].indices) {
                    if(grid[i][j] == 3)
                        grid[i][j] = 2
                }
            }
            if (!changed) {
                break
            }
            else {
                iterations++
            }
        }
        return if (grid.flatMap {it.asList() }.any { it == 1 })
            -1
        else
            iterations
    }

    private fun Array<IntArray>.rotAround(i: Int, j: Int): Boolean {
        val b1 = rotSingle(i-1, j)
        val b2 = rotSingle(i+1, j)
        val b3 = rotSingle(i, j-1)
        val b4 = rotSingle(i, j+1)
        return b1 || b2 || b3 || b4
    }

    private fun Array<IntArray>.rotSingle(i: Int, j: Int): Boolean {
        if(i in this.indices && j in this[i].indices && this[i][j] == 1) {
            this[i][j] = 3
            return true
        } else {
            return false
        }
    }
}

fun main() {
    val a1 = arrayOf(
        intArrayOf(2, 1, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 1, 1)
    )

    val a2 = arrayOf(
        intArrayOf(2,1,1),
        intArrayOf(0,1,1),
        intArrayOf(1,0,1)
    )

    val a3 = arrayOf(
        intArrayOf(0,2)
    )

    val a4 = arrayOf(
        intArrayOf(1,2,1,1,2,1,1)
    )

    Solution2().apply {
//        println(orangesRotting(a1))
//        println(orangesRotting(a2))
//        println(orangesRotting(a3))
        println(orangesRotting(a4))
    }
}