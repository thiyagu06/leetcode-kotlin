package leetcode.easy._107_binary_tree_level_order_traversal_ii

import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

class BinaryTreeLevelOrderTraversalIITest {

    private val solution = Solution()

    @Test
    fun levelOrderBottom() {
        assertEquals(emptyList<List<Int>>(), solution.levelOrderBottom(null))
        assertEquals(listOf(listOf(1)), solution.levelOrderBottom(buildTree(1)))
        assertEquals(listOf(listOf(2), listOf(1)), solution.levelOrderBottom(buildTree(1, 2)))
        assertEquals(listOf(listOf(2), listOf(1)), solution.levelOrderBottom(buildTree(1, null, 2)))
        assertEquals(listOf(listOf(2, 3), listOf(1)), solution.levelOrderBottom(buildTree(1, 2, 3)))
        assertEquals(
                listOf(
                        listOf(4, 5, 7),
                        listOf(2, 3),
                        listOf(1)),
                solution.levelOrderBottom(buildTree(1, 2, 3, 4, 5, null, 7)))
        assertEquals(
                listOf(
                        listOf(4, 5, 7),
                        listOf(2, 3),
                        listOf(1)),
                solution.levelOrderBottom(buildTree(1, 2, 3, 4, 5, null, 7)))
        assertEquals(
                listOf(
                        listOf(15, 7),
                        listOf(9, 20),
                        listOf(3)),
                solution.levelOrderBottom(buildTree(3, 9, 20, null, null, 15, 7)))
    }

}
