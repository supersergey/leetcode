package com.hackrrank.bigger_is_greater

import kotlin.test.assertEquals

fun main() {
//    assertEquals(2, "abcd".largestIndex())
//    assertEquals(2, "0125330".largestIndex())
//    assertEquals(-1, "bb".largestIndex())
//    assertEquals(2, "aaadcbb".largestIndex())
//
//    assertEquals(6, "aaadcbb".pivotIndex(0))
//    assertEquals(-1, "aaadcbb".pivotIndex(3))
//    assertEquals(3, "aaadcbb".pivotIndex(4))
//
//    assertEquals("cba", "abc".swap(0, 2))
//    assertEquals("acb", "abc".swap( 1, 2))
//
//    assertEquals("abdc", "abcd".reverseSuffix(1))
//
    assertEquals("lmon", biggerIsGreater("lmno"))
    assertEquals("no answer", biggerIsGreater("dcba"))
    assertEquals("no answer", biggerIsGreater("dcbb"))
    assertEquals("acbd", biggerIsGreater("abdc"))
    assertEquals("abdc", biggerIsGreater("abcd"))
    assertEquals("fedcbabdc", biggerIsGreater("fedcbabcd"))

    assertEquals("ba", biggerIsGreater("ab"))
    assertEquals("no answer", biggerIsGreater("bb"))
    assertEquals("no answer", biggerIsGreater("b"))
    assertEquals("no answer", biggerIsGreater(""))
    assertEquals("hegf", biggerIsGreater("hefg"))
    assertEquals("dhkc", biggerIsGreater("dhck"))
    assertEquals("hcdk", biggerIsGreater("dkhc"))
}

fun biggerIsGreater(w: String): String {
    val largestIndex = w.largestIndex()
    if (largestIndex == -1) {
        return "no answer"
    }
    val pivotIndex = w.pivotIndex(largestIndex)
    val swapped = w.swap(largestIndex, pivotIndex)
    return swapped.reverseSuffix(largestIndex)
}

fun String.largestIndex(): Int {
    var result = -1
    for(i in 0 until this.lastIndex) {
        if (this[i] < this[i+1])
            result = i
    }
    return result
}

fun String.pivotIndex(largestIndex: Int): Int {
    var result = -1
    for(i in 0..this.lastIndex) {
        if (this[largestIndex] < this[i])
            result = i
    }
    return result
}

fun String.swap(i: Int, j: Int): String {
    val chars = this.toCharArray()
    val temp = chars[i]
    chars[i] = chars[j]
    chars[j] = temp
    return String(chars)
}

fun String.reverseSuffix(pivotIndex: Int): String {
    return this.substring(0, pivotIndex + 1) + this.substring(pivotIndex + 1).reversed()
}