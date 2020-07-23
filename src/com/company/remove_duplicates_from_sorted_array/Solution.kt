package com.company.remove_duplicates_from_sorted_array

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var i = 0
        var counter = 0
        var current: Int? = null
        var newPointer: Int = 0
        while (i < nums.size) {
            if (current == nums[i]) {
                counter++
            }
            else {
                current = nums[i]
                nums[newPointer] = nums[i]
                newPointer++
            }
            i++
        }
        return nums.size - counter
    }
}

fun main() {
    var data = intArrayOf(1, 1, 2)
    println(Solution().removeDuplicates(data))
    println(data.joinToString(","))
    println("-----------")

    data = intArrayOf(0,0,1,1,1,2,2,3,3,4)
    println(Solution().removeDuplicates(data))
    println(data.joinToString(","))
    println("-----------")

    data = intArrayOf()
    println(Solution().removeDuplicates(data))
    println(data.joinToString(","))
    println("-----------")

    data = intArrayOf(1, 2, 3)
    println(Solution().removeDuplicates(data))
    println(data.joinToString(","))
    println("-----------")

    data = intArrayOf(1)
    println(Solution().removeDuplicates(data))
    println(data.joinToString(","))
}
