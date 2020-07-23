package com.company.convert_sorted_list_to_binary_search_tree

import com.company.util.ListNode
import com.company.util.TreeNode
import java.util.LinkedList
import java.util.Stack

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun sortedListToBST(head: ListNode?): TreeNode? = TODO()
}

fun main() {
    val head = Solution().sortedListToBST(
        ListNode.parseList(listOf(-10, -3, 0, 5, 9))
    )
    val queue = LinkedList<TreeNode?>()
    if (head != null)
        queue.add(head)
    while (queue.isNotEmpty()) {
        val node = queue.pop()
        if (node?.left != null)
            queue.add(node.left)
        if (node?.right != null)
            queue.add(node.left)
        println(node?.`val`)
    }
}