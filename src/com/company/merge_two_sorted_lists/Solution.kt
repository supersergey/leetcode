package com.company.merge_two_sorted_lists

import kotlin.math.min

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
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var dummy: ListNode? = ListNode(0)
        var result = dummy
        var p1 = l1
        var p2 = l2
        while (dummy != null) {
            if (p1 == null && p2 == null)
                break
            else {
                var next: ListNode
                if (p1 == null && p2 != null) {
                    next = p2
                    p2 = p2.next
                }
                else if (p2 == null && p1 != null) {
                    next = p1
                    p1 = p1.next
                }
                else
                    if (p1!!.`val` < p2!!.`val`) {
                        next = p1
                        p1 = p1.next
                    } else {
                        next = p2
                        p2 = p2.next
                    }
                dummy.next = next
                dummy = dummy.next
            }
        }
        return result?.next
    }
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val l1n1 = ListNode(1)
    val l1n2 = ListNode(2)
    val l1n3 = ListNode(4)
    l1n1.next = l1n2
    l1n2.next = l1n3

    val l2n1 = ListNode(1)
    val l2n2 = ListNode(3)
    val l2n3 = ListNode(4)
    l2n1.next = l2n2
    l2n2.next = l2n3
//    l1n1.print()
//    l2n1.print()
//    Solution().mergeTwoLists(l1n1, l2n1)?.print()
    Solution().mergeTwoLists(null, null)?.print()
}

fun ListNode.print() {
    var current: ListNode? = this
    while (current != null) {
        print("${current.`val`} ")
        current = current.next
    }
    println()
}

fun createList(n: Int): ListNode? {
    if (n == 0)
        return null
    val head = ListNode(1)
    var current: ListNode? = head
    for (i in 2..n) {
        current?.next = ListNode(i)
        current = current?.next
    }
    return head
}