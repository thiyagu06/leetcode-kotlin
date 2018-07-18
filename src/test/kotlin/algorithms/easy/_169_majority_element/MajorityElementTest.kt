package algorithms.easy._169_majority_element

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.system.measureTimeMillis

class MajorityElementTest {

    private val solution = Solution()
    private val imperative = ImperativeSolution()
    private val bigInput = IntArray(1000) { i -> if (i % 100 == 0) 2 else 1 }

    @Test
    fun majorityElement() {
        val ms = measureTimeMillis {
            assertEquals(1, solution.majorityElement(intArrayOf(1)))
            assertEquals(1, solution.majorityElement(intArrayOf(1, 1)))
            assertEquals(1, solution.majorityElement(intArrayOf(1, 3, 1)))
            assertEquals(1, solution.majorityElement(intArrayOf(1, 3, 1, 1)))
            assertEquals(1, solution.majorityElement(bigInput))
        }
        println("$ms ms")
    }

    @Test
    fun majorityElementImperative() {
        val ms = measureTimeMillis {
            assertEquals(1, imperative.majorityElement(intArrayOf(1)))
            assertEquals(1, imperative.majorityElement(intArrayOf(1, 1)))
            assertEquals(1, imperative.majorityElement(intArrayOf(1, 3, 1)))
            assertEquals(1, imperative.majorityElement(intArrayOf(1, 3, 1, 1)))
            assertEquals(1, imperative.majorityElement(bigInput))
        }
        println("$ms ms")
    }

}
