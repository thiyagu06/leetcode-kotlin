package leetcode.medium._652_find_duplicate_subtrees

import datastructures.tree.TreeNode
import datastructures.tree.buildTree
import org.junit.Test

import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FindDuplicateSubtreesTest {

    private val solution = Solution()

    @Test
    fun findDuplicateSubtrees() {
        val expected = setOf(TreeNode(4), TreeNode(2)).map { it.`val` }
        val result = solution.findDuplicateSubtrees(buildTree(1, 2, 3, 4, null, 2, 4, null, null, 4))
            .map { it!!.`val` }
        assertEquals(expected.size, result.size)
        result.forEach {
            assertTrue(it in expected)
        }
    }
}