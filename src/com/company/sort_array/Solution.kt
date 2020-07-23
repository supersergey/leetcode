package com.company.sort_array

class Solution {
    fun sortArray(nums: IntArray): IntArray {
        if (nums.size <= 1)
            return nums
        if (nums.size == 2) {
            return if (nums[0] < nums[1])
                intArrayOf(nums[0], nums[1])
            else
                intArrayOf(nums[1], nums[0])
        }
        val middle = nums.size / 2
        val left = sortArray(nums.sliceArray(0..middle))
        val right = sortArray(nums.sliceArray(middle + 1..nums.lastIndex))
        return merge(left, right)
    }

    fun merge(num1: IntArray, num2: IntArray): IntArray {
        var p1 = 0
        var p2 = 0
        var r = 0
        val result = IntArray(num1.size + num2.size)
        while(true) {
            if (p1 !in num1.indices && p2 !in num2.indices)
                break
            if (p1 in num1.indices && p2 in num2.indices) {
                if(num1[p1] < num2[p2])
                    result[r++] = num1[p1++]
                else
                    result[r++] = num2[p2++]
            } else
                if (p1 !in num1.indices)
                    result[r++] = num2[p2++]
                else
                    result[r++] = num1[p1++]
        }
        return result
    }
}

fun main() {
    val s = Solution()
    s.merge(intArrayOf(1, 3, 5), intArrayOf(2, 4, 6)).forEach { print(it) }
    println()
    s.merge(intArrayOf(7), intArrayOf(2, 4, 6)).forEach { print(it) }
    println()
    s.sortArray(intArrayOf(8,7,9,6,1)).forEach { print(it) }
}