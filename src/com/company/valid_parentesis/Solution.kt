package com.company.valid_parentesis

import java.util.LinkedList

class Solution {
    private val openBrackets = setOf('(', '{', '[')
    fun isValid(s: String): Boolean {
        if (s.isEmpty())
            return true
        if (s.length % 2 != 0)
            return false
        val stack = LinkedList<Char>()
        for (c in s) {
            if (c in openBrackets) {
                stack.push(c)
            } else {
                val x = stack.peek()
                if (isMatchingBrackets(open = x, close = c))
                    stack.pop()
            }
        }
        return stack.isEmpty()
    }

    private fun isMatchingBrackets(open: Char?, close: Char): Boolean =
        (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}')
}

fun main() {
//    println(Solution().isValid("")) // true
    println(Solution().isValid("(){}[]")) // true
    println(Solution().isValid("[[][]({})]")) // true
    println(Solution().isValid("[[][]({)}]")) // false
}