package leetcode.easy._110_balanced_binary_tree

import datastructures.tree.bst3LevelsFull
import datastructures.tree.bstWithNulls
import datastructures.tree.buildTree
import datastructures.tree.tree123
import datastructures.tree.tree1to5
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BalancedBinaryTreeTest {

    private val solution = Solution()
    private val unbalancedTree = buildTree(7, 4, 9, 3, null, 8, null, 1, null, null, null, 2)
    private val unbalancedTree2 = buildTree(
        7, 4, 9, 3, null, 8, null, 1, null, null, null, 2,
        4, 9, 3, null, 8, null, 1, null, null, null, 2, 4, 9, 3, null, 8, null, 1, null, null, null, 2
    )
    private val unbalancedTree3 = buildTree(1, null, 2, null, 3)

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
}