package leetcode.medium._287_find_the_duplicate_number

import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore

class FindTheDuplicateNumberTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    @Test
    fun findDuplicate() {
        assertEquals(2, solution.findDuplicate(intArrayOf(1, 3, 4, 2, 2)))
        assertEquals(3, solution.findDuplicate(intArrayOf(3, 1, 3, 4, 2)))
        assertEquals(5, solution.findDuplicate(intArrayOf(5, 1, 4, 3, 2, 5)))
        assertEquals(6, solution.findDuplicate(intArrayOf(6, 1, 4, 3, 2, 6, 5)))
        assertEquals(2, solution.findDuplicate(intArrayOf(2, 2, 2)))
        assertEquals(2, solution.findDuplicate(intArrayOf(2, 2, 2, 2)))
        assertEquals(2, solution.findDuplicate(intArrayOf(2, 2, 2, 2, 2)))
        assertEquals(2, solution.findDuplicate(intArrayOf(2, 2, 2, 2, 2, 2)))
    }

    @Test
    fun findDuplicate2() {
        assertEquals(2, solution2.findDuplicate(intArrayOf(1, 3, 4, 2, 2)))
        assertEquals(3, solution2.findDuplicate(intArrayOf(3, 1, 3, 4, 2)))
        assertEquals(5, solution2.findDuplicate(intArrayOf(5, 1, 4, 3, 2, 5)))
        assertEquals(6, solution2.findDuplicate(intArrayOf(6, 1, 4, 3, 2, 6, 5)))
        assertEquals(2, solution2.findDuplicate(intArrayOf(2, 2, 2)))
        assertEquals(2, solution2.findDuplicate(intArrayOf(2, 2, 2, 2)))
        assertEquals(2, solution2.findDuplicate(intArrayOf(2, 2, 2, 2, 2)))
        assertEquals(2, solution2.findDuplicate(intArrayOf(2, 2, 2, 2, 2, 2)))
    }

    @Ignore // Unimplemented
    @Test
    fun findDuplicate3() {
        assertEquals(2, solution3.findDuplicate(intArrayOf(1, 3, 4, 2, 2)))
        assertEquals(3, solution3.findDuplicate(intArrayOf(3, 1, 3, 4, 2)))
        assertEquals(5, solution3.findDuplicate(intArrayOf(5, 1, 4, 3, 2, 5)))
        assertEquals(6, solution3.findDuplicate(intArrayOf(6, 1, 4, 3, 2, 6, 5)))
        assertEquals(2, solution3.findDuplicate(intArrayOf(2, 2, 2)))
        assertEquals(2, solution3.findDuplicate(intArrayOf(2, 2, 2, 2)))
        assertEquals(2, solution3.findDuplicate(intArrayOf(2, 2, 2, 2, 2)))
        assertEquals(2, solution3.findDuplicate(intArrayOf(2, 2, 2, 2, 2, 2)))
    }
}