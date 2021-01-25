package com.company.word_break

import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Solution {

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        return findNext(s, wordDict.toSet(), mutableMapOf())
    }

    private fun findNext(
        source: String,
        wordDict: Set<String>,
        memo: MutableMap<String, Boolean>
    ): Boolean {
        if (source.isEmpty()) {
            return true
        }
        if (memo[source] != null)
            return memo[source]!!
        for (w in wordDict) {
            if (source.startsWith(w)) {
                if (findNext(source.substring(w.length), wordDict, memo)) {
                    memo[source] = true
                    return true
                    }
            }
        }
        memo[source] = false
        return false
    }
}

fun main() {
    val s = Solution()
    assertTrue(s.wordBreak("leetcode", listOf("leet", "code")))
    assertTrue(s.wordBreak("applepenapple", listOf("apple", "pen")))
    assertFalse(s.wordBreak("catsandog", listOf("cats", "dog", "sand", "and", "cat")))
    assertTrue(s.wordBreak("cat", listOf("cat")))
    assertFalse(s.wordBreak("cat", emptyList()))
    assertFalse(s.wordBreak("catsanddogs", listOf("dog", "cats", "and")))
    assertTrue(s.wordBreak("catsanddogs", listOf("dog", "cats", "and", "s")))
    assertTrue(s.wordBreak("", listOf("dog", "cats", "and", "s")))
    assertFalse(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
        listOf("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")))
}