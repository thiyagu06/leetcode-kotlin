package leetcode.medium._078_subsets

import org.junit.Assert.assertEquals
import org.junit.Test

class SubsetsTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()
    private val solution4 = SolutionFour()
    private val solution5 = SolutionFive()

    @Test
    fun subsets() {
        assertEquals(listOf(emptyList<Int>()), solution.subsets(intArrayOf()))
        assertEquals(
            listOf(
                listOf(3),
                listOf(1),
                listOf(2),
                listOf(1, 2, 3),
                listOf(1, 3),
                listOf(2, 3),
                listOf(1, 2),
                emptyList()
            ).toSet(),
            solution.subsets(intArrayOf(1, 2, 3)).toSet()
        )
    }


    @Test
    fun subsets2() {
        assertEquals(listOf(emptyList<Int>()), solution2.subsets(intArrayOf()))
        assertEquals(
            listOf(
                listOf(3),
                listOf(1),
                listOf(2),
                listOf(1, 2, 3),
                listOf(1, 3),
                listOf(2, 3),
                listOf(1, 2),
                emptyList()
            ).toSet(),
            solution2.subsets(intArrayOf(1, 2, 3)).toSet()
        )
    }


    @Test
    fun subsets3() {
        assertEquals(listOf(emptyList<Int>()), solution3.subsets(intArrayOf()))
        assertEquals(
            listOf(
                listOf(3),
                listOf(1),
                listOf(2),
                listOf(1, 2, 3),
                listOf(1, 3),
                listOf(2, 3),
                listOf(1, 2),
                emptyList()
            ).toSet(),
            solution3.subsets(intArrayOf(1, 2, 3)).toSet()
        )
    }

    @Test
    fun subsets4() {
        assertEquals(listOf(emptyList<Int>()), solution4.subsets(intArrayOf()))
        assertEquals(
            listOf(
                listOf(3),
                listOf(1),
                listOf(2),
                listOf(1, 2, 3),
                listOf(1, 3),
                listOf(2, 3),
                listOf(1, 2),
                emptyList()
            ).toSet(),
            solution4.subsets(intArrayOf(1, 2, 3)).toSet()
        )
    }


    @Test
    fun subsets5() {
        assertEquals(listOf(emptyList<Int>()), solution5.subsets(intArrayOf()))
        assertEquals(
            listOf(
                listOf(3),
                listOf(1),
                listOf(2),
                listOf(1, 2, 3),
                listOf(1, 3),
                listOf(2, 3),
                listOf(1, 2),
                emptyList()
            ).toSet(),
            solution5.subsets(intArrayOf(1, 2, 3)).toSet()
        )
    }

}