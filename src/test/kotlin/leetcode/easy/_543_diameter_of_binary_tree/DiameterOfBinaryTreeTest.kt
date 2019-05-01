package leetcode.easy._543_diameter_of_binary_tree

import datastructures.tree.buildTree
import datastructures.tree.tree123
import datastructures.tree.tree1to5
import kotlin.test.assertEquals
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
        assertEquals(2, solution.diameterOfBinaryTree(buildTree(1, 2, null, null, 5)))
        assertEquals(3, solution.diameterOfBinaryTree(buildTree(1, 2, null, null, 5, 7)))
        assertEquals(7, solution.diameterOfBinaryTree(buildTree(1, 2, null, 3, 4, 5, null, null, null, 6, 7, null, null, 8, 9, null, null, 10, null, 11)))
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
        assertEquals(2, solution2.diameterOfBinaryTree(buildTree(1, 2, null, null, 5)))
        assertEquals(3, solution2.diameterOfBinaryTree(buildTree(1, 2, null, null, 5, 7)))
        assertEquals(7, solution2.diameterOfBinaryTree(buildTree(1, 2, null, 3, 4, 5, null, null, null, 6, 7, null, null, 8, 9, null, null, 10, null, 11)))
    }

    @Test
    fun diameterOfBinaryTree3() {
        // Global Variable is used
        val t1 = SolutionThree()
        val t2 = SolutionThree()
        val t3 = SolutionThree()
        val t4 = SolutionThree()
        val t5 = SolutionThree()
        val t6 = SolutionThree()
        val t7 = SolutionThree()
        val t8 = SolutionThree()
        val t9 = SolutionThree()
        val t10 = SolutionThree()

        assertEquals(0, t1.diameterOfBinaryTree(buildTree(1)))
        assertEquals(1, t2.diameterOfBinaryTree(buildTree(1, 2)))
        assertEquals(1, t3.diameterOfBinaryTree(buildTree(1, null, 3)))
        assertEquals(2, t4.diameterOfBinaryTree(tree123))
        assertEquals(3, t5.diameterOfBinaryTree(tree1to5))
        assertEquals(6, t6.diameterOfBinaryTree(testTree))
        assertEquals(8, t7.diameterOfBinaryTree(bigTree))
        assertEquals(2, t8.diameterOfBinaryTree(buildTree(1, 2, null, null, 5)))
        assertEquals(3, t9.diameterOfBinaryTree(buildTree(1, 2, null, null, 5, 7)))
        assertEquals(7, t10.diameterOfBinaryTree(buildTree(1, 2, null, 3, 4, 5, null, null, null, 6, 7, null, null, 8, 9, null, null, 10, null, 11)))
    }
}