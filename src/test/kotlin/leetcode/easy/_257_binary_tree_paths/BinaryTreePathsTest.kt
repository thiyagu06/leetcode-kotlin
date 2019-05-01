package leetcode.easy._257_binary_tree_paths

import datastructures.tree.buildTree
import org.junit.Test

import kotlin.test.assertEquals

class BinaryTreePathsTest {
    private val solution = Solution()

    @Test
    fun binaryTreePaths() {
        assertEquals(
            listOf("1->2->5", "1->3"),
            solution.binaryTreePaths(buildTree(1, 2, 3, null, 5))
        )
    }
}