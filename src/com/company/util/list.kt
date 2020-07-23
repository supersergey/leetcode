package com.company.util

data class ListNode(var `val`: Int) {
    var next: ListNode? = null

    companion object {
        fun parseList(list: List<Int>): ListNode? {
            if (list.isEmpty())
                return null
            var prev = ListNode(-999)
            val head = prev
            for (e in list) {
                val node = ListNode(e)
                prev.next = node
                prev = node
            }
            return head.next
        }
    }
}

fun main() {
    var head = ListNode.parseList((0..10).toList())
    while (head != null) {
       println(head.`val`)
       head = head.next
    }
}

