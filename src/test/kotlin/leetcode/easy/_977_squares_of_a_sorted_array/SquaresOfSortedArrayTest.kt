package leetcode.easy._977_squares_of_a_sorted_array

import org.junit.Test

import org.junit.Assert.*

class SquaresOfSortedArrayTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    @Test
    fun sortedSquares() {
        assertArrayEquals(intArrayOf(0, 1, 9, 16, 100), solution.sortedSquares(intArrayOf(-4, -1, 0, 3, 10)))
        assertArrayEquals(intArrayOf(4, 9, 9, 49, 121), solution.sortedSquares(intArrayOf(-7, -3, 2, 3, 11)))
    }

    @Test
    fun sortedSquares2() {
        assertArrayEquals(intArrayOf(0, 1, 9, 16, 100), solution2.sortedSquares(intArrayOf(-4, -1, 0, 3, 10)))
        assertArrayEquals(intArrayOf(4, 9, 9, 49, 121), solution2.sortedSquares(intArrayOf(-7, -3, 2, 3, 11)))
    }

    @Test
    fun sortedSquares3() {
        assertArrayEquals(intArrayOf(0, 1, 9, 16, 100), solution3.sortedSquares(intArrayOf(-4, -1, 0, 3, 10)))
        assertArrayEquals(intArrayOf(4, 9, 9, 49, 121), solution3.sortedSquares(intArrayOf(-7, -3, 2, 3, 11)))
    }
}