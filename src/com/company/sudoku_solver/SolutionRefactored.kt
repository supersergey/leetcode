package com.company.sudoku_solver

import java.time.Instant

class SolutionRefactored {
    fun solveSudoku(board: Array<CharArray>) {
        if (board.isEmpty())
            return
        solve(board, 0)
    }

    private fun solve(board: Array<CharArray>, ind: Int): Boolean {
        if (ind == 81)
            return true
        val x = ind % 9
        val y = ind / 9
        if (board[y][x] == '.') {
            val candidates = ('1'..'9').filter { it.isAllowed(board, y, x) }
            for (c in candidates) {
                board[y][x] = c
                if (solve(board, ind + 1))
                    return true
                else board[y][x] = '.'
            }
        } else {
            return solve(board, ind + 1)
        }
        return false
    }

    private fun Char.isAllowed(board: Array<CharArray>, y: Int, x: Int): Boolean {
        for (j in (y / 3) * 3 until ((y / 3) + 1) * 3) {
            for (i in (x / 3) * 3 until ((x / 3) + 1) * 3) {
                if (board[j][i] == this)
                    return false
            }
        }
        return board[y].none { it == this } && board.indices.map { board[it][x] }.none { it == this }
    }
}

fun main() {
    val now = Instant.now()
    repeat(1000) {
        SolutionRefactored().solveSudoku(
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
    println((Instant.now().toEpochMilli() - now.toEpochMilli()))
}