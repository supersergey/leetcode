package com.company.reverse_linked_list

import com.company.util.ListNode

fun main() {
    val n1 = initList(5)
    n1.print()
    val reverted = revertList(n1)
    reverted.print()
    val n2 = initList(5)
    val rec = revertListRecursively(n2)
    n2.next = null
    rec.print()
}

fun initList(n: Int): ListNode {
    val head = ListNode(1)
    var current = head
    for (i in 2..n) {
        val newNode = ListNode(i)
        current.next = newNode
        current = newNode
    }
    return head
}

fun revertList(head: ListNode): ListNode? {
    var current: ListNode? = head
    var next = current?.next
    current?.next = null
    while (next != null) {
        val temp = next.next
        next.next = current
        current = next
        next = temp
    }
    return current
}

fun revertListRecursively(node: ListNode?): ListNode? {
    if (node?.next?.next == null) {
        val head = node?.next
        node?.next?.next = node
        return head
    } else {
        val result = revertListRecursively(node.next)
        node.next?.next = node
        return result
    }
}

fun ListNode?.print() {
    var head = this
    while (head != null) {
        print("${head.`val`} ")
        head = head.next
    }
    println()
}