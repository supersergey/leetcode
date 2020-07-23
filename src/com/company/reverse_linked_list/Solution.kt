package com.company.reverse_linked_list

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
    fun reverseList(head: ListNode?): ListNode? {
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

    fun reverseListRecursively(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        helper(head, dummy)
        head?.next = null
        return dummy.next
    }

    private fun helper(head: ListNode?, dummy: ListNode): ListNode? {
        return if (head?.next == null) {
            dummy.next = head
            head
        } else {
            val node = helper(head.next, dummy)
            node?.next = head
            head
        }
    }
}

fun main() {
    val s = Solution()
    var head = s.reverseListRecursively(ListNode.parseList(listOf(1,2,3,4,5)))
    while (head != null) {
        print(head.`val`)
        head = head.next
    }
}