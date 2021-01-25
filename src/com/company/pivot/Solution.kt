package com.company.pivot

val arr = intArrayOf(8, 5, 1, 2, 9, 6)


fun pivot(arr: IntArray): IntArray {
    val pivotIndex = arr.lastIndex
    var i = 0
    for(j in 0 until arr.lastIndex) {
        if(arr[j] < arr[pivotIndex]) {
            arr.swap(i, j)
            i++
        }
    }
    arr.swap(i, pivotIndex)
    return arr
}

fun IntArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun main() {
    println(pivot(arr).joinToString(" "))
}