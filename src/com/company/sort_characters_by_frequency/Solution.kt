package com.company.sort_characters_by_frequency

class Solution {
    fun frequencySort(s: String): String =
        s.map { it }
            .groupingBy { it }
            .eachCount()
            .toList()
            .sortedBy { (_, v) -> -v }
            .joinToString("") { pair ->
                (0 until pair.second).map { pair.first }.joinToString("")
            }
}

fun main() {
    val s = Solution()
    println(s.frequencySort("tree"))
    println(s.frequencySort("cccaaa"))
    println(s.frequencySort("Aabb"))
}