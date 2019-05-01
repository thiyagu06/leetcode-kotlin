package leetcode.easy._119_pascals_triangle_II

import org.junit.Test

import kotlin.test.assertEquals
import kotlin.system.measureTimeMillis

class PascalsTriangleIITest {
    private val solution = Solution()
    private val followup = FollowUpSolution()
    private val followup2 = FollowUpSolutionTwo()

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
    fun getRow1() {
        val ms = measureTimeMillis {
            (0..6).forEach { rowIndex ->
                assertEquals(first7rows.slice(0..rowIndex).last(), solution.getRow(rowIndex))
            }
        }
        println("$ms ms")
    }

    @Test
    fun getRowFollowUp() {
        val ms = measureTimeMillis {
            (0..6).forEach { rowIndex ->
                assertEquals(first7rows.slice(0..rowIndex).last(), followup.getRow(rowIndex))
            }
        }
        println("$ms ms")
    }

    @Test
    fun getRowFollowUp2() {
        val ms = measureTimeMillis {
            (0..6).forEach { rowIndex ->
                assertEquals(first7rows.slice(0..rowIndex).last(), followup2.getRow(rowIndex))
            }
        }
        println("$ms ms")
    }
}
