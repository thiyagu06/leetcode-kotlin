package leetcode.easy._783_min_distance_bst_nodes

import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

class MinDistanceBSTNodesTest {

    private val solution = Solution()

    @Test
    fun minDiffInBST() {
        assertEquals(2, solution.minDiffInBST(buildTree(4, 2)))
        assertEquals(1, solution.minDiffInBST(buildTree(4, 2, 6, 1, 3)))
        assertEquals(1, solution.minDiffInBST(buildTree(90, 69, null, 49, 89, null, 52, null, null, null, null)))
    }
}