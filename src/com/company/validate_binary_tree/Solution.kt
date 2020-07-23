package com.company.validate_binary_tree

import com.company.util.TreeNode
import com.company.util.deserialize

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
    fun isValidBST(root: TreeNode?): Boolean {
        return findNext(root, null, null)
    }

    private fun findNext(root: TreeNode?, low: Int?, high: Int?): Boolean {
        if (root == null)
            return true
        if (low != null && root.`val` <= low)
            return false
        if (high != null && root.`val` >= high)
            return false
        return findNext(root.left, low, root.`val`) && findNext(root.right, root.`val`, high)
    }
}


fun main() {
    val case1 = deserialize("2,1,3")
    println(Solution().isValidBST(case1)) // true

    val case2 = deserialize("2,1,0")
    println(Solution().isValidBST(case2)) //false

    val case3 = deserialize("5,1,4,null,null,3,6")
    println(Solution().isValidBST(case3)) // false

    val case4 = deserialize("10,5,15,null,null,6,20")
    println(Solution().isValidBST(case4)) // false

    val case5 = deserialize("1,1,null")
    println(Solution().isValidBST(case5)) // false

    val case6 = deserialize("1,null,1")
    println(Solution().isValidBST(case6)) // false
}