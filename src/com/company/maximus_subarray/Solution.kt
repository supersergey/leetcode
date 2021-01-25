package com.company.maximus_subarray

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var bestSum = Integer.MIN_VALUE
        var currentSum = 0
        for(x in nums) {
            if (currentSum<0) {
                currentSum = x
            }
            else {
                currentSum+=x
            }
            if (currentSum > bestSum)
                bestSum = currentSum
        }
        return bestSum
    }
}

fun main() {
    println(Solution().maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
    println(Solution().maxSubArray(intArrayOf(1)))
    println(Solution().maxSubArray(intArrayOf(1, 2)))
    println(Solution().maxSubArray(intArrayOf(1,2,-1,-2,2,1,-2,1,4,-5,4)))
    println(Solution().maxSubArray(intArrayOf(-1)))
}

internal object Util {
    // Function to find contiguous sub-array with the largest sum
// in given set of integers
    fun kadane(A: IntArray): Int { // stores maximum sum sub-array found so far
        var maxSoFar = 0
        var maxEndingHere = 0
        for (i in A) { // update maximum sum of sub-array "ending" at index i (by adding
// current element to maximum sum ending at previous index i-1)
            maxEndingHere = maxEndingHere + i
            // if maximum sum is negative, set it to 0 (which represents
// an empty sub-array)
            maxEndingHere = Integer.max(maxEndingHere, 0)
            // update result if current sub-array sum is found to be greater
            maxSoFar = Integer.max(maxSoFar, maxEndingHere)
        }
        return maxSoFar
    }

    // com.company.rotten_oranges.main function
    @JvmStatic
    fun main(args: Array<String>) {
        val A = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
        println("The sum of contiguous sub-array with the " +
            "largest sum is " + kadane(A))
    }
}