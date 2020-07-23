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
class Solution {
    var result = true

    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null)
            return true
        findDepth(root, 0)
        return result
    }

    private fun findDepth(node: TreeNode?, level: Int): Int {
        if (node == null) {
            return level
        }
        val leftDepth = findDepth(node.left, level + 1)
        val rightDepth = findDepth(node.right, level + 1)
        if (abs(leftDepth - rightDepth) > 1)
            result = false
        return max(leftDepth, rightDepth)
    }
}



fun main() {
    val s = Solution()
    val root = deserialize("1,2,2,3,null,null,3,4,null,null,4")
    println(
        Solution().isBalanced(root)
    )
}