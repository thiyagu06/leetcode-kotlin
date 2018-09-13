package leetcode.medium._215_kth_largest_element_in_array

import org.junit.Test

import org.junit.Assert.*

class FindKthLargestTest {

    private val solution = Solution()
    private val solutionTwo = SolutionTwo()
    private val solutionThree = SolutionThree()

    @Test
    fun findKthLargest() {
        assertEquals(5, solution.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
        assertEquals(4, solution.findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
    }

    @Test
    fun findKthLargest2() {
        assertEquals(5, solutionTwo.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
        assertEquals(4, solutionTwo.findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
    }

    @Test
    fun findKthLargest3() {
        assertEquals(5, solutionThree.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
        assertEquals(4, solutionThree.findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
    }
}