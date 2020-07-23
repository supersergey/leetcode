import kotlin.math.min

class Solution {
    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        for (y in matrix.indices) {
            for (x in matrix[y].indices) {
                if (matrix[y][x] != 0) {
                    matrix[y][x] = Int.MAX_VALUE - 20000
                }
            }
        }
        for (y in matrix.indices) {
            for (x in matrix[y].indices) {
                if (matrix[y][x] != 0) {
                    if (y < matrix.lastIndex)
                        matrix[y][x] = min(matrix[y][x], matrix[y + 1][x] + 1)
                    if (x < matrix[y].lastIndex)
                        matrix[y][x] = min(matrix[y][x], matrix[y][x + 1] + 1)
                    if (y > 0)
                        matrix[y][x] = min(matrix[y][x], matrix[y - 1][x] + 1)
                    if (x > 0)
                        matrix[y][x] = min(matrix[y][x], matrix[y][x - 1] + 1)
                }
            }
        }

        for (y in matrix.lastIndex downTo 0) {
            for (x in matrix[y].lastIndex downTo 0) {
                if (matrix[y][x] != 0) {
                    if (y > 0)
                        matrix[y][x] = min(matrix[y][x], matrix[y - 1][x] + 1)
                    if (x > 0)
                        matrix[y][x] = min(matrix[y][x], matrix[y][x - 1] + 1)
                    if (y < matrix.lastIndex)
                        matrix[y][x] = min(matrix[y][x], matrix[y + 1][x] + 1)
                    if (x < matrix[y].lastIndex)
                        matrix[y][x] = min(matrix[y][x], matrix[y][x + 1] + 1)
                }
            }
        }
        return matrix
    }
}

fun main() {
//    Solution().updateMatrix(
//        arrayOf(
//            intArrayOf(0, 0, 0),
//            intArrayOf(0, 1, 0),
//            intArrayOf(1, 1, 1)
//        )
//    ).forEach { println(it.joinToString(" ")) }

    Solution().updateMatrix(
        arrayOf(
            intArrayOf(1, 0, 1, 1, 0, 0, 1, 0, 0, 1),
            intArrayOf(0, 1, 1, 0, 1, 0, 1, 0, 1, 1),
            intArrayOf(0, 0, 1, 0, 1, 0, 0, 1, 0, 0),
            intArrayOf(1, 0, 1, 0, 1, 1, 1, 1, 1, 1),
            intArrayOf(0, 1, 0, 1, 1, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 1, 0, 1, 1, 1, 0, 1, 0),
            intArrayOf(0, 1, 0, 1, 0, 1, 0, 0, 1, 1),
            intArrayOf(1, 0, 0, 0, 1, 1, 1, 1, 0, 1),
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 0, 1, 0),
            intArrayOf(1, 1, 1, 1, 0, 1, 0, 0, 1, 1)
        )
    ).forEach { println(it.joinToString(" ")) }

}