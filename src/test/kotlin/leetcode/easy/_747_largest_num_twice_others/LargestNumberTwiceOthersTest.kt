package leetcode.easy._747_largest_num_twice_others

import kotlin.test.assertEquals
import org.junit.Test

class LargestNumberTwiceOthersTest {

    private val solution = Solution()
    private val solutionTwo = SolutionTwo()
    private val solutionThree = SolutionThree()

    @Test
    fun dominantIndex() {
        assertEquals(1, solution.dominantIndex(intArrayOf(3, 6, 1, 0)))
        assertEquals(-1, solution.dominantIndex(intArrayOf(1, 2, 3, 4)))
        assertEquals(0, solution.dominantIndex(intArrayOf(1)))
        assertEquals(1, solution.dominantIndex(intArrayOf(1, 2)))
        assertEquals(-1, solution.dominantIndex(intArrayOf(2, 3)))
        assertEquals(3, solution.dominantIndex(intArrayOf(0, 0, 0, 1)))
        assertEquals(0, solution.dominantIndex(intArrayOf(7, 2, 3, 3, 1)))
    }

    @Test
    fun dominantIndex2() {
        assertEquals(1, solutionTwo.dominantIndex(intArrayOf(3, 6, 1, 0)))
        assertEquals(-1, solutionTwo.dominantIndex(intArrayOf(1, 2, 3, 4)))
        assertEquals(0, solutionTwo.dominantIndex(intArrayOf(1)))
        assertEquals(1, solutionTwo.dominantIndex(intArrayOf(1, 2)))
        assertEquals(-1, solutionTwo.dominantIndex(intArrayOf(2, 3)))
        assertEquals(3, solutionTwo.dominantIndex(intArrayOf(0, 0, 0, 1)))
        assertEquals(0, solutionTwo.dominantIndex(intArrayOf(7, 2, 3, 3, 1)))
    }

    @Test
    fun dominantIndex3() {
        assertEquals(1, solutionThree.dominantIndex(intArrayOf(3, 6, 1, 0)))
        assertEquals(-1, solutionThree.dominantIndex(intArrayOf(1, 2, 3, 4)))
        assertEquals(0, solutionThree.dominantIndex(intArrayOf(1)))
        assertEquals(1, solutionThree.dominantIndex(intArrayOf(1, 2)))
        assertEquals(-1, solutionThree.dominantIndex(intArrayOf(2, 3)))
        assertEquals(3, solutionThree.dominantIndex(intArrayOf(0, 0, 0, 1)))
        assertEquals(0, solutionThree.dominantIndex(intArrayOf(7, 2, 3, 3, 1)))
    }
}