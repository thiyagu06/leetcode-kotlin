package leetcode.easy._100_same_tree

import datastructures.tree.buildTree
import datastructures.tree.treeUnbalanced
import org.junit.Test

import org.junit.Assert.*

class SameTreeTest {

    private val solution = Solution()

    @Test
    fun isSameTree() {
        assertTrue(solution.isSameTree(null, null))
        assertTrue(solution.isSameTree(buildTree(1), buildTree(1)))
        assertTrue(solution.isSameTree(buildTree(2, 1, 3), buildTree(2, 1, 3)))
        assertFalse(solution.isSameTree(buildTree(1), null))
        assertFalse(solution.isSameTree(buildTree(4, 1, 2, null, null, 0), buildTree(4, 1, 2)))
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

        assertTrue(
            solution.isSameTree(
                buildTree(100, 50, 200, 25, null, 125, 350),
                buildTree(100, 50, 200, 25, null, 125, 350)
            )
        )

        assertFalse(
            solution.isSameTree(
                buildTree(100, 50, 200, null, 25, 125, 350),
                buildTree(100, 50, 200, 25, null, 125, 350)
            )
        )
    }
}