package com.company.count_inversions

import java.io.File

class Solution {
    fun sortAndCount(nums: IntArray): SortAndCount {
        if (nums.size <= 1)
            return SortAndCount(nums, 0)
        if (nums.size == 2) {
            return if (nums[0] < nums[1])
                SortAndCount(intArrayOf(nums[0], nums[1]), 0)
            else
                SortAndCount(intArrayOf(nums[1], nums[0]), 1)
        }
        val middle = nums.size / 2
        val left = sortAndCount(nums.sliceArray(0..middle))
        val right = sortAndCount(nums.sliceArray(middle + 1..nums.lastIndex))
        val merged = mergeAndCount(left.array, right.array)
        return SortAndCount(merged.array, left.count + right.count + merged.count)
    }

    fun mergeAndCount(num1: IntArray, num2: IntArray): SortAndCount {
        var count = 0L
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
                else {
                    result[r++] = num2[p2++]
                    count += (num1.size - p1)
                }
            } else
                if (p1 !in num1.indices)
                    result[r++] = num2[p2++]
                else
                    result[r++] = num1[p1++]
        }
        return SortAndCount(result, count)
    }
}

class SortAndCount(val array: IntArray, val count: Long)

fun main() {
    val s = Solution()
    println(s.sortAndCount(intArrayOf(6, 5, 4, 3, 2, 1)).count)
    println(s.sortAndCount(intArrayOf(8, 4, 2, 1)).count)
    println(s.sortAndCount(intArrayOf(3, 1, 2)).count)

    val f1 = File("/Users/sergiytolokunskyy/dev/leetcode/twoSum/src/com/company/count_inversions/IntegerArray.txt")
    val data1 = f1.bufferedReader().lines().mapToInt { Integer.parseInt(it) }.toArray()

    val f2 = File("/Users/sergiytolokunskyy/Downloads/IntegerArray.txt")
    val data2 = f2.bufferedReader().lines().mapToInt { Integer.parseInt(it) }.toArray()

    println(s.sortAndCount(data1).count)
    println(s.sortAndCount(data2).count)
}