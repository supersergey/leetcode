package com.company.insertion_sort

import com.company.odd_even_linked_list.printAll
import com.company.util.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {

    fun insertionSortList(head: ListNode?): ListNode? {
        var current = head
        val dummy = ListNode(Int.MIN_VALUE)
        dummy.next = null
        while (current != null) {
            val insertionPoint = dummy.firstBiggerThan(current)
            val temp = insertionPoint?.next
            insertionPoint?.next = ListNode(current.`val`)
            insertionPoint?.next?.next = temp
            current = current.next
        }
        return dummy.next
    }

    private fun ListNode?.firstBiggerThan(current: ListNode?): ListNode? {
        var n = this
        while (n?.next != null && current != null && n.next!!.`val` < current.`val`)
            n = n.next
        return n
    }
}

fun main() {
    Solution().apply {
        insertionSortList(ListNode.parseList(listOf(5, -3, 8, 5))).printAll()
        insertionSortList(ListNode.parseList(listOf(1, 1))).printAll()
        insertionSortList(ListNode.parseList(listOf(4, 2, 1, 3))).printAll()
        insertionSortList(ListNode.parseList(listOf(1, 2, 4, 3))).printAll()
        insertionSortList(ListNode.parseList(listOf(-1, 0, 3, 4, 5))).printAll()
        insertionSortList(ListNode.parseList(listOf(3, 0))).printAll()
        insertionSortList(ListNode.parseList(listOf(0, 3))).printAll()
        insertionSortList(ListNode.parseList(listOf(0))).printAll()
    }
}