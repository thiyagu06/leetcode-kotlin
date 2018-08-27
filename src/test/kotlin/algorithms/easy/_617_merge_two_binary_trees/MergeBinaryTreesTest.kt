package algorithms.easy._617_merge_two_binary_trees

import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

class MergeBinaryTreesTest {

    private val solution = Solution()

    @Test
    fun mergeTrees() {
        assertEquals(buildTree(1), solution.mergeTrees(buildTree(1), null))
        assertEquals(buildTree(1), solution.mergeTrees(null, buildTree(1)))
        assertEquals(buildTree(3, 4, 5, 5, 4, null, 7),
                solution.mergeTrees(buildTree(1, 3, 2, 5), buildTree(2, 1, 3, null, 4, null, 7)))
        assertEquals(buildTree(3, 1, 3, null, 4, null, 7),
                solution.mergeTrees(buildTree(1), buildTree(2, 1, 3, null, 4, null, 7)))
        assertEquals(buildTree(3, 4, 5, 5),
                solution.mergeTrees(buildTree(1, 3, 2, 5), buildTree(2, 1, 3)))
    }
}