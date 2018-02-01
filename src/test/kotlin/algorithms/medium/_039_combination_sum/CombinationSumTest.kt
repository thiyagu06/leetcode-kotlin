package algorithms.medium._039_combination_sum

import extensions.math.roundedToNDecimalPlaces
import org.junit.Test

import org.junit.Assert.*
import kotlin.system.measureTimeMillis

class CombinationSumTest {

    private val solution = Solution()
    private val solution2 = Solution2()

    @Test
    fun combinationSum() {
        val times = arrayListOf<Long>()
        val runs = 30
        (1..runs).forEach {
            val ms = measureTimeMillis {
                assertEquals(listOf(listOf(7), listOf(2, 2, 3)).toSet(),
                    solution.combinationSum(intArrayOf(2, 3, 6, 7), 7).toSet())
                assertEquals(listOf(listOf(1, 1, 1), listOf(1, 2), listOf(3)).toSet(), solution.combinationSum(intArrayOf(1, 2, 3), 3).toSet())
                assertEquals(
                    listOf(listOf(2, 2, 2, 2), listOf(2, 3, 3), listOf(3, 5)).toSet(),
                    solution.combinationSum(intArrayOf(2, 3, 5), 8).toSet()
                )
            }
            times += ms
        }
        val adjustedTimes = times.drop(5)   // 1st one or two affected by test startup
        println("adjustedTimes for A: $adjustedTimes")
        println("average run: ${adjustedTimes.average().roundedToNDecimalPlaces(2)}")
    }

    @Test
    fun combinationSum2() {
        val times = arrayListOf<Long>()
        val runs = 30
        (1..runs).forEach {
            val ms = measureTimeMillis {
                assertEquals(listOf(listOf(7), listOf(2, 2, 3)).toSet(), solution2.combinationSum(intArrayOf(2, 3, 6, 7), 7).toSet())
                assertEquals(listOf(listOf(1, 1, 1), listOf(1, 2), listOf(3)).toSet(), solution2.combinationSum(intArrayOf(1, 2, 3), 3).toSet())
                assertEquals(
                    listOf(listOf(2, 2, 2, 2), listOf(2, 3, 3), listOf(3, 5)).toSet(),
                    solution2.combinationSum(intArrayOf(2, 3, 5), 8).toSet()
                )
            }
            times += ms
        }
        val adjustedTimes = times.drop(5)   // 1st one or two affected by test startup
        println("adjustedTimes for B: $adjustedTimes")
        println("average run: ${adjustedTimes.average().roundedToNDecimalPlaces(2)}")
    }
}