package leetcode.easy._111_min_depth_of_binary_tree

import datastructures.tree.bst3LevelsFull
import datastructures.tree.bstWithNulls
import datastructures.tree.buildTree
import datastructures.tree.tree123
import org.junit.Assert.assertEquals
import org.junit.Test

class MinDepthOfBinaryTreeTest {

    private val solution = Solution()
    private val altSolution = AltSolution()

    @Test
    fun minDepth() {
        assertEquals(0, solution.minDepth(null))
        assertEquals(1, solution.minDepth(buildTree(1)))
        assertEquals(2, solution.minDepth(tree123))
        assertEquals(3, solution.minDepth(bst3LevelsFull))
        assertEquals(3, solution.minDepth(bstWithNulls))
    }


    @Test
    fun minDepthAlt() {
        assertEquals(0, altSolution.minDepth(null))
        assertEquals(1, altSolution.minDepth(buildTree(1)))
        assertEquals(2, altSolution.minDepth(tree123))
        assertEquals(3, altSolution.minDepth(bst3LevelsFull))
        assertEquals(3, altSolution.minDepth(bstWithNulls))
    }
}
