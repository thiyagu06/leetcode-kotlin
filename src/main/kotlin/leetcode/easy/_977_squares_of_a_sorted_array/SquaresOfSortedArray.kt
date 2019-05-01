package leetcode.easy._977_squares_of_a_sorted_array

/**
 * 977 - https://leetcode.com/problems/squares-of-a-sorted-array/
 */
class Solution {
    fun sortedSquares(A: IntArray): IntArray = A.map { it * it }.sorted().toIntArray()
}

class SolutionTwo {
    /**
     * With constant space
     * Time: O(n log n)
     * Space: O(1)
     */
    fun sortedSquares(A: IntArray): IntArray {
        for (i in A.indices) A[i] = A[i] * A[i]
        A.sort()
        return A
    }
}

class SolutionThree {
    /**
     * Two-pointer merging technique
     * Time: O(n)
     * Space: O(n)
     */
    fun sortedSquares(A: IntArray): IntArray {
        if (A.isEmpty()) return IntArray(0)

        val squares = IntArray(A.size)

        // find first non-negative
        var r = 0
        while (r <= A.lastIndex && A[r] < 0) r++

        var l = r - 1
        var sqIndex = 0

        // Merge in negatives (l, moving in reverse order) & non-negatives (r, increasing)
        while (l >= 0 && r <= A.lastIndex) {
            squares[sqIndex++] = when {
                A[l] * A[l] <= A[r] * A[r] -> A[l] * A[l--]
                else -> A[r] * A[r++]
            }
        }

        // Copy remaining
        while (l >= 0) squares[sqIndex++] = A[l] * A[l--]
        while (r <= A.lastIndex) squares[sqIndex++] = A[r] * A[r++]

        return squares
    }
}