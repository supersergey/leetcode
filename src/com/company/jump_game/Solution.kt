package com.company.jump_game

class Solution {
    fun canJump(nums: IntArray): Boolean {
        if (nums.isEmpty()) return false
        if (nums.size == 1) return true
        return doCanJump(nums)
    }

    private fun doCanJump(nums: IntArray): Boolean {
        var i = nums.lastIndex - 1
        var lastIndex = nums.lastIndex
        while (i >= 0) {
            if (nums[i] + i >= lastIndex) {
                lastIndex = i
            }
            i--
        }
        return lastIndex == 0
    }
}

fun main() {
//    3, 2, 1, 0, 4
//    2, 3, 1, 1, 4
//    0  1  2  3  4
//
    println(Solution().canJump(intArrayOf(2, 3, 1, 1, 4))) // true
    println(Solution().canJump(intArrayOf(3, 2, 1, 0, 4))) // false
    println(Solution().canJump(intArrayOf(2, 0, 0))) // true
    println(Solution().canJump(intArrayOf(0, 2, 3))) // false
    println(Solution().canJump(intArrayOf(1, 2, 3))) // true
}