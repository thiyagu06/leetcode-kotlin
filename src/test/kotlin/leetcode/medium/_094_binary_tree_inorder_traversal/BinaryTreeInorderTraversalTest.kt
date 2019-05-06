package leetcode.medium._094_binary_tree_inorder_traversal

import datastructures.tree.bst3LevelsFull
import datastructures.tree.bstWithNulls
import org.junit.Test
import kotlin.test.assertEquals

class BinaryTreeInorderTraversalTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val debugSolution2 = DebugSolutionTwo()

    @Test
    fun inorderTraversal() {
        assertEquals(listOf(1, 3, 4, 5, 6, 8, 9), solution.inorderTraversal(bst3LevelsFull))
        assertEquals(listOf(1, 3, 4, 7, 8, 9), solution.inorderTraversal(bstWithNulls))
    }

    @Test
    fun inorderTraversal2() {
        assertEquals(listOf(1, 3, 4, 5, 6, 8, 9), solution2.inorderTraversal(bst3LevelsFull))
        assertEquals(listOf(1, 3, 4, 7, 8, 9), solution2.inorderTraversal(bstWithNulls))
    }

    @Test
    fun inorderTraversalDebug2() {
        assertEquals(listOf(1, 3, 4, 5, 6, 8, 9), debugSolution2.inorderTraversal(bst3LevelsFull))
        assertEquals(listOf(1, 3, 4, 7, 8, 9), debugSolution2.inorderTraversal(bstWithNulls))
    }
}
