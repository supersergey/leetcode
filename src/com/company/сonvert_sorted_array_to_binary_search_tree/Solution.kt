package com.company.сonvert_sorted_array_to_binary_search_tree

import com.company.serialize_binary_tree.Codec
import com.company.util.TreeNode
import com.company.util.serialize

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
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty())
            return null
        val middle = nums.size / 2
        val head = TreeNode(nums[middle])
        head.left = helper(nums, 0, middle)
        head.right = helper(nums, middle + 1, nums.size)
        return head
    }

    private fun helper(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start >= end)
            return null
        val middle = (end + start) / 2
        return TreeNode(nums[middle]).apply {
            left = helper(nums, start, middle)
            right = helper(nums, middle + 1, end)
        }
    }
}

fun main() {
    val arr = intArrayOf(-10,-3,0,5,9)
    val head = Solution().sortedArrayToBST(arr)
    println(serialize(head))
}