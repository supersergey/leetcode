package com.company.util

import java.util.*

fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) {
            return null
        }
        val nodes = data.split(",").toTypedArray()
        val root = getOrNull(nodes, 0)
        val list = LinkedList<TreeNode?>()
        list.add(root)
        var i = 0
        while (i < nodes.size - 1 && !list.isEmpty()) {
            val current = list.pop()
            if (current != null) {
                current.left = getOrNull(nodes, ++i)
                current.right = getOrNull(nodes, ++i)
                list.add(current.left)
                list.add(current.right)
            }
        }
        return root
    }

    private fun getOrNull(list: Array<String>, pos: Int): TreeNode? {
        return if (list[pos] == "null") null else TreeNode(list[pos].toInt())
    }

fun serialize(root: TreeNode?): String {
    if (root == null) return ""
    val q = LinkedList<TreeNode?>()
    val result = StringBuilder()
    q.push(root)
    while (!q.isEmpty()) {
        val current = q.pop()
        result.append(current?.`val` ?: "null").append(";")
        if (current != null) {
            q.add(current.left)
            q.add(current.right)
        }
    }
    return result.toString()
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}