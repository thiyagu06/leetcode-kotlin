package algorithms.easy._110_balanced_binary_tree

import datastructures.tree.TreeNode
import datastructures.tree.bst3LevelsFull
import datastructures.tree.bstWithNulls
import datastructures.tree.buildTree
import datastructures.tree.tree123
import datastructures.tree.tree1to5
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class BalancedBinaryTreeTest {

    private val solution = Solution()
    private val solutionCorrect = SolutionCorrect()
    private val unbalancedTree = buildTree(7, 4, 9, 3, null, 8, null, 1, null, null, null, 2)
    private val unbalancedTree2 = buildTree(7, 4, 9, 3, null, 8, null, 1, null, null, null, 2,
            4, 9, 3, null, 8, null, 1, null, null, null, 2,  4, 9, 3, null, 8, null, 1, null, null, null, 2)
    private val unbalancedTree3 = buildTree(1, null, 2, null,3)

    @Test
    fun isBalanced() {
        assertTrue(solution.isBalanced(tree123))
        assertTrue(solution.isBalanced(tree1to5))
        assertTrue(solution.isBalanced(bst3LevelsFull))
        assertFalse(solution.isBalanced(bstWithNulls))
        assertFalse(solution.isBalanced(unbalancedTree))
        assertFalse(solution.isBalanced(unbalancedTree2))
        assertFalse(solution.isBalanced(unbalancedTree3))
    }

    @Test
    fun height() {
        assertEquals(0, solutionCorrect.height(TreeNode(7)))
        assertEquals(1, solutionCorrect.height(tree123))
        assertEquals(0, solutionCorrect.height(tree123.left))
        assertEquals(0, solutionCorrect.height(tree123.right))
        assertEquals(2, solutionCorrect.height(tree1to5))
        assertEquals(2, solutionCorrect.height(bst3LevelsFull))
        assertEquals(3, solutionCorrect.height(bstWithNulls))
        assertEquals(2, solutionCorrect.height(bstWithNulls.left))
        assertEquals(1, solutionCorrect.height(bstWithNulls.right))
        assertEquals(2, solutionCorrect.height(unbalancedTree3))
        assertEquals(0, solutionCorrect.height(unbalancedTree3?.left))
        assertEquals(1, solutionCorrect.height(unbalancedTree3?.right))
    }
}