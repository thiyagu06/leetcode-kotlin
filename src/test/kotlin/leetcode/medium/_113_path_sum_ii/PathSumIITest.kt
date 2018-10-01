package leetcode.medium._113_path_sum_ii

import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

class PathSumIITest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun pathSum() {
        assertEquals(
            listOf(
                listOf(5, 4, 11, 2),
                listOf(5, 8, 4, 5)
            ),
            solution.pathSum(buildTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22)
        )
    }

    @Test
    fun pathSum2() {
        assertEquals(
            listOf(
                listOf(5, 4, 11, 2),
                listOf(5, 8, 4, 5)
            ),
            solution2.pathSum(buildTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22)
        )
    }
}