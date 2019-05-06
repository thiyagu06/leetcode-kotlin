package leetcode.medium._102_binary_tree_level_order_traversal

import datastructures.tree.buildTree
import org.junit.Test

import kotlin.test.assertEquals

class BinaryTreeLevelOrderTraversalTest {

    private val bfsSolution = BFSSolution()
    private val dfsSolution = DFSSolution()

    @Test
    fun levelOrderBFS() {
        assertEquals(emptyList(), bfsSolution.levelOrder(null))
        assertEquals(listOf(listOf(1)), bfsSolution.levelOrder(buildTree(1)))
        assertEquals(listOf(listOf(1), listOf(2)), bfsSolution.levelOrder(buildTree(1, 2)))
        assertEquals(listOf(listOf(1), listOf(2)), bfsSolution.levelOrder(buildTree(1, null, 2)))
        assertEquals(listOf(listOf(1), listOf(2, 3)), bfsSolution.levelOrder(buildTree(1, 2, 3)))
        assertEquals(
            listOf(
                listOf(1),
                listOf(2, 3),
                listOf(4, 5, 7)
            ),
            bfsSolution.levelOrder(buildTree(1, 2, 3, 4, 5, null, 7))
        )
        assertEquals(
            listOf(
                listOf(1),
                listOf(2, 3),
                listOf(4, 5, 7)
            ),
            bfsSolution.levelOrder(buildTree(1, 2, 3, 4, 5, null, 7))
        )
        assertEquals(
            listOf(
                listOf(3),
                listOf(9, 20),
                listOf(15, 7)
            ),
            bfsSolution.levelOrder(buildTree(3, 9, 20, null, null, 15, 7))
        )
    }

    @Test
    fun levelOrderDFS() {
        assertEquals(emptyList(), dfsSolution.levelOrder(null))
        assertEquals(listOf(listOf(1)), dfsSolution.levelOrder(buildTree(1)))
        assertEquals(listOf(listOf(1), listOf(2)), dfsSolution.levelOrder(buildTree(1, 2)))
        assertEquals(listOf(listOf(1), listOf(2)), dfsSolution.levelOrder(buildTree(1, null, 2)))
        assertEquals(listOf(listOf(1), listOf(2, 3)), dfsSolution.levelOrder(buildTree(1, 2, 3)))
        assertEquals(
            listOf(
                listOf(1),
                listOf(2, 3),
                listOf(4, 5, 7)
            ),
            dfsSolution.levelOrder(buildTree(1, 2, 3, 4, 5, null, 7))
        )
        assertEquals(
            listOf(
                listOf(1),
                listOf(2, 3),
                listOf(4, 5, 7)
            ),
            dfsSolution.levelOrder(buildTree(1, 2, 3, 4, 5, null, 7))
        )
        assertEquals(
            listOf(
                listOf(3),
                listOf(9, 20),
                listOf(15, 7)
            ),
            dfsSolution.levelOrder(buildTree(3, 9, 20, null, null, 15, 7))
        )
    }
}
