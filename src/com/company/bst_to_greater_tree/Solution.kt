package com.company.bst_to_greater_tree

import com.company.util.TreeNode
import com.company.util.deserialize
import java.util.LinkedList

class Solution {

    private var sum = 0

    fun convertBST(root: TreeNode?): TreeNode? {
        if (root == null)
            return null
        convertBST(root.right)
        sum += root.`val`
        root.`val` = sum
        convertBST(root.left)
        return root
    }
}

fun main() {
    val s = Solution()
    val root = deserialize("4,1,6,0,2,5,7,null,null,null,3,null,null,null,8")
    val sum = s.convertBST(root)
    sum.breadthFirstTraversal()
}

fun TreeNode?.breadthFirstTraversal() {
    val queue = LinkedList<TreeNode?>()
    queue.add(this)
    while (queue.isNotEmpty()) {
        val node = queue.pop()
        println(node?.`val`)
        if (node != null) {
            queue.add(node.left)
            queue.add(node.right)
        }
    }
}

fun TreeNode?.inOrderTraversal() {
    if (this == null)
        return
    right.inOrderTraversal()
    println(`val`)
    left.inOrderTraversal()
}