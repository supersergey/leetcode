package com.company.zigzag

class Solution {
    fun convert(s: String, numRows: Int): String {
        val strings: List<MutableList<Char>> = IntRange(0, numRows - 1).map { mutableListOf<Char>() }
        var selector = 0
        var increment = 1
        for (c in s) {
            strings[selector].add(c)
            if (strings.size > 1)
                selector += increment
            if (selector == numRows - 1)
                increment = -1
            if (selector == 0)
                increment = 1
        }
        return strings.joinToString(separator = "") { it.joinToString(separator = "") }
    }
}

fun main() {
    println(Solution().convert("PAYPALISHIRING", 3))
    println(Solution().convert("AB", 1))
}