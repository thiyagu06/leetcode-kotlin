package algorithms.easy._111_min_depth_of_binary_tree

import datastructures.tree.bst3LevelsFull
import datastructures.tree.bstWithNulls
import datastructures.tree.tree123
import org.junit.Test

import org.junit.Assert.*

class MinDepthOfBinaryTreeTest {

    private val solution = Solution()

    @Test
    fun minDepth() {
        assertEquals(2, solution.minDepth(tree123))
        assertEquals(3, solution.minDepth(bst3LevelsFull))
        assertEquals(3, solution.minDepth(bstWithNulls))
    }

}
