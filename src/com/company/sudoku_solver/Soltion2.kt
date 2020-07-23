package com.company.sudoku_solver

class Solution2 {
    fun solveSudoku(board: Array<CharArray>) {
        solve(0, board)
        board.forEach { println(it.joinToString(" ")) }
    }

    fun solve(ind: Int, board: Array<CharArray>): Boolean {
        if (ind == 81) return true
        val i = ind / 9
        val j = ind % 9
        return if (board[i][j] != '.')
            solve(ind + 1, board)
        else {
            var f = '1'
            while (f <= '9') {
                if (isValidFill(board, i, j, f)) {
                    board[i][j] = f
                    if (solve(ind + 1, board)) return true
                    board[i][j] = '.'
                }
                f++
            }
            false
        }
    }

    fun isValidFill(board: Array<CharArray>, i: Int, j: Int, fill: Char): Boolean {
        for (k in 0..8) {
            val r = i / 3 * 3 + j / 3 //select the block
            if (board[i][k] == fill || board[k][j] == fill || board[r / 3 * 3 + k / 3][r % 3 * 3 + k % 3] == fill) return false
            //check row, column, block
        }
        return true
    }
}