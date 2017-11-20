package algorithms.easy._111_min_depth_of_binary_tree

import datastructures.bst3LevelsFull
import datastructures.bstWithNulls
import datastructures.buildTree
import datastructures.tree123
import org.junit.Test

import org.junit.Assert.*

/**
 * @author nrojiani
 * @date 11/19/17
 */
class MinDepthOfBinaryTreeTest {

    private val solution = Solution()

    @Test
    fun minDepth() {
        assertEquals(2, solution.minDepth(tree123))
        assertEquals(3, solution.minDepth(bst3LevelsFull))
        assertEquals(3, solution.minDepth(bstWithNulls))
    }

}