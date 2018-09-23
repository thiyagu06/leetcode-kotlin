package leetcode.medium._078_subsets

import org.junit.Assert.assertEquals
import org.junit.Test

class SubsetsTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()
    private val solution4 = SolutionFour()
    private val solution5 = SolutionFive()
    private val solution6 = SolutionSix()
    private val solution7 = SolutionSeven()
    private val solution8 = SolutionEight()

    private val expected123 = listOf(
        listOf(3),
        listOf(1),
        listOf(2),
        listOf(1, 2, 3),
        listOf(1, 3),
        listOf(2, 3),
        listOf(1, 2),
        emptyList()
    )

    @Test
    fun subsets() {
        assertEquals(listOf(emptyList<Int>()), solution.subsets(intArrayOf()))

        val actual123 = solution.subsets(intArrayOf(1, 2, 3))
        assertEquals(8, actual123.size)
        assertEquals(expected123.toSet(), actual123.toSet())
    }

    @Test
    fun subsets2() {
        assertEquals(listOf(emptyList<Int>()), solution2.subsets(intArrayOf()))

        val actual123 = solution2.subsets(intArrayOf(1, 2, 3))
        assertEquals(8, actual123.size)
        assertEquals(expected123.toSet(), actual123.toSet())
    }

    @Test
    fun subsets3() {
        assertEquals(listOf(emptyList<Int>()), solution3.subsets(intArrayOf()))

        val actual123 = solution3.subsets(intArrayOf(1, 2, 3))
        assertEquals(8, actual123.size)
        assertEquals(expected123.toSet(), actual123.toSet())
    }

    @Test
    fun subsets4() {
        assertEquals(listOf(emptyList<Int>()), solution4.subsets(intArrayOf()))

        val actual123 = solution4.subsets(intArrayOf(1, 2, 3))
        assertEquals(8, actual123.size)
        assertEquals(expected123.toSet(), actual123.toSet())
    }

    @Test
    fun subsets5() {
        assertEquals(listOf(emptyList<Int>()), solution5.subsets(intArrayOf()))

        val actual123 = solution5.subsets(intArrayOf(1, 2, 3))
        assertEquals(8, actual123.size)
        assertEquals(expected123.toSet(), actual123.toSet())
    }

    @Test
    fun subsets6() {
        assertEquals(listOf(emptyList<Int>()), solution6.subsets(intArrayOf()))

        val actual123 = solution6.subsets(intArrayOf(1, 2, 3))
        assertEquals(8, actual123.size)
        assertEquals(expected123.toSet(), actual123.toSet())
    }

    @Test
    fun subsets7() {
        assertEquals(listOf(emptyList<Int>()), solution7.subsets(intArrayOf()))

        val actual123 = solution7.subsets(intArrayOf(1, 2, 3))
        assertEquals(8, actual123.size)
        assertEquals(expected123.toSet(), actual123.toSet())
    }

    @Test
    fun subsets8() {
        assertEquals(listOf(emptyList<Int>()), solution8.subsets(intArrayOf()))

        val actual123 = solution8.subsets(intArrayOf(1, 2, 3))
        assertEquals(8, actual123.size)
        assertEquals(expected123.toSet(), actual123.toSet())
    }
}