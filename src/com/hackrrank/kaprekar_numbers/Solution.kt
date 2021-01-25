package com.hackrrank.kaprekar_numbers

import java.lang.StringBuilder
import kotlin.test.assertEquals

fun main() {
    assertEquals("123456789", 123456789L.digits())
    assertEquals("1", 1L.digits())
    assertEquals("1000", 1000L.digits())
    kaprekarNumbers(1, 10000)
}

fun kaprekarNumbers(p: Int, q: Int): Unit {
    val values = (p..q).filter { it.isKaprekar() }
    if (values.isEmpty())
        println("INVALID RANGE")
    else
        println(values.joinToString(" "))
}

fun Int.isKaprekar(): Boolean {
    if (this == 1)
        return true
    if (this <= 3)
        return false
    val square: Long = this.toLong() * this.toLong()
    val squareChars = square.digits()
    val originalChars = this.toLong().digits()
    val first = squareChars.substring(0, squareChars.length - originalChars.length).toInt()
    val second = squareChars.substring(squareChars.length - originalChars.length).toInt()

    return second !=0 && (first + second) == this
}

fun Long.digits(): String {
    var dividend = this
    val result = StringBuilder()
    while (dividend != 0L) {
        val digit = dividend % 10
        dividend /= 10
        result.append(digit)
    }
    return result.reverse().toString()
}