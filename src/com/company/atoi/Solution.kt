package com.company.atoi

class Solution {
    fun myAtoi(str: String): Int = with(str.trim()) {
        var trimmed = this

        if (!trimmed.isValid())
            return 0

        var result: Long = 0

        val sign = if (trimmed.first() == '-')
            -1
        else
            1

        var border = 0

        if (trimmed[0] == '-' || trimmed[0] == '+')
            border++

        var firstIndex = border
        while (firstIndex < trimmed.length && trimmed[firstIndex] == '0')
            firstIndex++

        for (c in trimmed.substring(border)) {
            if (c in '0'..'9')
                border++
            else
                break
        }

        val s = if (border > 0)
            trimmed.substring(firstIndex, border).reversed()
        else
            trimmed.reversed()

        var index = 0

        for (c in s) {
            when (c) {
                in '0'..'9' -> {
                    val nextDigit = c.toString().toInt() * 10.pow(index) * sign
                    if (index > 11 || nextDigit + result > Int.MAX_VALUE) {
                        return Int.MAX_VALUE
                    }
                    if (index > 11 || nextDigit + result < Int.MIN_VALUE) {
                        return Int.MIN_VALUE
                    }
                    result += nextDigit
                    index++
                }
                else -> {
                }
            }

        }
        return result.toInt()
    }

    private fun String.isValid(): Boolean =
        this.isNotBlank() &&
            (this.first() == '-' || this.first() == '+' || this.first() in '0'..'9')

    private fun Int.pow(n: Int): Long {
        var result: Long = 1
        repeat(n) {
            result *= this
        }
        return result
    }
}

fun main() {
    launch("    43")
    launch("-42")
    launch("4")
    launch("-4")
    launch("+4")
    launch("0")
    launch("4193 with words") // 4193
    launch("5555")
    launch("words and 987")
    launch("-91283472332") // -2147483648
    launch("9223372036854775808") // 2147483647
    launch("3.14159") // 3
    launch("0-1") // 0
    launch("0+1") // 0
    launch("+-2") // 0
    launch("-5-") // 5
    launch("-4193 with words")// 4193
    launch("-13+8") // -13
    launch("+1") // 1
    launch("        +0a32") //0
    launch("words and 0987") //0
    launch(
        "10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459") //0
    launch("  0000000000012345678")
    launch("+")
}

fun launch(s: String) {
    println("expected: $s, actual: " + Solution().myAtoi(s))
}

