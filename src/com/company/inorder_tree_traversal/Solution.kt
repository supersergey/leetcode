package com.company.inorder_tree_traversal

import com.company.util.TreeNode
import java.util.Stack

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null)
            return emptyList()
        var stack = traverseLeft(root, Stack())
        while (!stack.isEmpty()) {
            val node = stack.pop()
            result.add(node.`val`)
            stack = traverseLeft(node.right, stack)
        }
        return result
    }

    private fun traverseLeft(root: TreeNode?, stack: Stack<TreeNode>): Stack<TreeNode> {
        var node = root

        while (node != null) {
            stack.push(node)
            node = node.left
        }
        return stack
    }

}