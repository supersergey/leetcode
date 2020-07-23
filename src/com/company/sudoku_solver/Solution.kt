package com.company.sudoku_solver

class Solution {
    var count = 0
    fun solveSudoku(board: Array<CharArray>) {
        val verticals = board.verticals()
        val horizontals = board.horizontals()
        val blocks = board.blocks()
        println(verticals)
        println("-----------------------")
        println(horizontals)
        println("-----------------------")
        println(blocks)

        solve(board, horizontals, verticals, blocks)
        println("-----------------------")

        board.map {
            println(it.joinToString(" "))
        }
    }

    private fun solve(
        board: Array<CharArray>,
        horizontals: List<MutableSet<Char>>,
        verticals: List<MutableSet<Char>>,
        blocks: List<MutableSet<Char>>): Boolean
    {
        if (++count % 1000000 == 0) {
            board.map {
                println(it.joinToString())
            }
            println("----------------")
            count = 0
        }

        var allFilled = true
        for(y in board.indices) {
            for(x in board[y].indices) {
                if (board[y][x] == '.')
                {
                    allFilled = false
                    break
                }
            }
        }
        if (allFilled)
            return true
        for (y in board.indices) {
            for (x in board[y].indices) {
                if (board[y][x] == '.') {
                    val candidates = ('1'..'9')
                        .filter { !horizontals[y].contains(it) }
                        .filter { !verticals[x].contains(it)  }
                        .filter { !blocks[blockOfYX(y, x)].contains(it) }
                    for (c in candidates) {
                        board[y][x] = c
                        verticals[x].add(c)
                        horizontals[y].add(c)
                        blocks[blockOfYX(y, x)].add(c)
                        if (solve(board, horizontals, verticals, blocks))
                            return true
                        else {
                            board[y][x] = '.'
                            verticals[x].remove(c)
                            horizontals[y].remove(c)
                            blocks[blockOfYX(y, x)].remove(c)
                        }
                    }
                }
            }
        }
        return false
    }

    private fun Array<CharArray>.horizontals(): List<MutableSet<Char>> =
        map { it.toMutableSet() }

    private fun Array<CharArray>.verticals(): List<MutableSet<Char>> {
        val result = this[0].indices.map { mutableSetOf<Char>() }
        for (x in this[0].indices)
            for (y in this.indices)
                result[x].add(this[y][x])
        return result
    }

    private fun Array<CharArray>.blocks(): List<MutableSet<Char>> {
        val result = this.indices.map { mutableSetOf<Char>() }
        for (y in this.indices) {
            for (x in this[y].indices) {
                val n = blockOfYX(y, x)
                result[n].add(this[y][x])
            }
        }
        return result
    }

    private fun blockOfYX(y: Int, x: Int) = (y / 3) * 3 + x / 3

}

fun main() {
    Solution().solveSudoku(
        arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
    )

}