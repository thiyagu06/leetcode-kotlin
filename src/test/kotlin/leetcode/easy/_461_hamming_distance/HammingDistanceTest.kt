package leetcode.easy._461_hamming_distance

import org.junit.Test

import kotlin.test.assertEquals

class HammingDistanceTest {

    private val solution = Solution()
    private val solutionTwo = SolutionTwo()

    @Test
    fun hammingDistance() {
        assertEquals(2, solution.hammingDistance(1, 4))
        assertEquals(3, solution.hammingDistance(0, 7))
        assertEquals(4, solution.hammingDistance(0, 15))
    }

    @Test
    fun hammingDistance2() {
        assertEquals(2, solutionTwo.hammingDistance(1, 4))
        assertEquals(3, solutionTwo.hammingDistance(0, 7))
        assertEquals(4, solutionTwo.hammingDistance(0, 15))
    }
}