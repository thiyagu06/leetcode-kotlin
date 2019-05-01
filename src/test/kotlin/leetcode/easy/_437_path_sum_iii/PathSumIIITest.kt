package leetcode.easy._437_path_sum_iii

import datastructures.tree.buildTree
import datastructures.tree.tree123
import kotlin.test.assertEquals
import org.junit.Test

class PathSumIIITest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()
    private val solution4 = SolutionFour()

    @Test
    fun pathSum() {
        assertEquals(0, solution.pathSum(null, sum = 0))
        assertEquals(1, solution.pathSum(buildTree(0), sum = 0))

        // Single node counts as a "Path"
        assertEquals(1, solution.pathSum(buildTree(3), sum = 3))
        // Distinct nodes with same value both count
        assertEquals(2, solution.pathSum(buildTree(3, 3), sum = 3))
        assertEquals(2, solution.pathSum(buildTree(3, null, 3), sum = 3))
        assertEquals(3, solution.pathSum(buildTree(3, 3, 3), sum = 3))

        assertEquals(3, solution.pathSum(buildTree(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), sum = 8))
        assertEquals(2, solution.pathSum(buildTree(1, null, 2, null, 3, null, 4, null, 5), sum = 3))
        assertEquals(4, solution.pathSum(buildTree(1, -2, -3, 1, 3, -2, null, -1), sum = -1))
    }

    @Test
    fun pathSum2() {
        assertEquals(0, solution2.pathSum(null, sum = 0))
        assertEquals(1, solution2.pathSum(buildTree(0), sum = 0))

        // Single node counts as a "Path"
        assertEquals(1, solution2.pathSum(buildTree(3), sum = 3))
        // Distinct nodes with same value both count
        assertEquals(2, solution2.pathSum(buildTree(3, 3), sum = 3))
        assertEquals(2, solution2.pathSum(buildTree(3, null, 3), sum = 3))
        assertEquals(3, solution2.pathSum(buildTree(3, 3, 3), sum = 3))

        assertEquals(3, solution2.pathSum(buildTree(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), sum = 8))
        assertEquals(2, solution2.pathSum(buildTree(1, null, 2, null, 3, null, 4, null, 5), sum = 3))
        assertEquals(4, solution2.pathSum(buildTree(1, -2, -3, 1, 3, -2, null, -1), sum = -1))
    }

    @Test
    fun pathSum3() {
        assertEquals(0, solution3.pathSum(null, sum = 0))
        assertEquals(1, solution3.pathSum(buildTree(0), sum = 0))

        // Single node counts as a "Path"
        assertEquals(1, solution3.pathSum(buildTree(3), sum = 3))
        // Distinct nodes with same value both count
        assertEquals(2, solution3.pathSum(buildTree(3, 3), sum = 3))
        assertEquals(2, solution3.pathSum(buildTree(3, null, 3), sum = 3))
        assertEquals(3, solution3.pathSum(buildTree(3, 3, 3), sum = 3))

        assertEquals(3, solution3.pathSum(buildTree(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), sum = 8))
        assertEquals(2, solution3.pathSum(buildTree(1, null, 2, null, 3, null, 4, null, 5), sum = 3))
        assertEquals(4, solution3.pathSum(buildTree(1, -2, -3, 1, 3, -2, null, -1), sum = -1))
    }

    @Test
    fun pathSum4() {
        assertEquals(0, solution4.pathSum(null, sum = 0))
        assertEquals(1, solution4.pathSum(buildTree(0), sum = 0))

        // Single node counts as a "Path"
        assertEquals(1, solution4.pathSum(buildTree(3), sum = 3))
        // Distinct nodes with same value both count
        assertEquals(2, solution4.pathSum(buildTree(3, 3), sum = 3))
        assertEquals(2, solution4.pathSum(buildTree(3, null, 3), sum = 3))
        assertEquals(3, solution4.pathSum(buildTree(3, 3, 3), sum = 3))

        assertEquals(3, solution4.pathSum(buildTree(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), sum = 8))
        assertEquals(2, solution4.pathSum(buildTree(1, null, 2, null, 3, null, 4, null, 5), sum = 3))
        assertEquals(4, solution4.pathSum(buildTree(1, -2, -3, 1, 3, -2, null, -1), sum = -1))
    }

    @Test
    fun pathsFrom() {
        assertEquals(emptyList(), solution4.pathsFrom(null))

        assertEquals(listOf(listOf(3)), solution4.pathsFrom(buildTree(3)))
        assertEquals(
            listOf(listOf(3), listOf(3, 3), listOf(3)),
            solution4.pathsFrom(buildTree(3, 3))
        )
        assertEquals(
            listOf(listOf(3), listOf(3, 3), listOf(3)),
            solution4.pathsFrom(buildTree(3, null, 3))
        )
        assertEquals(
            listOf(listOf(3), listOf(3, 3), listOf(3), listOf(3, 3), listOf(3)),
            solution4.pathsFrom(buildTree(3, 3, 3))
        )

        assertEquals(
            listOf(
                listOf(1),                  // root
                listOf(1, 2), listOf(2),    // L
                listOf(1, 3), listOf(3)     // R
            ),
            solution4.pathsFrom(tree123)
        )
    }
}