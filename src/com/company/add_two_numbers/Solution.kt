package com.company.add_two_numbers

import com.company.util.ListNode
import java.util.*
import kotlin.collections.ArrayList

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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1Reverted = reverseList(l1)
        var l2Reverted = reverseList(l2)
        var dummy: ListNode? = null
        var current: ListNode? = null
        var add = 0
        while (l1Reverted != null || l2Reverted != null) {
            val s1 = l1Reverted?.`val` ?: 0
            val s2 = l2Reverted?.`val` ?: 0
            val value = s1 + s2 + add
            add = value / 10
            current = ListNode(value % 10)
            current.next = dummy
            dummy = current
            l1Reverted = l1Reverted?.next
            l2Reverted = l2Reverted?.next
        }
        if (add != 0) {
            val node = ListNode(1)
            node.next = current
            current = node
        }
        return current
    }

    private fun reverseList(head: ListNode?): ListNode? {
        var node = head
        var dummy: ListNode? = null
        while (node != null) {
            val oldNext = node.next
            node.next = dummy
            dummy = node
            node = oldNext
        }
        return dummy
    }
}

fun main() {
    val l1 = ListNode.parseList(listOf(9, 9, 9))
    val l2 = ListNode.parseList(listOf(1))
    var result = Solution().addTwoNumbers(l1, l2)
    while (result != null) {
        print(result.`val`)
        result = result.next
    }
}