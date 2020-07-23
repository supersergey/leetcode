package com.company.palindromenumber

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        var value = x
        var sum = 0
        while (value > 0) {
            sum *= 10
            val v = value % 10
            sum += v
            value /= 10
        }
        return sum == x
    }
}

fun main() {
    println(Solution().isPalindrome(2001))
    println(Solution().isPalindrome(101))
    println(Solution().isPalindrome(11))
    println(Solution().isPalindrome(1))
    println(Solution().isPalindrome(0))
    println(Solution().isPalindrome(121))
    println(Solution().isPalindrome(100))
}