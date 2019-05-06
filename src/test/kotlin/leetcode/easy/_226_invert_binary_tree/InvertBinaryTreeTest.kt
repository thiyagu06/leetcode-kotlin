package leetcode.easy._226_invert_binary_tree

import datastructures.tree.TreeNode
import datastructures.tree.buildTree
import org.junit.After
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class InvertBinaryTreeTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()
    private val solution4 = SolutionFour()
    private val solution5 = SolutionFive()

    private var tree123: TreeNode? = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }

    @Before
    fun setUp() {
        tree123 = TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
        }
    }

    @After
    fun tearDown() {
        tree123 = null
    }

    @Test
    fun invertTree1() {
        assertEquals(buildTree(1, 3, 2), solution.invertTree(tree123))
        // test if tree123 is modified
        assertEquals(buildTree(1, 2, 3), tree123)

        assertEquals(buildTree(2, 3, 1), solution.invertTree(buildTree(2, 1, 3)))
        assertEquals(buildTree(2, null, 3), solution.invertTree(buildTree(2, 3)))
        assertEquals(buildTree(2, 3), solution.invertTree(buildTree(2, null, 3)))
        assertEquals(
            buildTree(4, 7, 2, 9, 6, 3, 1),
            solution.invertTree(
                buildTree(4, 2, 7, 1, 3, 6, 9)
            )
        )
        assertEquals(
            buildTree(20, 200, 50, 300, null, 25, 75),
            solution.invertTree(buildTree(20, 50, 200, 75, 25, null, 300))
        )
    }

    @Test
    fun invertTree2() {
        assertEquals(buildTree(1, 3, 2), solution2.invertTree(tree123))
        // test if tree123 is modified
        assertEquals(buildTree(1, 2, 3), tree123)

        assertEquals(buildTree(2, 3, 1), solution2.invertTree(buildTree(2, 1, 3)))
        assertEquals(buildTree(2, null, 3), solution2.invertTree(buildTree(2, 3)))
        assertEquals(buildTree(2, 3), solution2.invertTree(buildTree(2, null, 3)))
        assertEquals(
            buildTree(4, 7, 2, 9, 6, 3, 1),
            solution2.invertTree(
                buildTree(4, 2, 7, 1, 3, 6, 9)
            )
        )
        assertEquals(
            buildTree(20, 200, 50, 300, null, 25, 75),
            solution2.invertTree(buildTree(20, 50, 200, 75, 25, null, 300))
        )
    }

    @Test
    fun invertTree3() {
        assertEquals(buildTree(1, 3, 2), solution3.invertTree(tree123))
        // input is modified
        assertNotEquals(buildTree(1, 2, 3), tree123)

        assertEquals(buildTree(2, 3, 1), solution3.invertTree(buildTree(2, 1, 3)))
        assertEquals(buildTree(2, null, 3), solution3.invertTree(buildTree(2, 3)))
        assertEquals(buildTree(2, 3), solution3.invertTree(buildTree(2, null, 3)))
        assertEquals(
            buildTree(4, 7, 2, 9, 6, 3, 1),
            solution3.invertTree(
                buildTree(4, 2, 7, 1, 3, 6, 9)
            )
        )
        assertEquals(
            buildTree(20, 200, 50, 300, null, 25, 75),
            solution3.invertTree(buildTree(20, 50, 200, 75, 25, null, 300))
        )
    }

    @Test
    fun invertTree4() {
        assertEquals(buildTree(1, 3, 2), solution4.invertTree(tree123))
        // input is modified
        assertNotEquals(buildTree(1, 2, 3), tree123)

        assertEquals(buildTree(2, 3, 1), solution4.invertTree(buildTree(2, 1, 3)))
        assertEquals(buildTree(2, null, 3), solution4.invertTree(buildTree(2, 3)))
        assertEquals(buildTree(2, 3), solution4.invertTree(buildTree(2, null, 3)))
        assertEquals(
            buildTree(4, 7, 2, 9, 6, 3, 1),
            solution4.invertTree(
                buildTree(4, 2, 7, 1, 3, 6, 9)
            )
        )
        assertEquals(
            buildTree(20, 200, 50, 300, null, 25, 75),
            solution4.invertTree(buildTree(20, 50, 200, 75, 25, null, 300))
        )
    }

    @Test
    fun invertTree5() {
        assertEquals(buildTree(1, 3, 2), solution5.invertTree(tree123))
        // input is modified
        assertNotEquals(buildTree(1, 2, 3), tree123)

        assertEquals(buildTree(2, 3, 1), solution5.invertTree(buildTree(2, 1, 3)))
        assertEquals(buildTree(2, null, 3), solution5.invertTree(buildTree(2, 3)))
        assertEquals(buildTree(2, 3), solution5.invertTree(buildTree(2, null, 3)))
        assertEquals(
            buildTree(4, 7, 2, 9, 6, 3, 1),
            solution5.invertTree(
                buildTree(4, 2, 7, 1, 3, 6, 9)
            )
        )
        assertEquals(
            buildTree(20, 200, 50, 300, null, 25, 75),
            solution5.invertTree(buildTree(20, 50, 200, 75, 25, null, 300))
        )
    }
}
