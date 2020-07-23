package com.company.minimal_cut

import java.io.File
import kotlin.math.min

class Solution(private val fileName: String) {
    fun process(): Int {
        val values = Reader().read(fileName)
        var result = Int.MAX_VALUE
        repeat(100) {
            val vertexes = mutableSetOf<Int>()
            val edges = mutableListOf<Edge>()
            for (v in values) {
                vertexes.add(v[0])
                for (i in 1 until v.size) {
                    edges.add(Edge(v[0], v[i]))
                }
            }
            result = min(result, doProcess(vertexes, edges))
        }
        return result
    }

    private fun doProcess(vertexes: MutableSet<Int>, edges: MutableList<Edge>): Int {
        while (vertexes.size > 2) {
            edges.removeAll { it.tail == it.head }
            val edge = edges.random()
            val vertexToDelete = edge.head
            vertexes.remove(vertexToDelete)
            for (e in edges) {
                if (e.tail == vertexToDelete) {
                    e.tail = edge.tail
                } else if (e.head == vertexToDelete) {
                    e.head = edge.tail
                }
            }
        }
        edges.removeAll { it.tail == it.head }
        return edges.size / 2
    }
}

data class Edge(var head: Int, var tail: Int)

fun main() {
    val s = Solution("/Users/sergiytolokunskyy/dev/leetcode/src/com/company/minimal_cut/KargerMinCut.txt")
    println(s.process())
}

val String.intValue
    get() = Integer.parseInt(this)

class Reader {
    fun read(fileName: String): List<IntArray> =
        File(fileName)
            .readLines()
            .map { s ->
                s.split("\\s+".toRegex())
                    .filter { it.isNotEmpty() }
                    .map { it.intValue }
                    .toIntArray()
            }
}

