package leetcode.easy._104_max_depth_binary_tree

import datastructures.tree.bstWithNulls
import datastructures.tree.buildTree
import datastructures.tree.tree123
import datastructures.tree.tree1to5
import org.junit.Test

import kotlin.test.assertEquals

class MaxDepthBinaryTreeTest {

    private val solution = Solution()
    private val altSolution = AltSolution()

    @Test
    fun maxDepth() {
        assertEquals(0, solution.maxDepth(null))
        assertEquals(1, solution.maxDepth(buildTree(1)))
        assertEquals(2, solution.maxDepth(buildTree(1, 2)))
        assertEquals(2, solution.maxDepth(tree123))
        assertEquals(3, solution.maxDepth(tree1to5))
        assertEquals(4, solution.maxDepth(bstWithNulls))
    }

    @Test
    fun maxDepthAlt() {
        assertEquals(0, altSolution.maxDepth(null))
        assertEquals(1, altSolution.maxDepth(buildTree(1)))
        assertEquals(2, altSolution.maxDepth(buildTree(1, 2)))
        assertEquals(2, altSolution.maxDepth(tree123))
        assertEquals(3, altSolution.maxDepth(tree1to5))
        assertEquals(4, altSolution.maxDepth(bstWithNulls))
    }
}