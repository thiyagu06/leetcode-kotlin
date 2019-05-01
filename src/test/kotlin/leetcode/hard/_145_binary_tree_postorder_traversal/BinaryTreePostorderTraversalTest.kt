package leetcode.hard._145_binary_tree_postorder_traversal

import datastructures.tree.buildTree
import org.junit.Test
import kotlin.test.assertEquals

class BinaryTreePostorderTraversalTest {

    private val solution = Solution()

    @Test
    fun postorderTraversal() {
        assertEquals(
            listOf(3, 2, 1),
            solution.postorderTraversal(buildTree(1, null, 2, 3))
        )
    }
}