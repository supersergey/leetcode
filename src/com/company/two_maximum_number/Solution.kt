package com.company.two_maximum_number

fun twoMaximumNumbers(numbers: IntArray): Pair<Int, Int> {
    var result = Pair(Integer.MIN_VALUE, Integer.MIN_VALUE)
    numbers.forEach {
        if (it > result.first) {
            result = result.copy(it, result.first)
        }
    }
    return result
}

fun main() {
    println(twoMaximumNumbers(intArrayOf(5, 3, 2, 4, 8)))
    println(twoMaximumNumbers(intArrayOf(8, 7, 6, 0, 10)))
}

