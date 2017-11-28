package algorithms.medium._102_binary_tree_level_order_traversal

import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

/**
 * @author nrojiani
 * @date 11/25/17
 */
class BinaryTreeLevelOrderTraversalTest {

    private val solution = LevelOrderSolution()

    @Test
    fun levelOrder() {
        assertEquals(emptyList<List<Int>>(), solution.levelOrder(null))
        assertEquals(listOf(listOf(1)), solution.levelOrder(buildTree(1)))
        assertEquals(listOf(listOf(1), listOf(2)), solution.levelOrder(buildTree(1, 2)))
        assertEquals(listOf(listOf(1), listOf(2)), solution.levelOrder(buildTree(1, null, 2)))
        assertEquals(listOf(listOf(1), listOf(2, 3)), solution.levelOrder(buildTree(1, 2, 3)))
        assertEquals(
                listOf(
                        listOf(1),
                        listOf(2, 3),
                        listOf(4, 5, 7)),
                solution.levelOrder(buildTree(1, 2, 3, 4, 5, null, 7)))
        assertEquals(
                listOf(
                        listOf(1),
                        listOf(2, 3),
                        listOf(4, 5, 7)),
                solution.levelOrder(buildTree(1, 2, 3, 4, 5, null, 7)))
        assertEquals(
                listOf(
                        listOf(3),
                        listOf(9, 20),
                        listOf(15, 7)),
                solution.levelOrder(buildTree(3, 9, 20, null, null, 15, 7)))
    }

}