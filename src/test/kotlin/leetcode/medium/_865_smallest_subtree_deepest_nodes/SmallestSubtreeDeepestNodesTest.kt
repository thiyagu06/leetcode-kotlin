package leetcode.medium._865_smallest_subtree_deepest_nodes

import datastructures.tree.bstWithNulls
import datastructures.tree.buildTree
import datastructures.tree.treeUnbalanced2
import kotlin.test.assertEquals
import org.junit.Test

class SmallestSubtreeDeepestNodesTest {

    private var solution = Solution()
    // Must initialize SolutionTwo() each time since it stores result in fields

    @Test
    fun subtreeWithAllDeepest() {
        assertEquals(buildTree(1), solution.subtreeWithAllDeepest(bstWithNulls))

        assertEquals(
            buildTree(3),
            solution.subtreeWithAllDeepest(buildTree(3))
        )

        assertEquals(
            buildTree(1),
            solution.subtreeWithAllDeepest(buildTree(3, 1))
        )

        assertEquals(
            buildTree(2),
            solution.subtreeWithAllDeepest(buildTree(3, null, 2))
        )

        assertEquals(
            buildTree(1, 2, 3),
            solution.subtreeWithAllDeepest(buildTree(1, 2, 3))
        )

        assertEquals(
            buildTree(4),
            solution.subtreeWithAllDeepest(buildTree(1, 2, 3, 4))
        )

        assertEquals(
            buildTree(5),
            solution.subtreeWithAllDeepest(buildTree(1, 2, 3, null, 5))
        )

        assertEquals(
            buildTree(2, 4, 5),
            solution.subtreeWithAllDeepest(buildTree(1, 2, 3, 4, 5))
        )

        assertEquals(
            buildTree(1, 2, 3, null, 5, 6, null, null, 8, null, 9),
            solution.subtreeWithAllDeepest(buildTree(1, 2, 3, null, 5, 6, null, null, 8, null, 9))
        )

        assertEquals(
            buildTree(8),
            solution.subtreeWithAllDeepest(buildTree(1, 2, 3, null, 5, 6, null, null, 8))
        )

        assertEquals(
            buildTree(2, 7, 4),
            solution.subtreeWithAllDeepest(buildTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4))
        )

        assertEquals(
            buildTree(9),
            solution.subtreeWithAllDeepest(buildTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4, null, null, null, null, 9))
        )

        assertEquals(buildTree(2), solution.subtreeWithAllDeepest(treeUnbalanced2))

        assertEquals(
            buildTree(3, 5, 1, 6, 2, 0, 8),
            solution.subtreeWithAllDeepest(buildTree(3, 5, 1, 6, 2, 0, 8))
        )
    }

    @Test
    fun subtreeWithAllDeepest2() {
        assertEquals(buildTree(1), SolutionTwo().subtreeWithAllDeepest(bstWithNulls))

        assertEquals(
            buildTree(3),
            SolutionTwo().subtreeWithAllDeepest(buildTree(3))
        )

        assertEquals(
            buildTree(1),
            SolutionTwo().subtreeWithAllDeepest(buildTree(3, 1))
        )

        assertEquals(
            buildTree(2),
            SolutionTwo().subtreeWithAllDeepest(buildTree(3, null, 2))
        )

        assertEquals(
            buildTree(1, 2, 3),
            SolutionTwo().subtreeWithAllDeepest(buildTree(1, 2, 3))
        )

        assertEquals(
            buildTree(4),
            SolutionTwo().subtreeWithAllDeepest(buildTree(1, 2, 3, 4))
        )

        assertEquals(
            buildTree(5),
            SolutionTwo().subtreeWithAllDeepest(buildTree(1, 2, 3, null, 5))
        )

        assertEquals(
            buildTree(2, 4, 5),
            SolutionTwo().subtreeWithAllDeepest(buildTree(1, 2, 3, 4, 5))
        )

        assertEquals(
            buildTree(1, 2, 3, null, 5, 6, null, null, 8, null, 9),
            SolutionTwo().subtreeWithAllDeepest(buildTree(1, 2, 3, null, 5, 6, null, null, 8, null, 9))
        )

        assertEquals(
            buildTree(8),
            SolutionTwo().subtreeWithAllDeepest(buildTree(1, 2, 3, null, 5, 6, null, null, 8))
        )

        assertEquals(
            buildTree(2, 7, 4),
            SolutionTwo().subtreeWithAllDeepest(buildTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4))
        )

        assertEquals(
            buildTree(9),
            SolutionTwo().subtreeWithAllDeepest(buildTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4, null, null, null, null, 9))
        )

        assertEquals(buildTree(2), SolutionTwo().subtreeWithAllDeepest(treeUnbalanced2))

        assertEquals(
            buildTree(3, 5, 1, 6, 2, 0, 8),
            SolutionTwo().subtreeWithAllDeepest(buildTree(3, 5, 1, 6, 2, 0, 8))
        )
    }
}