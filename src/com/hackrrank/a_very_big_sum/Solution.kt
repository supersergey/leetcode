package com.hackrrank.a_very_big_sum

import java.lang.StringBuilder
import kotlin.test.assertEquals

fun main() {
    testSum()
    testAVeryBigNumber()
    plusMinus(arrayOf(-4, 3, -9, 0, 4, 1))
}

infix fun String.plus(that: String): String {
    var thisIndex = this.lastIndex
    var thatIndex = that.lastIndex
    val result = StringBuilder()
    var compliment = 0
    while(thisIndex >=0 || thatIndex >=0) {
        val digit = compliment + that.getIntValueAtIndex(thatIndex) + this.getIntValueAtIndex(thisIndex)
        compliment = digit / 10
        result.append(digit % 10)
        thatIndex--
        thisIndex--
    }
    if (compliment != 0)
        result.append(compliment)
    return result.reversed().toString()
}

fun String.getIntValueAtIndex(index: Int): Int =
    if (index in this.indices)
        Character.getNumericValue(this[index])
    else 0

fun aVeryBigSum(ar: Array<Long>): Long {
    val numbers = ar.map { it.toString() }
    var result = "0"
    for (n in numbers) {
        result = result plus n
    }
    return result.toLong()
}

fun testSum() {
    assertEquals("0", "0" plus "0")
    assertEquals("2", "1" plus "1")
    assertEquals("1", "1" plus "0")
    assertEquals("1", "0" plus "1")
    assertEquals("10", "9" plus "1")
    assertEquals("11", "9" plus "2")
    assertEquals("18", "9" plus "9")
    assertEquals("1010", "999" plus "11")
    assertEquals("10000", "1" plus "9999")
}

fun testAVeryBigNumber() {
    assertEquals(0L, aVeryBigSum(arrayOf(0, 0, 0, 0, 0)))
    assertEquals(5L, aVeryBigSum(arrayOf(1, 1, 1, 1, 1)))
    assertEquals(11100L, aVeryBigSum(arrayOf(99, 1, 999, 1, 9999, 1)))

    println()
}

fun plusMinus(arr: Array<Int>): Unit {
    var negatives = 0
    var positives = 0
    var zeroes = 0
    for(n in arr) {
        if (n < 0) {
            negatives++
            continue
        }
        if (n > 0) {
            positives++
            continue
        }
        zeroes++
    }

    println("%.6f".format(positives.toDouble() / arr.size))
    println("%.6f".format(negatives.toDouble() / arr.size))
    println("%.6f".format(zeroes.toDouble() / arr.size))
}