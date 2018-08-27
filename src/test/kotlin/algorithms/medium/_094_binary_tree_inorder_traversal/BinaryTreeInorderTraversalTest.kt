package algorithms.medium._094_binary_tree_inorder_traversal

import datastructures.tree.bst3LevelsFull
import datastructures.tree.bstWithNulls
import org.junit.Assert.assertEquals
import org.junit.Test

class BinaryTreeInorderTraversalTest {

    private val solution = Solution()

    @Test
    fun inorderTraversal() {
        assertEquals(listOf(1, 3, 4, 5, 6, 8, 9), solution.inorderTraversal(bst3LevelsFull))
        assertEquals(listOf(1, 3, 4, 7, 8, 9), solution.inorderTraversal(bstWithNulls))
    }
}
