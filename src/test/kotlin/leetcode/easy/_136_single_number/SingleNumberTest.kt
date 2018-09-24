package leetcode.easy._136_single_number

import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore

class SingleNumberTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun singleNumber() {
        assertEquals(1, solution.singleNumber(intArrayOf(1)))
        assertEquals(1, solution.singleNumber(intArrayOf(1, 2, 2, 3, 3)))
        assertEquals(1, solution.singleNumber(intArrayOf(3, 1, 3, 2, 2)))
    }

    @Test
    fun singleNumber2() {
        assertEquals(1, solution2.singleNumber(intArrayOf(1)))
        assertEquals(1, solution2.singleNumber(intArrayOf(1, 2, 2, 3, 3)))
        assertEquals(1, solution2.singleNumber(intArrayOf(3, 1, 3, 2, 2)))
    }
}