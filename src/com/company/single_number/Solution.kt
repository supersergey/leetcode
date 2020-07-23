package com.company.single_number

class Solution {
    fun singleNumber(nums: IntArray): Int {
        var result = nums.first()
        for (n in 1 until nums.size) {
            result = result xor nums[n]
        }
        return result
    }
}