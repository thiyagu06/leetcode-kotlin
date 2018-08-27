package algorithms.easy._637_avg_of_levels_in_binary_tree

import datastructures.tree.buildTree
import org.junit.Assert.assertArrayEquals
import org.junit.Test

class AvgOfLevelsInBinaryTreeTest {

    private val solutionDFS = SolutionDFS()
    private val solutionBFS = SolutionBFS()

    @Test
    fun averageOfLevelsDFS() {
        assertArrayEquals(doubleArrayOf(3.0, 14.5, 11.0), solutionDFS.averageOfLevels(buildTree(3, 9, 20, 15, 7)), 0.0001)
    }

    @Test
    fun averageOfLevelsBFS() {
        assertArrayEquals(doubleArrayOf(3.0, 14.5, 11.0), solutionBFS.averageOfLevels(buildTree(3, 9, 20, 15, 7)), 0.0001)
    }
}