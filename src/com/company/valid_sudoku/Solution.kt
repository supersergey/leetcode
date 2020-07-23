package com.company.valid_sudoku

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (i in board) {
            if (i.isNotValid())
                return false
        }
        for (i in board.indices) {
            val x = mutableListOf<Char>()
            for(j in board[i].indices) {
                x.add(board[j][i])
            }
            if (x.toCharArray().isNotValid()) {
                return false
            }

        }
        for (i in board.indices step 3) {
            for (j in board.indices step 3) {
                if (charArrayOf(
                        board[i][j], board[i + 1][j], board[i + 2][j],
                        board[i][j + 1], board[i + 1][j + 1], board[i + 2][j + 1],
                        board[i][j + 2], board[i + 1][j + 2], board[i + 2][j + 2]
                    ).isNotValid())
                    return false
            }
        }
        return true
    }

    private fun CharArray.isNotValid(): Boolean =
        this.filter { it != '.' }.let {
            it.toHashSet().size != it.size
        }
}

fun main() {
//    val input1 = arrayOf(
//        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
//        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
//        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
//        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
//        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
//        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
//        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
//        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
//        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
//    )
//    println(Solution().isValidSudoku(input1))
//    val input2 = arrayOf(
//        charArrayOf('8','3','.','.','7','.','.','.','.'),
//        charArrayOf('6','.','.','1','9','5','.','.','.'),
//        charArrayOf('.','9','8','.','.','.','.','6','.'),
//        charArrayOf('8','.','.','.','6','.','.','.','3'),
//        charArrayOf('4','.','.','8','.','3','.','.','1'),
//        charArrayOf('7','.','.','.','2','.','.','.','6'),
//        charArrayOf('.','6','.','.','.','.','2','8','.'),
//        charArrayOf('.','.','.','4','1','9','.','.','5'),
//        charArrayOf('.','.','.','.','8','.','.','7','9')
//    )
//    println(Solution().isValidSudoku(input2))
    val input3 = arrayOf(
            charArrayOf('.','.','4',    '5','.','.',    '6','3','.'),
            charArrayOf('.','.','.',    '.','.','.',    '.','.','.'),
            charArrayOf('5','.','.',    '.','.','.',    '.','9','.'),

            charArrayOf('.','.','.',    '.','6','.',    '.','.','.'),
            charArrayOf('4','.','3',    '.','.','.',    '.','.','1'),
            charArrayOf('.','.','.',    '7','.','.',    '.','.','.'),

            charArrayOf('.','.','.',    '5','.','.',    '.','.','.'),
            charArrayOf('.','.','.',    '.','.','.',    '.','.','.'),
            charArrayOf('.','.','.',    '.','.','.',    '.','.','.')
    )
    println(Solution().isValidSudoku(input3))
}