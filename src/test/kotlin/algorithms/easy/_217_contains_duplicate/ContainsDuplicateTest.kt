package algorithms.easy._217_contains_duplicate

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.system.measureNanoTime

/**
 * @author nrojiani
 * @date 11/13/17
 */
class ContainsDuplicateTest {

    private val solution1 = Solution()
    private val solution2 = SolutionTwo()
    private val bigInput = IntArray(1000, { i -> i })
    private val bigInputStartDuplicate = intArrayOf(0) + IntArray(1000, { i -> i })

    @Test
    fun containsDuplicate() {
        assertFalse(solution1.containsDuplicate(intArrayOf()))
        assertFalse(solution1.containsDuplicate(intArrayOf(1)))
        assertFalse(solution1.containsDuplicate(intArrayOf(1, 2)))
        assertFalse(solution1.containsDuplicate(intArrayOf(1, 3, 4, 2)))
        assertTrue(solution1.containsDuplicate(intArrayOf(1, 1)))
        assertTrue(solution1.containsDuplicate(intArrayOf(1, 2, 1)))
    }

    @Test
    fun containsDuplicate2() {
        assertFalse(solution2.containsDuplicate(intArrayOf()))
        assertFalse(solution2.containsDuplicate(intArrayOf(1)))
        assertFalse(solution2.containsDuplicate(intArrayOf(1, 2)))
        assertFalse(solution2.containsDuplicate(intArrayOf(1, 3, 4, 2)))
        assertTrue(solution2.containsDuplicate(intArrayOf(1, 1)))
        assertTrue(solution2.containsDuplicate(intArrayOf(1, 2, 1)))
    }

    @Test
    fun bigInputDuplicateAtStart() {
        assertTrue(solution1.containsDuplicate(bigInputStartDuplicate))
        val ns = measureNanoTime { solution1.containsDuplicate(bigInputStartDuplicate) }
        println("${ns / 1000000} ms")
    }

    @Test
    fun bigInputDuplicateAtStart2() {
        assertTrue(solution2.containsDuplicate(bigInputStartDuplicate))
        val ns = measureNanoTime { solution2.containsDuplicate(bigInputStartDuplicate) }
        println("${ns / 1000000} ms")
    }

    @Test
    fun bigInputDuplicate() {
        val ns = measureNanoTime { solution1.containsDuplicate(bigInput) }
        println("${ns / 1000000} ms")
        assertFalse(solution1.containsDuplicate(bigInput))
    }

    @Test
    fun bigInputDuplicate2() {
        val ns = measureNanoTime { solution2.containsDuplicate(bigInput) }
        println("${ns / 1000000} ms")
        assertFalse(solution2.containsDuplicate(bigInput))
    }
}