package com.company.kth_largest_element

class Solution {

    fun findKthLargest(nums: IntArray, k: Int): Int {
        var begin = 0
        var end = nums.lastIndex
        while (true) {
            val pivot = nums.partition(begin, end)
            if (k - 1 == pivot)
                return nums[pivot]
            if (pivot > k - 1) {
                end = pivot - 1
            }
            if (pivot < k - 1) {
                begin = pivot + 1
            }
        }
    }

    private fun IntArray.partition(begin: Int, end: Int): Int {
        var i = begin
        for (j in begin until end) {
            if (this[j] >= this[end]) {
                this.swap(i, j)
                i++
            }
        }
        swap(i, end)
        return i.also { println(this.joinToString(" ")) }
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}

fun main() {
    val s = Solution()
    println(s.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    println(s.findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
}