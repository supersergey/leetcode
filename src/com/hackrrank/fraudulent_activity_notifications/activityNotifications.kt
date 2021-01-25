//package com.hackrrank.fraudulent_activity_notifications
//
//import kotlin.test.assertEquals
//
//// Complete the activityNotifications function below.
//fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
//    var prefix = expenditure.copyOfRange(0, d + 1)
//    var prefixSorted = prefix.sortedArray()
//    var counter = 0
//    for(i in (d + 1)..expenditure.size) {
//        if (expenditure[d] >= prefixSorted.median())
//            counter++
//        prefixSorted = prefix.shift(prefixSorted, expenditure[d])
//    }
//}
//
//fun Array<Int>.shift(prefixSorted: Array<Int>, newElement: Int) {
//    val prefixOriginal = this
//    var n = 0
//    do {
//        if(prefixSorted[n] != prefixOriginal.first())
//            n++
//        else break
//    } while (n < prefixOriginal.size)
//
//}
//
//fun Array<Int>.median(): Double {
//    if (this.size == 1)
//        return this.first().toDouble()
//    val middleIndex = this.size / 2
//    return if (this.size % 2 == 0)
//        (this[middleIndex - 1] + this[middleIndex]) / 2.0
//    else
//        this[middleIndex].toDouble()
//}
//
//fun com.company.rotten_oranges.main() {
//    testMedian()
//}
//
//fun testMedian() {
//    assertEquals(3.0, arrayOf(2, 3, 4, 2, 3).sortedArray().median())
//    assertEquals(3.0, arrayOf(3, 4, 2, 3, 6).sortedArray().median())
//    assertEquals(4.0, arrayOf(4, 2, 3, 6, 8).sortedArray().median())
//    assertEquals(4.0, arrayOf(2, 3, 6, 8, 4).sortedArray().median())
//    assertEquals(1.0, arrayOf(1).median())
//    assertEquals(1.5, arrayOf(1, 2).median())
//}