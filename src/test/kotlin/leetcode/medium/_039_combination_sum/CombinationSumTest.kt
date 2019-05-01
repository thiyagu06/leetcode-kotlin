package leetcode.medium._039_combination_sum

import extensions.math.roundedToNDecimalPlaces
import kotlin.test.assertEquals
import org.junit.Test
import kotlin.system.measureTimeMillis

class CombinationSumTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    @Test
    fun combinationSum() {
        val times = arrayListOf<Long>()
        repeat(30) {
            val ms = measureTimeMillis {
                val expected1 = listOf(listOf(7), listOf(2, 2, 3))
                val actual1 = solution.combinationSum(intArrayOf(2, 3, 6, 7), 7)
                assertEquals(expected1.size, actual1.size)
                assertEquals(expected1.toSet(), actual1.toSet())

                val expected2 = listOf(listOf(1, 1, 1), listOf(1, 2), listOf(3))
                val actual2 = solution.combinationSum(intArrayOf(1, 2, 3), 3)
                assertEquals(expected2.size, actual2.size)
                assertEquals(expected2.toSet(), actual2.toSet())

                val expected3 = listOf(listOf(2, 2, 2, 2), listOf(2, 3, 3), listOf(3, 5))
                val actual3 = solution.combinationSum(intArrayOf(2, 3, 5), 8)
                assertEquals(expected3.size, actual3.size)
                assertEquals(expected3.toSet(), actual3.toSet())
            }
            times += ms
        }
        val adjustedTimes = times.drop(5)
        println("adjustedTimes for Solution 1: $adjustedTimes")
        println("average run: ${adjustedTimes.average().roundedToNDecimalPlaces(2)}")
    }

    @Test
    fun combinationSum2() {
        val times = arrayListOf<Long>()
        repeat(30) {
            val ms = measureTimeMillis {
                val expected1 = listOf(listOf(7), listOf(2, 2, 3))
                val actual1 = solution2.combinationSum(intArrayOf(2, 3, 6, 7), 7)
                assertEquals(expected1.size, actual1.size)
                assertEquals(expected1.toSet(), actual1.toSet())

                val expected2 = listOf(listOf(1, 1, 1), listOf(1, 2), listOf(3))
                val actual2 = solution2.combinationSum(intArrayOf(1, 2, 3), 3)
                assertEquals(expected2.size, actual2.size)
                assertEquals(expected2.toSet(), actual2.toSet())

                val expected3 = listOf(listOf(2, 2, 2, 2), listOf(2, 3, 3), listOf(3, 5))
                val actual3 = solution2.combinationSum(intArrayOf(2, 3, 5), 8)
                assertEquals(expected3.size, actual3.size)
                assertEquals(expected3.toSet(), actual3.toSet())
            }
            times += ms
        }
        val adjustedTimes = times.drop(5)
        println("adjustedTimes for Solution 2: $adjustedTimes")
        println("average run: ${adjustedTimes.average().roundedToNDecimalPlaces(2)}")
    }

    @Test
    fun combinationSum3() {
        val times = arrayListOf<Long>()
        repeat(30) {
            val ms = measureTimeMillis {
                val expected1 = listOf(listOf(7), listOf(2, 2, 3))
                val actual1 = solution3.combinationSum(intArrayOf(2, 3, 6, 7), 7)
                assertEquals(expected1.size, actual1.size)
                assertEquals(expected1.toSet(), actual1.toSet())

                val expected2 = listOf(listOf(1, 1, 1), listOf(1, 2), listOf(3))
                val actual2 = solution3.combinationSum(intArrayOf(1, 2, 3), 3)
                assertEquals(expected2.size, actual2.size)
                assertEquals(expected2.toSet(), actual2.toSet())

                val expected3 = listOf(listOf(2, 2, 2, 2), listOf(2, 3, 3), listOf(3, 5))
                val actual3 = solution3.combinationSum(intArrayOf(2, 3, 5), 8)
                assertEquals(expected3.size, actual3.size)
                assertEquals(expected3.toSet(), actual3.toSet())
            }
            times += ms
        }
        val adjustedTimes = times.drop(5)
        println("adjustedTimes for Solution 3: $adjustedTimes")
        println("average run: ${adjustedTimes.average().roundedToNDecimalPlaces(2)}")
    }
}