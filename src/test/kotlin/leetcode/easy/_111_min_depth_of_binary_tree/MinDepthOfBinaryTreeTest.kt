package leetcode.easy._111_min_depth_of_binary_tree

import datastructures.tree.bst3LevelsFull
import datastructures.tree.bstWithNulls
import datastructures.tree.buildTree
import datastructures.tree.tree123
import kotlin.test.assertEquals
import org.junit.Test

class MinDepthOfBinaryTreeTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun minDepth() {
        assertEquals(0, solution.minDepth(null))
        assertEquals(1, solution.minDepth(buildTree(1)))
        assertEquals(2, solution.minDepth(tree123))
        assertEquals(3, solution.minDepth(bst3LevelsFull))
        assertEquals(3, solution.minDepth(bstWithNulls))
    }

    @Test
    fun minDepthAlt() {
        assertEquals(0, solution2.minDepth(null))
        assertEquals(1, solution2.minDepth(buildTree(1)))
        assertEquals(2, solution2.minDepth(tree123))
        assertEquals(3, solution2.minDepth(bst3LevelsFull))
        assertEquals(3, solution2.minDepth(bstWithNulls))
    }
}
