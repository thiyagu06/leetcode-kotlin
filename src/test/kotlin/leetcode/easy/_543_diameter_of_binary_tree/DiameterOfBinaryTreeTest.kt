package leetcode.easy._543_diameter_of_binary_tree

import datastructures.tree.buildTree
import datastructures.tree.tree123
import datastructures.tree.tree1to5
import org.junit.Assert.assertEquals
import org.junit.Test

class DiameterOfBinaryTreeTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val testTree = buildTree(1, 2, 3, 4, null, 5, 6, null, null, null, null, 7, 8, null, null, null, 9)
    private val bigTree = buildTree(4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2)

    @Test
    fun diameterOfBinaryTree() {
        assertEquals(0, solution.diameterOfBinaryTree(buildTree(1)))
        assertEquals(1, solution.diameterOfBinaryTree(buildTree(1, 2)))
        assertEquals(1, solution.diameterOfBinaryTree(buildTree(1, null, 3)))
        assertEquals(2, solution.diameterOfBinaryTree(tree123))
        assertEquals(3, solution.diameterOfBinaryTree(tree1to5))
        assertEquals(6, solution.diameterOfBinaryTree(testTree))
        assertEquals(8, solution.diameterOfBinaryTree(bigTree))
    }

    @Test
    fun diameterOfBinaryTree2() {
        assertEquals(0, solution2.diameterOfBinaryTree(buildTree(1)))
        assertEquals(1, solution2.diameterOfBinaryTree(buildTree(1, 2)))
        assertEquals(1, solution2.diameterOfBinaryTree(buildTree(1, null, 3)))
        assertEquals(2, solution2.diameterOfBinaryTree(tree123))
        assertEquals(3, solution2.diameterOfBinaryTree(tree1to5))
        assertEquals(6, solution2.diameterOfBinaryTree(testTree))
        assertEquals(8, solution2.diameterOfBinaryTree(bigTree))
    }
}