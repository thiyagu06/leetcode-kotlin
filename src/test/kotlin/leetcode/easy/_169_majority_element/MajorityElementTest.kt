package leetcode.easy._169_majority_element

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.system.measureTimeMillis

class MajorityElementTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()
    private val solution4 = SolutionFour()
    private val imperative = ImperativeSolution()
    private val bigInput = IntArray(1000) { i -> if (i % 100 == 0) 2 else 1 }

    @Test
    fun majorityElement() {
        val ms = measureTimeMillis {
            assertEquals(1, solution.majorityElement(intArrayOf(1)))
            assertEquals(1, solution.majorityElement(intArrayOf(1, 1)))
            assertEquals(1, solution.majorityElement(intArrayOf(1, 3, 1)))
            assertEquals(1, solution.majorityElement(intArrayOf(1, 3, 1, 1)))
            assertEquals(3, solution.majorityElement(intArrayOf(1, 2, 3, 3, 3, 3, 4)))
            assertEquals(1, solution.majorityElement(bigInput))
        }
        println("Solution: $ms ms")
    }

    @Test
    fun majorityElementAlt1() {
        val ms = measureTimeMillis {
            assertEquals(1, solution2.majorityElement(intArrayOf(1)))
            assertEquals(1, solution2.majorityElement(intArrayOf(1, 1)))
            assertEquals(1, solution2.majorityElement(intArrayOf(1, 3, 1)))
            assertEquals(1, solution2.majorityElement(intArrayOf(1, 3, 1, 1)))
            assertEquals(3, solution2.majorityElement(intArrayOf(1, 2, 3, 3, 3, 3, 4)))
            assertEquals(1, solution2.majorityElement(bigInput))
        }
        println("Alt 1: $ms ms")
    }

    @Test
    fun majorityElementAlt2() {
        val ms = measureTimeMillis {
            assertEquals(1, solution3.majorityElement(intArrayOf(1)))
            assertEquals(1, solution3.majorityElement(intArrayOf(1, 1)))
            assertEquals(1, solution3.majorityElement(intArrayOf(1, 3, 1)))
            assertEquals(1, solution3.majorityElement(intArrayOf(1, 3, 1, 1)))
            assertEquals(3, solution3.majorityElement(intArrayOf(1, 2, 3, 3, 3, 3, 4)))
            assertEquals(1, solution3.majorityElement(bigInput))
        }
        println("Alt 2: $ms ms")
    }

    @Test
    fun majorityElementAlt3() {
        val ms = measureTimeMillis {
            assertEquals(1, solution4.majorityElement(intArrayOf(1)))
            assertEquals(1, solution4.majorityElement(intArrayOf(1, 1)))
            assertEquals(1, solution4.majorityElement(intArrayOf(1, 3, 1)))
            assertEquals(1, solution4.majorityElement(intArrayOf(1, 3, 1, 1)))
            assertEquals(3, solution4.majorityElement(intArrayOf(1, 2, 3, 3, 3, 3, 4)))
            assertEquals(1, solution4.majorityElement(bigInput))
        }
        println("Alt 3: $ms ms")
    }


    @Test
    fun majorityElementImperative() {
        val ms = measureTimeMillis {
            assertEquals(1, imperative.majorityElement(intArrayOf(1)))
            assertEquals(1, imperative.majorityElement(intArrayOf(1, 1)))
            assertEquals(1, imperative.majorityElement(intArrayOf(1, 3, 1)))
            assertEquals(1, imperative.majorityElement(intArrayOf(1, 3, 1, 1)))
            assertEquals(3, solution.majorityElement(intArrayOf(1, 2, 3, 3, 3, 3, 4)))
            assertEquals(1, imperative.majorityElement(bigInput))
        }
        println("Imperative: $ms ms")
    }

}
