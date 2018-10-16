package leetcode.medium._077_combinations

import org.junit.Assert.assertEquals
import org.junit.Test

class CombinationsTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun combine() {
        val expectedA = listOf(emptyList<Int>())
        val actualA = solution.combine(n = 3, k = 0)
        assertEquals(expectedA.size, actualA.size)
        assertEquals(expectedA.toSet(), actualA.toSet())

        val expectedB = listOf(listOf(1), listOf(2), listOf(3))
        val actualB = solution.combine(n = 3, k = 1)
        assertEquals(expectedB.size, actualB.size)
        assertEquals(expectedB.toSet(), actualB.toSet())

        val expectedC = listOf(listOf(1, 2), listOf(1, 3), listOf(2, 3))
        val actualC = solution.combine(n = 3, k = 2)
        assertEquals(expectedC.size, actualC.size)
        assertEquals(expectedC.toSet(), actualC.toSet())

        val expectedD = listOf(listOf(1, 2, 3))
        val actualD = solution.combine(n = 3, k = 3)
        assertEquals(expectedD.size, actualD.size)
        assertEquals(expectedD.toSet(), actualD.toSet())

        val expectedE = listOf(
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
        )
        val actualE = solution.combine(n = 6, k = 4)
        assertEquals(expectedE.size, actualE.size)
        assertEquals(expectedE.toSet(), actualE.toSet())
    }

    @Test
    fun combine2() {
        val expectedA = listOf(emptyList<Int>())
        val actualA = solution2.combine(n = 3, k = 0)
        assertEquals(expectedA.size, actualA.size)
        assertEquals(expectedA.toSet(), actualA.toSet())

        val expectedB = listOf(listOf(1), listOf(2), listOf(3))
        val actualB = solution2.combine(n = 3, k = 1)
        assertEquals(expectedB.size, actualB.size)
        assertEquals(expectedB.toSet(), actualB.toSet())

        val expectedC = listOf(listOf(1, 2), listOf(1, 3), listOf(2, 3))
        val actualC = solution2.combine(n = 3, k = 2)
        assertEquals(expectedC.size, actualC.size)
        assertEquals(expectedC.toSet(), actualC.toSet())

        val expectedD = listOf(listOf(1, 2, 3))
        val actualD = solution2.combine(n = 3, k = 3)
        assertEquals(expectedD.size, actualD.size)
        assertEquals(expectedD.toSet(), actualD.toSet())

        val expectedE = listOf(
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
        )
        val actualE = solution2.combine(n = 6, k = 4)
        assertEquals(expectedE.size, actualE.size)
        assertEquals(expectedE.toSet(), actualE.toSet())
    }
}