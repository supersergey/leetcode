package com.company.letter_combinations_of_a_phone_number

import java.lang.Exception

class Solution {

    private val base = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty())
            return emptyList()
        val selected: List<String> = digits.map { it }.map { base[it] ?: throw Exception() }
        val result = mutableListOf<String>()
        next("", selected, result)
        return result
    }

    private fun next(current: String, groups: List<String>, result: MutableList<String>) {
        if (groups.isEmpty()) {
            result.add(current)
            return
        }
        val g = groups.first()
        for (c in g) {
            next(current + c, groups - g, result)
        }
    }
}

fun main() {
    println(Solution().letterCombinations("23"))
}