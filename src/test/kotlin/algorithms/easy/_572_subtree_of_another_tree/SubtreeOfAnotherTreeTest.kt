package algorithms.easy._572_subtree_of_another_tree

import datastructures.tree.buildTree
import datastructures.tree.treeUnbalanced
import org.junit.Test

import org.junit.Assert.*

class SubtreeOfAnotherTreeTest {

    private val solution = Solution()

    @Test
    fun isSubtree() {
        assertTrue(solution.isSubtree(buildTree(1), buildTree(1)))
        assertTrue(solution.isSubtree(buildTree(1, 2), buildTree(2)))
        assertFalse(solution.isSubtree(buildTree(1, 2, 3), buildTree(1)))
        assertTrue(solution.isSubtree(buildTree(1, 2, 3), buildTree(2)))
        assertTrue(solution.isSubtree(buildTree(1, 2, 3), buildTree(3)))
        assertTrue(solution.isSubtree(buildTree(1, 2, 3), buildTree(2)))

        assertTrue(
            solution.isSubtree(
                buildTree(1, null, 1, null, 1, 2),
                buildTree(1, null, 1, null, 1, 2)
            )
        )
        assertTrue(
            solution.isSubtree(
                buildTree(1, null, 1, null, 1, null, 1, 2),
                buildTree(1, null, 1, null, 1, 2)
            )
        )

        assertTrue(
            solution.isSubtree(
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, 2),
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, 2)
            )
        )
        assertTrue(
            solution.isSubtree(
                buildTree(1, null, 1, null, 7, null, 1, null, 1, null, 1, null, 1, null, 1, 2),
                buildTree(7, null, 1, null, 1, null, 1, null, 1, null, 1, 2)
            )
        )
        assertTrue(
            solution.isSubtree(
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, 2),
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, 2)
            )
        )
        assertTrue(
            solution.isSubtree(
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, 2),
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, 2)
            )
        )
        assertTrue(
            solution.isSubtree(
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, 2),
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, 2)
            )
        )
        assertTrue(
            solution.isSubtree(
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null,
                    1, 2),
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, 2)
            )
        )
        assertTrue(
            solution.isSubtree(
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1,
                    null, 1, 2),
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, 2)
            )
        )
        assertTrue(
            solution.isSubtree(
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1,
                    null, 1, null, 1, 2),
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, 2)
            )
        )
        assertTrue(
            solution.isSubtree(
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, 2),
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, 2)
            )
        )

        assertFalse(solution.isSubtree(buildTree(1,  2), buildTree(1)))
        assertFalse(solution.isSubtree(buildTree(1), buildTree(2)))
        assertFalse(solution.isSubtree(buildTree(1), buildTree(1,  2)))
        assertFalse(solution.isSubtree(buildTree(1,  2, 3), buildTree(1,  2)))
    }

    @Test
    fun subtreeOfSelf() {
        assertTrue(solution.isSubtree(buildTree(1, 2, 3), buildTree(1, 2, 3)))
    }

    /**
     * Test that true if t is a subset of s, but false if s is a subset of t
     */
    @Test
    fun inverse() {
        assertTrue(solution.isSubtree(buildTree(3, 4, 5, 1, 2), buildTree(4, 1, 2)))
        assertFalse(solution.isSubtree(buildTree(4, 1, 2), buildTree(3, 4, 5, 1, 2)))
    }

    @Test
    fun leetcodeTests() {
        assertTrue(solution.isSubtree(buildTree(3, 4, 5, 1, 2), buildTree(4, 1, 2)))
        assertFalse(solution.isSubtree(buildTree(3, 4, 5, 1, 2, null, null, null, null, 0), buildTree(4, 1, 2)))
    }

    @Test
    fun isSameTree() {
        assertTrue(solution.isSameTree(null, null))
        assertTrue(solution.isSameTree(buildTree(1), buildTree(1)))
        assertTrue(solution.isSameTree(buildTree(2, 1, 3), buildTree(2, 1, 3)))
        assertFalse(solution.isSameTree(buildTree(1), null))
        assertFalse(solution.isSameTree(buildTree(4, 1, 2, null, null, 0), buildTree(4, 1, 2)))
        assertTrue(
            solution.isSameTree(
                buildTree(1, null, 1, null, 1, 2),
                buildTree(1, null, 1, null, 1, 2)
            )
        )

        assertTrue(
            solution.isSameTree(
                buildTree(1, null, 1, null, 1, null, 1, 2)?.right,
                buildTree(1, null, 1, null, 1, 2)
            )
        )

        assertTrue(solution.isSameTree(buildTree(1, null, 1, null, 1, 2), treeUnbalanced))
        assertTrue(
            solution.isSameTree(
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, 2),
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, 2)
            )
        )

        assertTrue(
            solution.isSameTree(
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, 2),
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, 2)
            )
        )
    }
}