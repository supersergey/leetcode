package com.company.string_compression

class Solution {
    fun compress(chars: CharArray): Int {
        var readPointer = 0
        var writePointer = 0
        while (readPointer < chars.size) {
            var i = 1
            while ((readPointer + i) < chars.size && chars[readPointer] == chars[readPointer + i]) {
                i++
            }
            if (i > 1) {
                val quantity = i.toString().toCharArray()
                chars[writePointer] = chars[readPointer]
                writePointer++
                quantity.copyInto(chars, writePointer)
                writePointer += quantity.size
            } else {
                chars[writePointer] = chars[readPointer]
                writePointer++
            }
            readPointer += i
        }
        return writePointer
    }
}

fun main() {
    println(Solution().compress("aaabcbbbedd".toCharArray()))
    println(Solution().compress("aa".toCharArray()))
    println(Solution().compress("".toCharArray()))
    println(Solution().compress("abbbbbbbbbbb".toCharArray()))
}