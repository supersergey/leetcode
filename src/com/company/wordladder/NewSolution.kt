package com.company.wordladder

import java.util.LinkedList

class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val dict = preProcess(wordList)
        val visited = mutableSetOf(beginWord)
        val wordsToVariations = (wordList + beginWord).wordToVariations()
        val queue = LinkedList<Word>().apply {
            this.add(Word(beginWord, 1))
        }
        while (queue.isNotEmpty()) {
            val currentWord = queue.remove()
            wordsToVariations[currentWord.word]?.forEach {
                val realWords = dict[it]
                realWords?.forEach { realWord ->
                    if (realWord !in visited) {
                        if (realWord == endWord) {
                            return currentWord.level + 1
                        }
                        visited.add(realWord)
                        queue.add(Word(realWord, currentWord.level + 1))
                    }
                }
            }
        }
        return 0
    }
}

fun preProcess(words: List<String>): Map<String, List<String>> {
    val result = mutableMapOf<String, MutableList<String>>()
    words.map { word ->
        word.variations().forEach {
            result.computeIfAbsent(it) { mutableListOf() }.apply { add(word) }
        }
    }
    return result
}

fun List<String>.wordToVariations(): Map<String, List<String>> =
    this.map { it to it.variations() }.toMap()

fun String.variations(): List<String> {
    val result = mutableListOf<String>()
    val s = this.toCharArray()
    for (i in s.indices) {
        val old = s[i]
        s[i] = '*'
        result.add(String(s))
        s[i] = old
    }
    return result
}


class Word(val word: String, val level: Int)

fun main() {
    val wordList = listOf("hot","dot","dog","lot","log","cog")
    val beginWord = "hit"
    val endWord = "cog"
    println(preProcess(wordList))
    println(Solution().ladderLength(beginWord, endWord, wordList))
}