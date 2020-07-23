package com.company.`540_single_element_in_a_sorted_array`

class Solution {
    fun singleNonDuplicate(nums: IntArray): Int {
        var n = nums.first()
        for(i in (1..nums.lastIndex)) {
           n = n xor nums[i]
        }
        return n
    }
}

fun main() {
    println(
        Solution().singleNonDuplicate(
            intArrayOf(1,1,2,3,3,4,4,8,8)
        )
    )
    println(
        Solution().singleNonDuplicate(
            intArrayOf(3,3,7,7,10,11,11)
        )
    )
    println(
        Solution().singleNonDuplicate(
            intArrayOf(0)
        )
    )
}