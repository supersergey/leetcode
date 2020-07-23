package com.company.karatsuba

import java.math.BigDecimal

class Solution {
    fun multiply(num1: String, num2: String): String {
        val sb1 = StringBuilder(num1)
        val sb2 = StringBuilder(num2)
        var diff = 0
        if (num1.length < num2.length) {
            diff = num2.length - num1.length
            repeat(diff) { sb1.append('0') }
        } else if (num2.length < num1.length) {
            diff = num1.length - num2.length
            repeat(num1.length - num2.length) { sb2.append('0') }
        }
        val result = sb1.toString() multiply sb2.toString()
        if (result.trim { it == '0' }.isEmpty()) return "0"
        return result.substring(0, result.length - diff)
    }
}

infix fun String.multiply(s2: String): String {
    if (this.length == 1 || s2.length == 1)
        return (this.toLong() * s2.toLong()).toString()
    val middle = kotlin.math.max(this.length, s2.length) / 2
    val mid1 = this.length - middle
    val mid2 = s2.length - middle

    val a = this.substring(0, mid1)
    val b = this.substring(mid1, this.length)
    val c = s2.substring(0, mid2)
    val d = s2.substring(mid2, s2.length)

    val z2 = a multiply c
    val z0 = b multiply d
    val z1 = (b plus a) multiply (d plus c)

    return ((z2 pow10 (middle * 2)) plus ((z1 minus z2 minus z0) pow10 middle) plus z0)
}

fun String.trimZeroes(): String = this.trim().trimStart('0').ifEmpty { "0" }

infix fun String.plus(s2: String): String {
    if (this.startsWith('-') && s2.startsWith('-'))
        return "-" + (this.substring(1) plus s2.substring(1))
    if (this.startsWith('-'))
        return s2 minus this.substring(1)
    if (s2.startsWith('-'))
        return this minus s2.substring(1)
    var p1 = lastIndex
    var p2 = s2.lastIndex
    val result = CharArray(java.lang.Integer.max(length, s2.length))
    var r = result.lastIndex
    var add = 0
    while (p1 >= 0 || p2 >= 0) {
        val v1 = if (p1 < 0)
            0
        else this[p1].int
        val v2 = if (p2 < 0)
            0
        else s2[p2].int
        val sum = v1 + v2 + add
        add = if (sum / 10 > 0)
            1
        else
            0
        result[r--] = (sum % 10 + 0x30).toChar()
        p1--
        p2--
    }
    if (add != 0) {
        return ('1' + String(result))
    }

    return String(result)
}

infix fun String.minus(s: String): String {
    val s2 = s.trimZeroes()
    if (this.startsWith('-') && s2.startsWith('-')) {
        return this plus s2.substring(1)
    }
    if (this.startsWith('-') && !s2.startsWith('-')) {
        return "-" + (this.substring(1) plus s2)
    }
    if (!this.startsWith('-') && s2.startsWith('-'))
        return this plus s2.substring(1)
    if (this.length < s2.length)
        return "-" + (s2 minus this)
    if (this.length == s2.length) {
        var p = 0
        while (p < length) {
            if (this[p].int > s2[p].int)
                break
            if (this[p].int == s2[p].int)
                p++
            else return "-" + (s2 minus this)
        }
    }

    var p1 = lastIndex
    var p2 = s2.lastIndex

    val result = StringBuilder()
    var add = 0
    while (p1 >= 0 || p2 >= 0) {

        val v1 = if (p1 < 0) 0 else this[p1].int
        val v2 = if (p2 < 0) 0 else s2[p2].int
        if ((v1 + add) < v2) {
            result.insert(0, v1 + 10 + add - v2)
            add = -1
        } else {
            result.insert(0, v1 + add - v2)
            add = 0
        }
        p1--
        p2--
    }
    if (add == -1) {
        val firstDigit = result.first()
        result.removeRange(0, 0)
        result.insert(0, firstDigit.int - add)
    }

    return result.toString().trimZeroes()
}

private val Char.int
    get() = this.toInt() - 0x30

infix fun String.pow10(n: Int): String =
    StringBuilder(this).apply {
        repeat(n) {
            append("0")
        }
    }.toString()

fun main() {
    val s = Solution()
    assert("2024" == "1820" plus "204")
    assert("1000" == "999" plus "1")
    assert("1000" == "1" plus "999")
    assert("11" == "3" plus "8")
    assert("110" == "55" plus "55")
    assert("18" == "9" plus "9")
    assert("9" == "18" plus "-9")
    assert("-18" == "-25" plus "7")
    assert("-32" == "-25" plus "-7")
    assert("1" == "999" plus "-998")
    assert("2" == "-999" plus "1001")
    assert("-2" == "999" plus "-1001")

    assert("24" pow10 (3) == "24000")
    assert("1" pow10 (3) == "1000")

    assert("9" == "12" minus "3")
    assert("12" == "15" minus "3")
    assert("6" == "15" minus "9")
    assert("19" == "31" minus "12")
    assert("20" == "10" minus "-10")
    assert("-20" == "-10" minus "10")
    assert("0" == "-10" minus "-10")

    assert("40" == "-10" minus "-50")
    assert("0" == "-10" minus "-10")
    assert("5" == "-5" minus "-10")
    assert("-5" == "15" minus "20")
    assert("-40" == "52" minus "92")
    assert("-1" == "-999" minus "-998")
    assert("2" == "1001" minus "999")
    assert("960" == "2112" minus "1152")

    assert("156" == s.multiply("12", "13"))
    assert("100" == s.multiply("10", "10"))
    assert("1089" == s.multiply("33", "33"))
    assert("12" == s.multiply("1", "12"))

    assert("350" == s.multiply("35", "10"))
    assert("30" == s.multiply("30", "1"))

    assert("1230" == s.multiply("123", "10"))
    assert("625" == s.multiply("25", "25"))
    assert("10000" == s.multiply("100", "100"))
    assert("1000000" == s.multiply("1000", "1000"))
    assert("7006652" == s.multiply("5678", "1234"))
    assert("2097152" == s.multiply("1024", "2048"))
    assert("0" == s.multiply("1233", "0"))
    assert("0" == s.multiply("0", "0"))
    assert("0" == s.multiply("0", "1234"))

    assert("67069772192" == s.multiply("8", "8383721524"))
    assert(
        BigDecimal("401716832807512840963")
            .multiply(BigDecimal("167141802233061013023557397451289113296441069"))
            .toString() ==
        s.multiply(
            "401716832807512840963",
            "167141802233061013023557397451289113296441069"))

    assert(
        BigDecimal("713303953233").multiply(BigDecimal("4489481")).toString() ==
            s.multiply(
                "713303953233", "4489481"
            )
    )

    val b1 = BigDecimal("3141592653589793238462643383279502884197169399375105820974944592")
    val b2 = BigDecimal("2718281828459045235360287471352662497757247093699959574966967627")
    val result =
        s.multiply(
            "3141592653589793238462643383279502884197169399375105820974944592",
            "2718281828459045235360287471352662497757247093699959574966967627")
    assert(b1.multiply(b2).toString() == result)

}