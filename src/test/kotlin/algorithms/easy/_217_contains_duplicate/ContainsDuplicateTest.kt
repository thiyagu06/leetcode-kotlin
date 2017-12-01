package algorithms.easy._217_contains_duplicate

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.system.measureTimeMillis

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
        val ms1 = measureTimeMillis {
            assertFalse(solution1.containsDuplicate(intArrayOf()))
            assertFalse(solution1.containsDuplicate(intArrayOf(1)))
            assertFalse(solution1.containsDuplicate(intArrayOf(1, 2)))
            assertFalse(solution1.containsDuplicate(intArrayOf(1, 3, 4, 2)))
            assertTrue(solution1.containsDuplicate(intArrayOf(1, 1)))
            assertTrue(solution1.containsDuplicate(intArrayOf(1, 2, 1)))
        }
        println("Solution 1: $ms1 ms\n")

        val ms2 = measureTimeMillis {
            assertFalse(solution2.containsDuplicate(intArrayOf()))
            assertFalse(solution2.containsDuplicate(intArrayOf(1)))
            assertFalse(solution2.containsDuplicate(intArrayOf(1, 2)))
            assertFalse(solution2.containsDuplicate(intArrayOf(1, 3, 4, 2)))
            assertTrue(solution2.containsDuplicate(intArrayOf(1, 1)))
            assertTrue(solution2.containsDuplicate(intArrayOf(1, 2, 1)))
        }

        println("Solution 2: $ms2 ms\n")
    }

    @Test
    fun bigInputDuplicateAtStart() {
        val ms1 = measureTimeMillis { assertTrue(solution1.containsDuplicate(bigInputStartDuplicate)) }
        println("Solution 1: $ms1 ms\n")

        val ms2 = measureTimeMillis { assertTrue(solution2.containsDuplicate(bigInputStartDuplicate)) }
        println("Solution 2: $ms2 ms\n")
    }

    @Test
    fun bigInputDuplicate() {
        val ms1 = measureTimeMillis { assertFalse(solution1.containsDuplicate(bigInput)) }
        println("Solution 1: $ms1 ms\n")

        val ms2 = measureTimeMillis { assertFalse(solution2.containsDuplicate(bigInput)) }
        println("Solution 2: $ms2 ms\n")
    }

}