package algorithms.medium._077_combinations

import extensions.math.roundedToNDecimalPlaces
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.system.measureTimeMillis

class CombinationsTest {

    private val solution = Solution()

    @Test
    fun combine() {
        val times = arrayListOf<Long>()
        val runs = 15
        (1..runs).forEach {
            val ms = measureTimeMillis {
                // list = [1, 2, 3]
                assertEquals(
                    listOf(emptyList<Int>()),
                    solution.combine(n = 3, k = 0)
                )

                assertEquals(
                    listOf(listOf(1), listOf(2), listOf(3)),
                    solution.combine(n = 3, k = 1)
                )

                assertEquals(
                    listOf(listOf(1, 2), listOf(1, 3), listOf(2, 3)),
                    solution.combine(n = 3, k = 2)
                )

                assertEquals(
                    listOf(listOf(1, 2, 3)),
                    solution.combine(n = 3, k = 3)
                )

                // list = [1, 2, 3, 4, 5, 6]
                assertEquals(
                    listOf(
                        listOf(1, 2, 3, 4),
                        listOf(1, 2, 3, 5),
                        listOf(1, 2, 3, 6),
                        listOf(1, 2, 4, 5),
                        listOf(1, 2, 4, 6),
                        listOf(1, 2, 5, 6),
                        listOf(1, 3, 4, 5),
                        listOf(1, 3, 4, 6),
                        listOf(1, 3, 5, 6),
                        listOf(1, 4, 5, 6),
                        listOf(2, 3, 4, 5),
                        listOf(2, 3, 4, 6),
                        listOf(2, 3, 5, 6),
                        listOf(2, 4, 5, 6),
                        listOf(3, 4, 5, 6)
                    ).toSet(),
                    solution.combine(n = 6, k = 4).toSet()
                )

            }
            times += ms
        }
        val adjustedTimes = times.drop(3)
        println("adjustedTimes for solution.combineSet: $adjustedTimes")
        println("average run: ${adjustedTimes.average().roundedToNDecimalPlaces(2)}")
    }
}