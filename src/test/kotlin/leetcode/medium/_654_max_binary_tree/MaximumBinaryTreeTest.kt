package leetcode.medium._654_max_binary_tree

import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

class MaximumBinaryTreeTest {

    private val solution = Solution()

    @Test
    fun constructMaximumBinaryTree() {
        assertEquals(null, solution.constructMaximumBinaryTree(intArrayOf()))
        assertEquals(buildTree(3, 1, 2), solution.constructMaximumBinaryTree(intArrayOf(1, 3, 2)))
        assertEquals(buildTree(3, 2, null, 1), solution.constructMaximumBinaryTree(intArrayOf(1, 2, 3)))
        assertEquals(buildTree(6, 3, 5, null, 2, 0, null, null, 1), solution.constructMaximumBinaryTree(intArrayOf(3, 2, 1, 6, 0, 5)))
    }
}