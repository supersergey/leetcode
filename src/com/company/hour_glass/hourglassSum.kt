package com.company.hour_glass

import java.lang.Integer.max
import java.util.Scanner

fun hourglassSum(arr: Array<Array<Int>>): Int {
    var result = Integer.MIN_VALUE
    for(i in 0..arr.lastIndex - 2) {
        for(j in 0..arr[i].lastIndex - 2) {
            val sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] +
                arr[i+1][j+1] +
                arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]
            result = max(result, sum)
        }
    }
    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}