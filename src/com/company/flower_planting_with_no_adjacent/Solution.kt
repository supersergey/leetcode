package com.company.flower_planting_with_no_adjacent

class Solution {
    private val colors = setOf(1, 2, 3, 4)

    fun gardenNoAdj(N: Int, paths: Array<IntArray>): IntArray {
        val gardens = (0 until N).map { Garden() }
        for (path in paths) {
            gardens[path[0] - 1].addNeighbor(gardens[path[1] - 1])
            gardens[path[1] - 1].addNeighbor(gardens[path[0] - 1])
        }
        for (garden in gardens) {
            if (garden.color == -1)
                garden.color = (colors - garden.neighbors.map { it.color } - garden.color).first()
        }
        return gardens.map { it.color }.toIntArray()
    }

    class Garden(var color: Int = -1, val neighbors: MutableSet<Garden> = mutableSetOf()) {
        fun addNeighbor(garden: Garden) {
            neighbors.add(garden)
        }
    }
}

fun main() {
    val v1 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 1)
    )
    val v2 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 4)
    )
    val v3 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(4, 1),
        intArrayOf(1, 3),
        intArrayOf(2, 4)
    )
    Solution().gardenNoAdj(3, v1).forEach { print("$it ") }
    println()
    Solution().gardenNoAdj(4, v2).forEach { print("$it ") }
    println()
    Solution().gardenNoAdj(4, v3).forEach { print("$it ") }
}