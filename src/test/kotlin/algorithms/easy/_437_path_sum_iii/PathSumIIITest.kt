package algorithms.easy._437_path_sum_iii

import datastructures.tree.buildTree
import datastructures.tree.tree123
import org.junit.Assert.assertEquals
import org.junit.Test

class PathSumIIITest {

    private val solution = Solution()
    private val solutionSumList = SolutionWithPathSums()
    private val solutionPaths = SolutionWithPathLists()

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
    }

    @Test
    fun pathSumWithSumLists() {
        assertEquals(0, solutionSumList.pathSum(null, sum = 0))
        assertEquals(1, solutionSumList.pathSum(buildTree(0), sum = 0))

        // Single node counts as a "Path"
        assertEquals(1, solutionSumList.pathSum(buildTree(3), sum = 3))
        // Distinct nodes with same value both count
        assertEquals(2, solutionSumList.pathSum(buildTree(3, 3), sum = 3))
        assertEquals(2, solutionSumList.pathSum(buildTree(3, null, 3), sum = 3))
        assertEquals(3, solutionSumList.pathSum(buildTree(3, 3, 3), sum = 3))

        assertEquals(3, solutionSumList.pathSum(buildTree(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), sum = 8))
    }

    @Test
    fun pathSumWithPathLists() {
        assertEquals(0, solutionPaths.pathSum(null, sum = 0))
        assertEquals(1, solutionPaths.pathSum(buildTree(0), sum = 0))

        // Single node counts as a "Path"
        assertEquals(1, solutionPaths.pathSum(buildTree(3), sum = 3))
        // Distinct nodes with same value both count
        assertEquals(2, solutionPaths.pathSum(buildTree(3, 3), sum = 3))
        assertEquals(2, solutionPaths.pathSum(buildTree(3, null, 3), sum = 3))
        assertEquals(3, solutionPaths.pathSum(buildTree(3, 3, 3), sum = 3))

        assertEquals(3, solutionPaths.pathSum(buildTree(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), sum = 8))
    }

    @Test
    fun pathsFrom() {
        assertEquals(emptyList<List<Int>>(), solutionPaths.pathsFrom(null))

        assertEquals(listOf(listOf(3)), solutionPaths.pathsFrom(buildTree(3)))
        assertEquals(
                listOf(listOf(3), listOf(3, 3), listOf(3)),
                solutionPaths.pathsFrom(buildTree(3, 3)))
        assertEquals(
                listOf(listOf(3), listOf(3, 3), listOf(3)),
                solutionPaths.pathsFrom(buildTree(3, null, 3)))
        assertEquals(listOf(listOf(3), listOf(3, 3), listOf(3), listOf(3, 3), listOf(3)),
                solutionPaths.pathsFrom(buildTree(3, 3, 3)))

        assertEquals(
                listOf(
                        listOf(1),                  // root
                        listOf(1, 2), listOf(2),    // L
                        listOf(1, 3), listOf(3)     // R
                ),
                solutionPaths.pathsFrom(tree123))
    }

}