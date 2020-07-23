package com.company.top_k_frequent_words

class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> =
        words
            .groupingBy { it }
            .eachCount()
            .toList()
            .sortedWith(compareBy<Pair<String, Int>> { -it.second }.thenBy { it.first })
            .map { it.first }
            .take(k)
}

fun main() {
    val s = Solution()
    println(s.topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), 2))
    println(s.topKFrequent(arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"), 4))
    println(s.topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), 3))
}