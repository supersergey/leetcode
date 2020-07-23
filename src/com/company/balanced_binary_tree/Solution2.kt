package com.company.balanced_binary_tree

import com.company.util.TreeNode
import com.company.util.deserialize
import kotlin.math.abs
import kotlin.math.max

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
class Solution2 {
    private var result = true

    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null)
            return true
        nodeLength(root, 0)
        return result
    }

    private fun nodeLength(node: TreeNode?, level: Int): Int {
        if (node == null)
            return level
        val l = nodeLength(node.left, level + 1)
        val r = nodeLength(node.right, level + 1)
        if (abs(l - r) > 1) {
            result = false
        }
        return max(l, r)
    }
}



fun main() {
    val root1 = deserialize("3,9,20,null,null,15,7")
    val root2 = deserialize("1,2,2,3,null,null,3,4,null,null,4")
    val root3 = deserialize("1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5")
    println(
        Solution2().isBalanced(root1)
    )
    println(
        Solution2().isBalanced(root2)
    )
    println(
        Solution2().isBalanced(root3)
    )
}