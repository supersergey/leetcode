package com.company.binarytree_right_side_view

import java.util.LinkedList

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

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null)
            return emptyList()
        val queue = LinkedList<TreeNode>()
        val levels = LinkedList<Int>()
        val result = mutableMapOf<Int, Int>()
        queue.add(root)
        levels.add(0)
        while (queue.isNotEmpty()) {
            val node = queue.pop()
            val level = levels.pop()
            result[level] = node.`val`
            if (node.left != null) {
                queue.add(node.left!!)
                levels.add(level + 1)
            }
            if (node.right != null) {
                queue.add(node.right!!)
                levels.add(level + 1)
            }
        }
        return result.values.toList()
    }
}

fun main() {
    val n1 = TreeNode(1)
    val n2 = TreeNode(2)
    val n3 = TreeNode(3)
    val n4 = TreeNode(4)
//    val n5 = TreeNode(5)
    n1.left = n2
    n1.right = n3
    n2.left = n4
//    n3.right = n4
    println(
        Solution().rightSideView(n1)
    )
}