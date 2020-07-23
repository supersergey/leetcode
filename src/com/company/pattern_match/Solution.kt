package com.company.pattern_match

class Solution {
    fun isMatch(s: String, p: String): Boolean {
        if (p.isEmpty())
            return s.isEmpty()
        if (p.isNotStar()) {
            if (s.isNotEmpty() && (s.first() == p.first() || p.first() == '.'))
                return isMatch(s.substring(1), p.substring(1))
        }
        if (p.isStar()) {
            if (isMatch(s, p.substring(2)))
                return true
            if (s.isNotEmpty() && (s.first() == p.first() || p.first() == '.'))
                return isMatch(s.substring(1), p)
        }
        return false
    }

    fun String.isStar() = this.length >= 2 && this[1] == '*'

    fun String.isNotStar() = this.length < 2 || this[1] != '*'
}

fun main() {
    assert(!Solution().isMatch("mississippi", "mis*is*p*.")).also { println(1) }
    assert(Solution().isMatch("abcd", ".*d")).also { println(1) }
    assert(Solution().isMatch("aa", "aa")).also { println(1) }
    assert(!Solution().isMatch("ab", "ac")).also { println(2) }
    assert(!Solution().isMatch("abc", "ac")).also { println(3) }
    assert(!Solution().isMatch("abc", "..")).also { println(4) }
    assert(Solution().isMatch("ac", "..")).also { println(5) }
    assert(Solution().isMatch("ac", ".c")).also { println(6) }

    assert(Solution().isMatch("abc", "a.c")).also { println(2) }
    assert(!Solution().isMatch("aa", "a")).also { println(3) }
    assert(Solution().isMatch("abc", "...")).also { println(4) }
    assert(!Solution().isMatch("ac", "...")).also { println(5) }
    assert(!Solution().isMatch("abc", "..")).also { println(6) }

    assert(Solution().isMatch("ab", ".*..")).also { println(-2) }
    assert(Solution().isMatch("a", "ab*")).also { println(-1) }
    assert(!Solution().isMatch("ab", "*.c")).also { println(1) }
    assert(!Solution().isMatch("ab", ".*c")).also { println(2) }
    assert(Solution().isMatch("aa", "a*")).also { println(3) }

    assert(Solution().isMatch("abbb", "ab*")).also { println(6) }
    assert(Solution().isMatch("acd", "ab*c.")).also { println(7) }
    assert(Solution().isMatch("abaa", "a.*a*")).also { println(8) }
    assert(!Solution().isMatch("aa", "a")).also { println(9) }
    assert(Solution().isMatch("acd", "ab*c.")).also { println(10) }
    assert(Solution().isMatch("aab", "c*a*b")).also { println(11) }
    assert(!Solution().isMatch("aba", "a*a")).also { println(12) }
}