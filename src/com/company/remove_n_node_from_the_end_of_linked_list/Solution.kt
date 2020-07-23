package com.company.remove_n_node_from_the_end_of_linked_list

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null)
            return null
        val dummy = ListNode(0)
        dummy.next = head
        var current: ListNode? = head
        var secondary: ListNode? = dummy
        var counter = -n
        while (current != null) {
            current = current.next
            if (counter >= 0)
                secondary = secondary?.next
            counter++
        }
        secondary?.next = secondary?.next?.next
        return dummy.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
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

fun main() {
    Solution().removeNthFromEnd(createList(5), 2)?.print() // 1 2 3 5
    Solution().removeNthFromEnd(createList(1), 1)?.print() // null
    Solution().removeNthFromEnd(createList(2), 2)?.print() // 2
    Solution().removeNthFromEnd(createList(2), 1)?.print() // 1
}