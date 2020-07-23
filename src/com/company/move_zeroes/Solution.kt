package com.company.move_zeroes

class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        if (nums.isNotEmpty()) {
            var nonZeroPointer = 0
            for (n in nums) {
                if (n != 0) {
                    nums[nonZeroPointer] = n
                    nonZeroPointer++
                }
            }
            (nonZeroPointer until nums.size).forEach {
                nums[it] = 0
            }
        }
    }
}

fun main() {
    val array = intArrayOf(0, 1, 0, 3, 12)
    Solution().moveZeroes(array)
    println(
        array.joinToString(" ")
    )
}