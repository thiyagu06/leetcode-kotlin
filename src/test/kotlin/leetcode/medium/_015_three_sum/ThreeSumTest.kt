package leetcode.medium._015_three_sum

import org.junit.Test
import kotlin.test.assertEquals

class ThreeSumTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()
    private val solution4 = SolutionFour()
    private val bigInput = IntArray(3000)

    @Test
    fun threeSum() {
        assertEquals(
            setOf(listOf(-1, 0, 1), listOf(-1, -1, 2)),
            solution.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)).toSet()
        )

        assertEquals(
            listOf(listOf(0, 0, 0)),
            solution.threeSum(intArrayOf(0, 0, 0))
        )

        assertEquals(
            listOf(listOf(-4, 1, 3)),
            solution.threeSum(intArrayOf(1, 1, 1, 1, 3, 3, 3, 3, -4))
        )

        assertEquals(
            listOf(listOf(0, 0, 0)),
            solution.threeSum(intArrayOf(4, 4, 3, -5, 0, 0, 0, -2, 3, -5, -5, 0))
        )

        assertEquals(
            listOf(listOf(0, 0, 0)),
            solution.threeSum(bigInput)
        )
    }

    @Test
    fun threeSum2() {
        assertEquals(
            setOf(listOf(-1, 0, 1), listOf(-1, -1, 2)),
            solution2.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)).toSet()
        )

        assertEquals(
            listOf(listOf(0, 0, 0)),
            solution2.threeSum(intArrayOf(0, 0, 0))
        )

        assertEquals(
            listOf(listOf(-4, 1, 3)),
            solution2.threeSum(intArrayOf(1, 1, 1, 1, 3, 3, 3, 3, -4))
        )

        assertEquals(
            listOf(listOf(0, 0, 0)),
            solution2.threeSum(intArrayOf(4, 4, 3, -5, 0, 0, 0, -2, 3, -5, -5, 0))
        )

        assertEquals(
            listOf(listOf(0, 0, 0)),
            solution2.threeSum(bigInput)
        )
    }

    @Test
    fun threeSum3() {
        assertEquals(
            setOf(listOf(-1, 0, 1), listOf(-1, -1, 2)),
            solution3.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)).toSet()
        )

        assertEquals(
            listOf(listOf(0, 0, 0)),
            solution3.threeSum(intArrayOf(0, 0, 0))
        )

        assertEquals(
            listOf(listOf(-4, 1, 3)),
            solution3.threeSum(intArrayOf(1, 1, 1, 1, 3, 3, 3, 3, -4))
        )

        assertEquals(
            listOf(listOf(0, 0, 0)),
            solution3.threeSum(intArrayOf(4, 4, 3, -5, 0, 0, 0, -2, 3, -5, -5, 0))
        )

        assertEquals(
            listOf(listOf(0, 0, 0)),
            solution3.threeSum(bigInput)
        )
    }

    @Test
    fun threeSum4() {
        assertEquals(
            setOf(listOf(-1, 0, 1), listOf(-1, -1, 2)),
            solution4.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)).toSet()
        )

        assertEquals(
            listOf(listOf(0, 0, 0)),
            solution4.threeSum(intArrayOf(0, 0, 0))
        )

        assertEquals(
            listOf(listOf(-4, 1, 3)),
            solution4.threeSum(intArrayOf(1, 1, 1, 1, 3, 3, 3, 3, -4))
        )

        assertEquals(
            listOf(listOf(0, 0, 0)),
            solution4.threeSum(intArrayOf(4, 4, 3, -5, 0, 0, 0, -2, 3, -5, -5, 0))
        )

        assertEquals(
            listOf(listOf(0, 0, 0)),
            solution4.threeSum(bigInput)
        )
    }
}