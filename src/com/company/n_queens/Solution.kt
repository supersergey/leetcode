package com.company.n_queens

class Solution {
    private val result = mutableListOf<List<String>>()
    var size = 0

    fun solveNQueens(n: Int): List<List<String>> {
        size = n
        solve(0, LinkedHashSet(), mutableSetOf(), mutableSetOf(), n)
        return result.toList()
    }

    private fun solve(column: Int, rows: LinkedHashSet<Int>, diag1: MutableSet<Int>, diag2: MutableSet<Int>, n: Int):
        Boolean {
        if (n == 0) {
            result.add(rows.map { it.toStringRow(size) })
            return true
        }
        for (i in column until size) {
            for (j in 0 until size) {
                if (rows.contains(j) || diag1.contains(i + j) || diag2.contains(i - j))
                    continue
                val newRows = LinkedHashSet<Int>().apply {
                    addAll(rows)
                    add(j)
                }
                val newDiag1 = diag1.toMutableSet().apply {
                    add(i + j)
                }
                val newDiag2 = diag2.toMutableSet().apply {
                    add(i - j)
                }
                solve(i + 1, newRows, newDiag1, newDiag2, n - 1)
            }
        }
        return false
    }

    private fun Int.toStringRow(n: Int): String {
        val result = arrayOfNulls<Char>(n)
        for (i in 0 until n)
            if (i != this)
                result[i] = '.'
            else result[i] = 'Q'
        return result.joinToString("")
    }
}

fun init(n: Int): Array<CharArray> {
    val result = mutableListOf<CharArray>()
    for (i in 0 until n) {
        result.add(IntRange(0, n - 1).map { '.' }.toCharArray())
    }
    return result.toTypedArray()
}

fun Array<CharArray>.print() {
    for (line in this) {
        println(line.joinToString(" "))
    }
}

fun main() {
    Solution().solveNQueens(8).flatten().forEach { println(it) }
//    val source = init(4)
//    println(Solution().tryPutAQueen(source, 1, 0))
//    println(Solution().tryPutAQueen(source, 3, 1))
//    println(Solution().tryPutAQueen(source, 0, 2))
//    println(Solution().tryPutAQueen(source, 2, 3))
//    source.print()
//
//    val source2 = init(4)
//    println(Solution().tryPutAQueen(source2, 2, 0))
//    println(Solution().tryPutAQueen(source2, 0, 1))
//    println(Solution().tryPutAQueen(source2, 3, 2))
//    println(Solution().tryPutAQueen(source2, 1, 3))
//    source2.print()
}