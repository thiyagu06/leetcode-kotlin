package leetcode.easy._217_contains_duplicate

import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.Test

class ContainsDuplicateTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    private val bigInput = IntArray(1000) { i -> i }
    private val bigInputStartDuplicate = intArrayOf(0) + IntArray(1000) { i -> i }

    @Test
    fun containsDuplicate() {
        assertFalse(solution.containsDuplicate(intArrayOf()))
        assertFalse(solution.containsDuplicate(intArrayOf(1)))
        assertFalse(solution.containsDuplicate(intArrayOf(1, 2)))
        assertFalse(solution.containsDuplicate(intArrayOf(1, 3, 4, 2)))
        assertTrue(solution.containsDuplicate(intArrayOf(1, 1)))
        assertTrue(solution.containsDuplicate(intArrayOf(1, 2, 1)))
        assertTrue(solution.containsDuplicate(intArrayOf(1, 2, 3, 1)))
        assertTrue(solution.containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
        assertTrue(solution.containsDuplicate(bigInputStartDuplicate))
        assertFalse(solution.containsDuplicate(bigInput))
    }

    @Test
    fun containsDuplicate2() {
        assertFalse(solution2.containsDuplicate(intArrayOf()))
        assertFalse(solution2.containsDuplicate(intArrayOf(1)))
        assertFalse(solution2.containsDuplicate(intArrayOf(1, 2)))
        assertFalse(solution2.containsDuplicate(intArrayOf(1, 3, 4, 2)))
        assertTrue(solution2.containsDuplicate(intArrayOf(1, 1)))
        assertTrue(solution2.containsDuplicate(intArrayOf(1, 2, 1)))
        assertTrue(solution2.containsDuplicate(intArrayOf(1, 2, 3, 1)))
        assertTrue(solution2.containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
        assertTrue(solution2.containsDuplicate(bigInputStartDuplicate))
        assertFalse(solution2.containsDuplicate(bigInput))
    }

    @Test
    fun containsDuplicate3() {
        assertFalse(solution3.containsDuplicate(intArrayOf()))
        assertFalse(solution3.containsDuplicate(intArrayOf(1)))
        assertFalse(solution3.containsDuplicate(intArrayOf(1, 2)))
        assertFalse(solution3.containsDuplicate(intArrayOf(1, 3, 4, 2)))
        assertTrue(solution3.containsDuplicate(intArrayOf(1, 1)))
        assertTrue(solution3.containsDuplicate(intArrayOf(1, 2, 1)))
        assertTrue(solution3.containsDuplicate(intArrayOf(1, 2, 3, 1)))
        assertTrue(solution3.containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
        assertTrue(solution3.containsDuplicate(bigInputStartDuplicate))
        assertFalse(solution3.containsDuplicate(bigInput))
    }
}
