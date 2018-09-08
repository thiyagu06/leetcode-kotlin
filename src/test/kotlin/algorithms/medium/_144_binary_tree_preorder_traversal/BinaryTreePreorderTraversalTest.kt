package algorithms.medium._144_binary_tree_preorder_traversal

import datastructures.tree.buildTree
import org.junit.Assert.assertEquals
import org.junit.Test

class BinaryTreePreorderTraversalTest {

    private val solution = Solution()

    @Test
    fun preorderTraversal() {
        assertEquals(
            listOf(1, 2, 3),
            solution.preorderTraversal(buildTree(1, null, 2, 3))
        )
    }
}