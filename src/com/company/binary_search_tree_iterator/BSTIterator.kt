package com.company.binary_search_tree_iterator

import com.company.util.TreeNode
import java.util.Stack

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
class BSTIterator(root: TreeNode?) {

    val iterator = treeToList(root).iterator()

    /** @return the next smallest number */
    fun next(): Int = iterator.next()

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean = iterator.hasNext()

    private fun treeToList(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null)
            return emptyList()
        var stack = traverseLeft(root, Stack())
        while (stack.isNotEmpty()) {
            val current = stack.pop()
            result.add(current.`val`)
            stack = traverseLeft(current.right, stack)
        }
        return result
    }

    private fun traverseLeft(node: TreeNode?, stack: Stack<TreeNode>): Stack<TreeNode> {
        var current = node
        while (current != null) {
            stack.add(current)
            current = current.left
        }
        return stack
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */