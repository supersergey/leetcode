package com.company.decode_string

import java.util.LinkedList

class Solution {
    fun decodeString(s: String): String {
        val numbers = LinkedList<Int>()
        val entries = LinkedList<StringBuilder>()
        val current = StringBuilder()
        val result = StringBuilder()
        var i = 0
        while (i <= s.lastIndex) {
            when (s[i]) {
                in ('0'..'9') -> {
                    val numStr = StringBuilder()
                    while (s[i] in ('0'..'9')) {
                        numStr.append(s[i])
                        i++
                    }
                    numbers.push(Integer.parseInt(numStr.toString()))
                }
                '[' -> {
                    entries.push(StringBuilder(current))
                    current.clear()
                    i++
                }
                ']' -> {
                    val n = numbers.pop()
                    val entry = entries.pop()
                    repeat(n) {
                        entry.append(current)
                    }
                    current.clear()
                    current.append(entry)
                    i++
                }
                else -> {
                    current.append(s[i])
                    i++
                }
            }
        }
        result.append(current)
        return result.toString()
    }
}

fun main() {
    println(Solution().decodeString("100[abcd]"))
    println(Solution().decodeString("abcd"))
    println(Solution().decodeString("3[a]2[bc]"))
    println(Solution().decodeString("3[a2[c]]"))
    println(Solution().decodeString("2[abc]3[cd]ef"))
}