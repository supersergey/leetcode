package com.company.odd_even_linked_list

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
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null)
            return null
        val headEven = head.next
        var currentOdd = head
        var currentEven = head.next
        var lastOdd = head
        var counter = 1
        while (currentEven != null || currentOdd != null) {
            if (counter % 2 != 0) {
                currentOdd?.next = currentOdd?.next?.next
                currentOdd = currentOdd?.next
                if (currentOdd != null) {
                    lastOdd = currentOdd
                }
            } else {
                currentEven?.next = currentEven?.next?.next
                currentEven = currentEven?.next
            }
            counter++
        }
        lastOdd?.next = headEven
        return head
    }
}

fun IntArray?.toLinkedList(): ListNode? {
    if (this==null || this.isEmpty())
        return null
    var node: ListNode? = null
    for(n in this.lastIndex downTo 0) {
        var newNode = ListNode(this[n])
        newNode.next = node
        node = newNode
    }
    return node
}

fun ListNode?.printAll() {
    var head = this
    while (head != null) {
        print("${head.`val`} ")
        head = head.next
    }
    println()
}

fun main() {
    val list1 = intArrayOf(1, 2, 3, 4, 5).toLinkedList()
    Solution().oddEvenList(list1).printAll()
    val list2 = intArrayOf(1, 2).toLinkedList()
    Solution().oddEvenList(list2).printAll()
    val list3 = intArrayOf(1).toLinkedList()
    Solution().oddEvenList(list3).printAll()
}