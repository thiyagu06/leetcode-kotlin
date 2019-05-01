package leetcode.easy._965_univalued_binary_tree

import datastructures.tree.buildTree
import datastructures.tree.tree123
import org.junit.Test

import kotlin.test.assertFalse
import kotlin.test.assertTrue

class UnivaluedBinaryTreeTest {

    private val solution = Solution()

    @Test
    fun isUnivalTree() {
        assertTrue(solution.isUnivalTree(buildTree(1, 1, 1, 1, 1, null, 1)))
        assertFalse(solution.isUnivalTree(tree123))
        assertFalse(solution.isUnivalTree(buildTree(2, 2, 2, 5, 2)))
    }
}