package leetcode.easy._617_merge_two_binary_trees

import datastructures.tree.buildTree
import org.junit.Test

import kotlin.test.assertEquals

class MergeBinaryTreesTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun mergeTrees() {
        assertEquals(buildTree(1), solution.mergeTrees(buildTree(1), null))
        assertEquals(buildTree(1), solution.mergeTrees(null, buildTree(1)))
        assertEquals(
            buildTree(3, 4, 5, 5, 4, null, 7),
            solution.mergeTrees(
                buildTree(1, 3, 2, 5),
                buildTree(2, 1, 3, null, 4, null, 7)
            )
        )
        assertEquals(
            buildTree(3, 4, 5, 5, 4, null, 7, null, 8),
            solution.mergeTrees(
                buildTree(1, 3, 2, 5, null, null, null, null, 8),
                buildTree(2, 1, 3, null, 4, null, 7)
            )
        )
        assertEquals(
            buildTree(3, 1, 3, null, 4, null, 7),
            solution.mergeTrees(
                buildTree(1),
                buildTree(2, 1, 3, null, 4, null, 7)
            )
        )
        assertEquals(
            buildTree(3, 4, 5, 5),
            solution.mergeTrees(
                buildTree(1, 3, 2, 5),
                buildTree(2, 1, 3)
            )
        )
        assertEquals(
            buildTree(8, 2, 11, 4, 5, 9, 16),
            solution.mergeTrees(
                buildTree(1, 2, 3, 4, 5, null, 6),
                buildTree(7, null, 8, 9, 10)
            )
        )
    }

    @Test
    fun mergeTrees2() {
        assertEquals(buildTree(1), solution2.mergeTrees(buildTree(1), null))
        assertEquals(buildTree(1), solution2.mergeTrees(null, buildTree(1)))
        assertEquals(
            buildTree(3, 4, 5, 5, 4, null, 7),
            solution2.mergeTrees(
                buildTree(1, 3, 2, 5),
                buildTree(2, 1, 3, null, 4, null, 7)
            )
        )
        assertEquals(
            buildTree(3, 4, 5, 5, 4, null, 7, null, 8),
            solution2.mergeTrees(
                buildTree(1, 3, 2, 5, null, null, null, null, 8),
                buildTree(2, 1, 3, null, 4, null, 7)
            )
        )
        assertEquals(
            buildTree(3, 1, 3, null, 4, null, 7),
            solution2.mergeTrees(
                buildTree(1),
                buildTree(2, 1, 3, null, 4, null, 7)
            )
        )
        assertEquals(
            buildTree(3, 4, 5, 5),
            solution2.mergeTrees(
                buildTree(1, 3, 2, 5),
                buildTree(2, 1, 3)
            )
        )
        assertEquals(
            buildTree(8, 2, 11, 4, 5, 9, 16),
            solution.mergeTrees(
                buildTree(1, 2, 3, 4, 5, null, 6),
                buildTree(7, null, 8, 9, 10)
            )
        )
    }
}