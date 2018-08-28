package algorithms.easy._217_contains_duplicate

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ContainsDuplicateTest {

    private val solution1 = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()
    private val imperativeSolution = ImperativeSolution()

    private val bigInput = IntArray(1000) { i -> i }
    private val bigInputStartDuplicate = intArrayOf(0) + IntArray(1000) { i -> i }

    @Test
    fun containsDuplicate() {
        assertFalse(solution1.containsDuplicate(intArrayOf()))
        assertFalse(solution1.containsDuplicate(intArrayOf(1)))
        assertFalse(solution1.containsDuplicate(intArrayOf(1, 2)))
        assertFalse(solution1.containsDuplicate(intArrayOf(1, 3, 4, 2)))
        assertTrue(solution1.containsDuplicate(intArrayOf(1, 1)))
        assertTrue(solution1.containsDuplicate(intArrayOf(1, 2, 1)))
        assertTrue(solution1.containsDuplicate(intArrayOf(1, 2, 3, 1)))
        assertTrue(solution1.containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))

        assertFalse(solution3.containsDuplicate(intArrayOf()))
        assertFalse(solution3.containsDuplicate(intArrayOf(1)))
        assertFalse(solution3.containsDuplicate(intArrayOf(1, 2)))
        assertFalse(solution3.containsDuplicate(intArrayOf(1, 3, 4, 2)))
        assertTrue(solution3.containsDuplicate(intArrayOf(1, 1)))
        assertTrue(solution3.containsDuplicate(intArrayOf(1, 2, 1)))
        assertTrue(solution3.containsDuplicate(intArrayOf(1, 2, 3, 1)))
        assertTrue(solution3.containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))

        assertFalse(imperativeSolution.containsDuplicate(intArrayOf()))
        assertFalse(imperativeSolution.containsDuplicate(intArrayOf(1)))
        assertFalse(imperativeSolution.containsDuplicate(intArrayOf(1, 2)))
        assertFalse(imperativeSolution.containsDuplicate(intArrayOf(1, 3, 4, 2)))
        assertTrue(imperativeSolution.containsDuplicate(intArrayOf(1, 1)))
        assertTrue(imperativeSolution.containsDuplicate(intArrayOf(1, 2, 1)))
        assertTrue(imperativeSolution.containsDuplicate(intArrayOf(1, 2, 3, 1)))
        assertTrue(imperativeSolution.containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
    }

    @Test
    fun bigInputDuplicateAtStart() {
        assertTrue(solution1.containsDuplicate(bigInputStartDuplicate))
        assertTrue(solution2.containsDuplicate(bigInputStartDuplicate))
        assertTrue(imperativeSolution.containsDuplicate(bigInputStartDuplicate))
    }

    @Test
    fun bigInputDuplicate() {
        assertFalse(solution1.containsDuplicate(bigInput))
        assertFalse(solution2.containsDuplicate(bigInput))
        assertFalse(imperativeSolution.containsDuplicate(bigInput))
    }

}
