package com.hackrrank.encryption

import kotlin.math.sqrt
import kotlin.test.assertEquals

// Complete the encryption function below.
fun encryption(s: String): String {
    val noSpaces = s.toCharArray().filter { it != ' ' }.joinToString("")
    val size = sqrt(noSpaces.length.toDouble()).toInt()
    val x = if (size * size < s.length)
        size + 1
    else
        size
    var p = 0
    val strings = mutableListOf<String>()
    while (p < noSpaces.length) {
        val end = if ((p + x) > noSpaces.length)
            noSpaces.length
        else
            p + x
        strings.add(noSpaces.substring(p, end))
        p += x
    }
    val result = StringBuilder()
    for (i in 0..strings.first().length) {
        for (str in strings) {
            if (i < str.length)
                result.append(str[i])
        }
        result.append(" ")
    }
    return result.toString().trim()
}

fun main(args: Array<String>) {
    test()
}

fun test() {
    assertEquals("clu hlt io", encryption("chillout"))
    assertEquals("hae and via ecy", encryption("haveaniceday"))
}
