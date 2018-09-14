package leetcode.medium._046_permutations

import extensions.math.roundedToNDecimalPlaces
import org.junit.Test

import org.junit.Assert.*
import kotlin.system.measureTimeMillis

class PermutationsTest {

    private val solution = Solution()

    @Test
    fun permutations() {
        val times = arrayListOf<Long>()
        repeat(8) {
            val ms = measureTimeMillis {
                assertEquals(
                    setOf(
                        listOf(1, 2, 3),
                        listOf(1, 3, 2),
                        listOf(2, 1, 3),
                        listOf(2, 3, 1),
                        listOf(3, 1, 2),
                        listOf(3, 2, 1)
                    ),
                    solution.permute(intArrayOf(1, 2, 3)).toSet())

                assertEquals(
                    setOf(
                        listOf(1, 1, 3),
                        listOf(1, 1, 3),
                        listOf(1, 3, 1),
                        listOf(1, 3, 1),
                        listOf(3, 1, 1),
                        listOf(3, 1, 1)
                    ),
                    solution.permute(intArrayOf(1, 1, 3)).toSet())


                assertEquals(
                    setOf(
                        listOf(0, 1, 2, 3, 4), listOf(0, 1, 2, 4, 3), listOf(0, 1, 3, 2, 4), listOf(0, 1, 3, 4, 2),
                        listOf(0, 1, 4, 2, 3), listOf(0, 1, 4, 3, 2), listOf(0, 2, 1, 3, 4), listOf(0, 2, 1, 4, 3),
                        listOf(0, 2, 3, 1, 4), listOf(0, 2, 3, 4, 1), listOf(0, 2, 4, 1, 3), listOf(0, 2, 4, 3, 1),
                        listOf(0, 3, 1, 2, 4), listOf(0, 3, 1, 4, 2), listOf(0, 3, 2, 1, 4), listOf(0, 3, 2, 4, 1),
                        listOf(0, 3, 4, 1, 2), listOf(0, 3, 4, 2, 1), listOf(0, 4, 1, 2, 3), listOf(0, 4, 1, 3, 2),
                        listOf(0, 4, 2, 1, 3), listOf(0, 4, 2, 3, 1), listOf(0, 4, 3, 1, 2), listOf(0, 4, 3, 2, 1),
                        listOf(1, 0, 2, 3, 4), listOf(1, 0, 2, 4, 3), listOf(1, 0, 3, 2, 4), listOf(1, 0, 3, 4, 2),
                        listOf(1, 0, 4, 2, 3), listOf(1, 0, 4, 3, 2), listOf(1, 2, 0, 3, 4), listOf(1, 2, 0, 4, 3),
                        listOf(1, 2, 3, 0, 4), listOf(1, 2, 3, 4, 0), listOf(1, 2, 4, 0, 3), listOf(1, 2, 4, 3, 0),
                        listOf(1, 3, 0, 2, 4), listOf(1, 3, 0, 4, 2), listOf(1, 3, 2, 0, 4), listOf(1, 3, 2, 4, 0),
                        listOf(1, 3, 4, 0, 2), listOf(1, 3, 4, 2, 0), listOf(1, 4, 0, 2, 3), listOf(1, 4, 0, 3, 2),
                        listOf(1, 4, 2, 0, 3), listOf(1, 4, 2, 3, 0), listOf(1, 4, 3, 0, 2), listOf(1, 4, 3, 2, 0),
                        listOf(2, 0, 1, 3, 4), listOf(2, 0, 1, 4, 3), listOf(2, 0, 3, 1, 4), listOf(2, 0, 3, 4, 1),
                        listOf(2, 0, 4, 1, 3), listOf(2, 0, 4, 3, 1), listOf(2, 1, 0, 3, 4), listOf(2, 1, 0, 4, 3),
                        listOf(2, 1, 3, 0, 4), listOf(2, 1, 3, 4, 0), listOf(2, 1, 4, 0, 3), listOf(2, 1, 4, 3, 0),
                        listOf(2, 3, 0, 1, 4), listOf(2, 3, 0, 4, 1), listOf(2, 3, 1, 0, 4), listOf(2, 3, 1, 4, 0),
                        listOf(2, 3, 4, 0, 1), listOf(2, 3, 4, 1, 0), listOf(2, 4, 0, 1, 3), listOf(2, 4, 0, 3, 1),
                        listOf(2, 4, 1, 0, 3), listOf(2, 4, 1, 3, 0), listOf(2, 4, 3, 0, 1), listOf(2, 4, 3, 1, 0),
                        listOf(3, 0, 1, 2, 4), listOf(3, 0, 1, 4, 2), listOf(3, 0, 2, 1, 4), listOf(3, 0, 2, 4, 1),
                        listOf(3, 0, 4, 1, 2), listOf(3, 0, 4, 2, 1), listOf(3, 1, 0, 2, 4), listOf(3, 1, 0, 4, 2),
                        listOf(3, 1, 2, 0, 4), listOf(3, 1, 2, 4, 0), listOf(3, 1, 4, 0, 2), listOf(3, 1, 4, 2, 0),
                        listOf(3, 2, 0, 1, 4), listOf(3, 2, 0, 4, 1), listOf(3, 2, 1, 0, 4), listOf(3, 2, 1, 4, 0),
                        listOf(3, 2, 4, 0, 1), listOf(3, 2, 4, 1, 0), listOf(3, 4, 0, 1, 2), listOf(3, 4, 0, 2, 1),
                        listOf(3, 4, 1, 0, 2), listOf(3, 4, 1, 2, 0), listOf(3, 4, 2, 0, 1), listOf(3, 4, 2, 1, 0),
                        listOf(4, 0, 1, 2, 3), listOf(4, 0, 1, 3, 2), listOf(4, 0, 2, 1, 3), listOf(4, 0, 2, 3, 1),
                        listOf(4, 0, 3, 1, 2), listOf(4, 0, 3, 2, 1), listOf(4, 1, 0, 2, 3), listOf(4, 1, 0, 3, 2),
                        listOf(4, 1, 2, 0, 3), listOf(4, 1, 2, 3, 0), listOf(4, 1, 3, 0, 2), listOf(4, 1, 3, 2, 0),
                        listOf(4, 2, 0, 1, 3), listOf(4, 2, 0, 3, 1), listOf(4, 2, 1, 0, 3), listOf(4, 2, 1, 3, 0),
                        listOf(4, 2, 3, 0, 1), listOf(4, 2, 3, 1, 0), listOf(4, 3, 0, 1, 2), listOf(4, 3, 0, 2, 1),
                        listOf(4, 3, 1, 0, 2), listOf(4, 3, 1, 2, 0), listOf(4, 3, 2, 0, 1), listOf(4, 3, 2, 1, 0)
                    ),
                    solution.permute(intArrayOf(0, 1, 2, 3, 4)).toSet()
                )

                solution.permute(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7)).toSet()
            }
            times += ms
        }
        val adjustedTimes = times.drop(3)   // 1st one or two affected by test startup
        println("adjustedTimes for permutations: $adjustedTimes")
        println("average run: ${adjustedTimes.average().roundedToNDecimalPlaces(2)}")

    }
}