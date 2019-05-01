package leetcode.easy._538_convert_bst_to_greater_tree

import datastructures.tree.TreeNode
import datastructures.tree.bst3LevelsFull
import datastructures.tree.buildTree
import org.junit.Test

import kotlin.test.assertEquals

class ConvertBSTToGreaterTreeTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun convertBST() {
        assertEquals(buildTree(18, 20, 13), solution.convertBST(buildTree(5, 2, 13)))
        assertEquals(
                TreeNode(28).apply {
                    left = TreeNode(35).apply {
                        left = TreeNode(36)
                        right = TreeNode(32)
                    }
                    right = TreeNode(17).apply {
                        left = TreeNode(23)
                        right = TreeNode(9)
                    }
                },
                solution.convertBST(bst3LevelsFull))
    }

    @Test
    fun convertBST2() {
        assertEquals(buildTree(18, 20, 13), solution2.convertBST(buildTree(5, 2, 13)))
        assertEquals(
            TreeNode(28).apply {
                left = TreeNode(35).apply {
                    left = TreeNode(36)
                    right = TreeNode(32)
                }
                right = TreeNode(17).apply {
                    left = TreeNode(23)
                    right = TreeNode(9)
                }
            },
            solution2.convertBST(bst3LevelsFull))
    }
}