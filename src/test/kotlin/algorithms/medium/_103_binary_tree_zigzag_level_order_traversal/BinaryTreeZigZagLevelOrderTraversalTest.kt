package algorithms.medium._103_binary_tree_zigzag_level_order_traversal

import datastructures.tree.buildTree
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author nrojiani
 * @date 11/25/17
 */
class BinaryTreeZigZagLevelOrderTraversalTest {

    private val solution = Solution()
    private val simpleSolution1 = SimpleSolution1()
    private val simpleSolution2 = SimpleSolution2()

    @Test
    fun zigzagLevelOrder() {
        assertEquals(emptyList<List<Int>>(), solution.zigzagLevelOrder(null))
        assertEquals(listOf(listOf(1)), solution.zigzagLevelOrder(buildTree(1)))
        assertEquals(listOf(listOf(1), listOf(2)), solution.zigzagLevelOrder(buildTree(1, 2)))
        assertEquals(listOf(listOf(1), listOf(2)), solution.zigzagLevelOrder(buildTree(1, null, 2)))
        assertEquals(listOf(listOf(1), listOf(3, 2)), solution.zigzagLevelOrder(buildTree(1, 2, 3)))

        assertEquals(
                listOf(
                        listOf(1),
                        listOf(3, 2),
                        listOf(4, 5, 7)),
                solution.zigzagLevelOrder(buildTree(1, 2, 3, 4, 5, null, 7)))

        assertEquals(
                listOf(
                        listOf(3),
                        listOf(20, 9),
                        listOf(15, 7)),
                solution.zigzagLevelOrder(buildTree(3, 9, 20, null, null, 15, 7)))

        assertEquals(
                listOf(
                        listOf(0),
                        listOf(4, 2),
                        listOf(1, 3, -1),
                        listOf(8, 6, 1, 5)),
                solution.zigzagLevelOrder(
                        buildTree(0, 2, 4, 1, null, 3, -1, 5, 1, null, 6, null, 8)))

        assertEquals(
                listOf(
                        listOf(3),
                        listOf(5, 4),
                        listOf(-7, -6),
                        listOf(-5, -7),
                        listOf(-4)),
                solution.zigzagLevelOrder(
                        buildTree(3, 4, 5, -7, -6, null, null, -7, null, -5, null, null, null, -4)))

    }

    @Test
    fun zigzagLevelOrderSimple1() {
        assertEquals(emptyList<List<Int>>(), simpleSolution1.zigzagLevelOrder(null))
        assertEquals(listOf(listOf(1)), simpleSolution1.zigzagLevelOrder(buildTree(1)))
        assertEquals(listOf(listOf(1), listOf(2)), simpleSolution1.zigzagLevelOrder(buildTree(1, 2)))
        assertEquals(listOf(listOf(1), listOf(2)), simpleSolution1.zigzagLevelOrder(buildTree(1, null, 2)))
        assertEquals(listOf(listOf(1), listOf(3, 2)), simpleSolution1.zigzagLevelOrder(buildTree(1, 2, 3)))

        assertEquals(
                listOf(
                        listOf(1),
                        listOf(3, 2),
                        listOf(4, 5, 7)),
                simpleSolution1.zigzagLevelOrder(buildTree(1, 2, 3, 4, 5, null, 7)))

        assertEquals(
                listOf(
                        listOf(3),
                        listOf(20, 9),
                        listOf(15, 7)),
                simpleSolution1.zigzagLevelOrder(buildTree(3, 9, 20, null, null, 15, 7)))

        assertEquals(
                listOf(
                        listOf(0),
                        listOf(4, 2),
                        listOf(1, 3, -1),
                        listOf(8, 6, 1, 5)),
                simpleSolution1.zigzagLevelOrder(
                        buildTree(0, 2, 4, 1, null, 3, -1, 5, 1, null, 6, null, 8)))

        assertEquals(
                listOf(
                        listOf(3),
                        listOf(5, 4),
                        listOf(-7, -6),
                        listOf(-5, -7),
                        listOf(-4)),
                simpleSolution1.zigzagLevelOrder(
                        buildTree(3, 4, 5, -7, -6, null, null, -7, null, -5, null, null, null, -4)))
    }

    @Test
    fun zigzagLevelOrderSimple2() {
        assertEquals(emptyList<List<Int>>(), simpleSolution2.zigzagLevelOrder(null))
        assertEquals(listOf(listOf(1)), simpleSolution2.zigzagLevelOrder(buildTree(1)))
        assertEquals(listOf(listOf(1), listOf(2)), simpleSolution2.zigzagLevelOrder(buildTree(1, 2)))
        assertEquals(listOf(listOf(1), listOf(2)), simpleSolution2.zigzagLevelOrder(buildTree(1, null, 2)))
        assertEquals(listOf(listOf(1), listOf(3, 2)), simpleSolution2.zigzagLevelOrder(buildTree(1, 2, 3)))

        assertEquals(
                listOf(
                        listOf(1),
                        listOf(3, 2),
                        listOf(4, 5, 7)),
                simpleSolution2.zigzagLevelOrder(buildTree(1, 2, 3, 4, 5, null, 7)))

        assertEquals(
                listOf(
                        listOf(3),
                        listOf(20, 9),
                        listOf(15, 7)),
                simpleSolution2.zigzagLevelOrder(buildTree(3, 9, 20, null, null, 15, 7)))

        assertEquals(
                listOf(
                        listOf(0),
                        listOf(4, 2),
                        listOf(1, 3, -1),
                        listOf(8, 6, 1, 5)),
                simpleSolution2.zigzagLevelOrder(
                        buildTree(0, 2, 4, 1, null, 3, -1, 5, 1, null, 6, null, 8)))

        assertEquals(
                listOf(
                        listOf(3),
                        listOf(5, 4),
                        listOf(-7, -6),
                        listOf(-5, -7),
                        listOf(-4)),
                simpleSolution2.zigzagLevelOrder(
                        buildTree(3, 4, 5, -7, -6, null, null, -7, null, -5, null, null, null, -4)))
    }
}