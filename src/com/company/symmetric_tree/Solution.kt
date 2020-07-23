package com.company.symmetric_tree

import com.company.util.TreeNode
import com.company.util.deserialize
import java.util.LinkedList
import kotlin.math.pow

class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        val queue = LinkedList<LevelNode>()
        val map = mutableMapOf<Int, MutableList<Int?>>()
        map.process(level = 0, node = root)
        queue.push(LevelNode(0, root))
        while (queue.isNotEmpty()) {
            val element = queue.pop()
            map.process(element.node.left, element.level + 1)
            map.process(element.node.right, element.level + 1)
            if (element.node.left != null) {
                queue.add(LevelNode(level = element.level + 1, node = element.node.left!!))
            }
            if (element.node.right != null) {
                queue.add(LevelNode(level = element.level + 1, node = element.node.right!!))
            }
        }
        for (entry in map) {
            val values = entry.value
            if (values.size % 2 != 0 && values.size != 1)
                return false
            if (!values.isSymmetric())
                return false
        }
        return true
    }

    private fun MutableMap<Int, MutableList<Int?>>.process(node: TreeNode?, level: Int) {
        this.computeIfAbsent(level) { mutableListOf() }.add(node?.`val`)
    }

    private fun List<Int?>.isSymmetric(): Boolean {
        var first = 0
        var last = this.lastIndex
        while (first < last) {
            if (this[first] != this[last])
                return false
            first++
            last--
        }
        return true
    }

    class LevelNode(val level: Int, val node: TreeNode)
}

fun main() {
    val root1 = deserialize("1,2,2,3,4,4,3")
    println(Solution().isSymmetric(root1))
    val root2 = deserialize("1,2,2,null,3,null,3")
    println(Solution().isSymmetric(root2))
    val root3 = deserialize("1,2,2,null,3,3,null")
    println(Solution().isSymmetric(root3))
}