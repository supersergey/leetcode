package com.company.longest_common_prefix

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var word = strs.minBy { it.length } ?: ""
        var i = 0
        while (word.isNotEmpty() && i in strs.indices) {
            word = findCommon(word, strs[i])
            i++
        }
        return word
    }

    private fun findCommon(key: String, sample: String): String {
        var i = 0
        while (i in key.indices) {
            if(key[i] == sample[i])
                i++
            else
                break
        }
        return key.substring(0, i)
    }
}

fun main() {
    println(Solution().longestCommonPrefix(arrayOf("flower","flow","flight")))
    println(Solution().longestCommonPrefix(arrayOf("dog","racecar","car")))
    println(Solution().longestCommonPrefix(arrayOf("")))
    println(Solution().longestCommonPrefix(arrayOf("c", "c", "c")))

}