package leetcode.medium._090_subsets_ii

import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.junit.Ignore
import org.junit.Test

class SubsetsIITest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun subsetsWithDup() {
        assertEquals(listOf(emptyList()), solution.subsetsWithDup(intArrayOf()))

        val result122 = solution.subsetsWithDup(intArrayOf(1, 2, 2))
        assertEquals(6, result122.size)
        val expected122 = listOf(
            emptyList(),
            listOf(2),
            listOf(2, 2),
            listOf(1),
            listOf(1, 2),
            listOf(1, 2, 2)
        )
        expected122.forEach { sublist ->
            assertTrue(result122.contains(sublist))
        }

        val result1233 = solution.subsetsWithDup(intArrayOf(1, 2, 3, 3))
        assertEquals(12, result1233.size)
        val expected1233 = listOf(
            emptyList(),
            listOf(3),
            listOf(3, 3),
            listOf(2),
            listOf(2, 3),
            listOf(2, 3, 3),
            listOf(1),
            listOf(1, 3),
            listOf(1, 3, 3),
            listOf(1, 2),
            listOf(1, 2, 3),
            listOf(1, 2, 3, 3)
        )
        expected1233.forEach { sublist ->
            assertTrue(result1233.contains(sublist))
        }

        val result44414 = solution.subsetsWithDup(intArrayOf(4, 4, 4, 1, 4))
        assertEquals(10, result44414.size)
        val expected44414 = listOf(
            listOf(),
            listOf(1),
            listOf(1, 4),
            listOf(1, 4, 4),
            listOf(1, 4, 4, 4),
            listOf(1, 4, 4, 4, 4),
            listOf(4),
            listOf(4, 4),
            listOf(4, 4, 4),
            listOf(4, 4, 4, 4)
        )
        println(result44414)
        expected44414.forEach { sublist ->
            assertTrue(result44414.contains(sublist))
        }

        val result55555 = solution.subsetsWithDup(intArrayOf(5, 5, 5, 5, 5))
        assertEquals(6, result55555.size)

        val expected55555 = listOf(
            emptyList(),
            listOf(5),
            listOf(5, 5),
            listOf(5, 5, 5),
            listOf(5, 5, 5, 5),
            listOf(5, 5, 5, 5, 5)
        )
        expected55555.forEach { sublist ->
            assertTrue(result55555.contains(sublist))
        }
    }

    @Ignore("Unimplemented")
    @Test
    fun subsetsWithDup2() {
        assertEquals(listOf(emptyList()), solution2.subsetsWithDup(intArrayOf()))

        val result122 = solution2.subsetsWithDup(intArrayOf(1, 2, 2))
        assertEquals(6, result122.size)
        val expected122 = listOf(
            emptyList(),
            listOf(2),
            listOf(2, 2),
            listOf(1),
            listOf(1, 2),
            listOf(1, 2, 2)
        )
        expected122.forEach { sublist ->
            assertTrue(result122.contains(sublist))
        }

        val result1233 = solution2.subsetsWithDup(intArrayOf(1, 2, 3, 3))
        assertEquals(12, result1233.size)
        val expected1233 = listOf(
            emptyList(),
            listOf(3),
            listOf(3, 3),
            listOf(2),
            listOf(2, 3),
            listOf(2, 3, 3),
            listOf(1),
            listOf(1, 3),
            listOf(1, 3, 3),
            listOf(1, 2),
            listOf(1, 2, 3),
            listOf(1, 2, 3, 3)
        )
        expected1233.forEach { sublist ->
            assertTrue(result1233.contains(sublist))
        }

        val result44414 = solution2.subsetsWithDup(intArrayOf(4, 4, 4, 1, 4))
        assertEquals(10, result44414.size)
        val expected44414 = listOf(
            listOf(),
            listOf(1),
            listOf(1, 4),
            listOf(1, 4, 4),
            listOf(1, 4, 4, 4),
            listOf(1, 4, 4, 4, 4),
            listOf(4),
            listOf(4, 4),
            listOf(4, 4, 4),
            listOf(4, 4, 4, 4)
        )
        expected44414.forEach { sublist ->
            assertTrue(result44414.contains(sublist))
        }

        val result55555 = solution2.subsetsWithDup(intArrayOf(5, 5, 5, 5, 5))
        assertEquals(6, result55555.size)

        val expected55555 = listOf(
            emptyList(),
            listOf(5),
            listOf(5, 5),
            listOf(5, 5, 5),
            listOf(5, 5, 5, 5),
            listOf(5, 5, 5, 5, 5)
        )
        expected55555.forEach { sublist ->
            assertTrue(result55555.contains(sublist))
        }
    }
}