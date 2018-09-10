package leetcode.hard._145_binary_tree_postorder_traversal

import datastructures.tree.buildTree
import org.junit.Assert
import org.junit.Test

class BinaryTreePostorderTraversalTest {

    private val solution = Solution()

    @Test
    fun postorderTraversal() {
        Assert.assertEquals(
            listOf(3, 2, 1),
            solution.postorderTraversal(buildTree(1, null, 2, 3))
        )
    }
}