package leetcode.easy._118_pascals_triangle

import kotlin.test.assertEquals
import org.junit.Test
import kotlin.system.measureTimeMillis

class PascalsTriangleTest {
    private val solution1 = PascalsTriangle()
    private val solution2 = PascalsTriangle2()
    private val first7rows = listOf(
            listOf(1),
            listOf(1, 1),
            listOf(1, 2, 1),
            listOf(1, 3, 3, 1),
            listOf(1, 4, 6, 4, 1),
            listOf(1, 5, 10, 10, 5, 1),
            listOf(1, 6, 15, 20, 15, 6, 1)
    )

    @Test
    fun generate1() {
        val ms = measureTimeMillis {
            assertEquals(emptyList(), solution1.generate(0))
            (1..6).forEach { rows ->
                assertEquals(first7rows.slice(0 until rows), solution1.generate(rows))
            }
        }
        println("$ms ms")
    }

    @Test
    fun generate2() {
        val ms = measureTimeMillis {
            assertEquals(emptyList(), solution2.generate(0))
            (1..6).forEach { rows ->
                assertEquals(first7rows.slice(0 until rows), solution2.generate(rows))
            }
        }
        println("$ms ms")
    }
}
