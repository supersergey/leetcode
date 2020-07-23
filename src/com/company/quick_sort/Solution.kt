package com.company.quick_sort

import java.io.File

class Solution {
    var counter = 0L

    fun quickSort(array: IntArray): Long {
        helper(array, 0, array.size)
        return counter
    }

    private fun helper(array: IntArray, startIndex: Int, endIndex: Int) {
        if (endIndex - startIndex == 0)
            return
        val pivotIndex = array.partitionMiddle(startIndex, endIndex)
        counter += pivotIndex - startIndex - 1
        helper(array, startIndex, pivotIndex)
        counter += endIndex - pivotIndex
        helper(array, pivotIndex + 1, endIndex)
    }

    fun IntArray.partitionFirst(startIndex: Int, endIndex: Int): Int {
        var pivotIndex = startIndex + 1
        for (visitedIndex in startIndex + 1 until endIndex) {
            if (this[visitedIndex] < this[startIndex]) {
                swap(pivotIndex, visitedIndex)
                pivotIndex++
            }
        }
        swap(startIndex, pivotIndex - 1)
        return pivotIndex - 1
    }

    fun IntArray.partitionLast(startIndex: Int, endIndex: Int): Int {
        swap(startIndex, endIndex - 1)
        return this.partitionFirst(startIndex, endIndex)
//        var pivotIndex = startIndex
//        for (visitedIndex in startIndex until endIndex - 1) {
//            if (this[visitedIndex] < this[endIndex - 1]) {
//                swap(pivotIndex, visitedIndex)
//                pivotIndex++
//            }
//        }
//        swap(endIndex - 1, pivotIndex)
//        return pivotIndex
    }

    fun IntArray.partitionMiddle(startIndex: Int, endIndex: Int): Int {
        val pivotIndex = this.getMiddle(startIndex, endIndex)
        swap(startIndex, pivotIndex)
        return this.partitionFirst(startIndex, endIndex)
//        var changeIndex = startIndex
//        for (visitedIndex in startIndex + 1 until endIndex) {
//            if (this[visitedIndex] < this[pivotIndex]) {
//                swap(changeIndex, visitedIndex)
//                changeIndex++
//            }
//        }
//        swap(pivotIndex, changeIndex)
//        return changeIndex
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }

    private fun IntArray.getMiddle(startIndex: Int, endIndex: Int): Int {
        val middleIndex = if ((endIndex - startIndex) % 2 == 0)
            (endIndex - startIndex) / 2 + startIndex - 1
        else
            (endIndex - startIndex) / 2 + startIndex
        val mid = intArrayOf(this[startIndex], this[middleIndex], this[endIndex - 1]).sorted()[1]
        if (mid == this[startIndex])
            return startIndex
        if (mid == this[middleIndex])
            return middleIndex
        if (mid == this[endIndex - 1])
            return endIndex - 1
        return -1
    }
}

fun main() {
//    val r = Random(1000)
//    val parr = IntArray(1000) { r.nextInt(-1000, 1000) }
//    val parr = intArrayOf(8, 2, 4, 5, 7, 1)
//    println(parr.getMiddle(0, parr.size))
//    println(
//        parr.apply {
//            Solution().quickSort(this)
//        }.joinToString(" ")
//    )

//    println(Solution().quickSort(parr))
//    assert(arr.toList() == arr.sortedArray().reversed().toList())

    val file = File("/Users/sergiytolokunskyy/Downloads/QuickSort.txt")
    val reader = file.bufferedReader()
    val toSort = reader.lines().mapToInt { Integer.parseInt(it) }.toArray()
    reader.close()

    println(Solution().quickSort(toSort))

}