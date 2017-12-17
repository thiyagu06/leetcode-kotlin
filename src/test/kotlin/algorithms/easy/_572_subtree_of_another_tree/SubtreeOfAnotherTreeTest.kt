package algorithms.easy._572_subtree_of_another_tree

import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

class SubtreeOfAnotherTreeTest {

    private val solution = Solution()

    @Test
    fun isSubtree() {
        assertTrue(solution.isSubtree(buildTree(1), buildTree(1)))
        assertTrue(solution.isSubtree(buildTree(1, 2), buildTree(2)))
        assertFalse(solution.isSubtree(buildTree(1, 2, 3), buildTree(1)))
        assertTrue(solution.isSubtree(buildTree(1, 2, 3), buildTree(2)))
        assertTrue(solution.isSubtree(buildTree(1, 2, 3), buildTree(3)))
        assertTrue(solution.isSubtree(buildTree(1, 2, 3), buildTree(1, 2, 3)))
        assertTrue(solution.isSubtree(buildTree(1, 2, 3), buildTree(2)))
        assertTrue(solution.isSubtree(buildTree(1, null, 1, null, 1, 2), buildTree(1, null, 1, null, 1, 2)))
        assertTrue(solution.isSubtree(buildTree(1, null, 1, null, 1, null, 1, 2), buildTree(1, null, 1, null, 1, 2)))
        assertTrue(solution.isSubtree(
                buildTree(1,null,1,null,1,null,1,null,1,null,1,2),
                buildTree(1,null,1,null,1,null,1,null,1,null,1,2)))
        assertTrue(solution.isSubtree(
                buildTree(1,null,1,null,7,null,1,null,1,null,1,null,1,null,1,2),
                buildTree(7,null,1,null,1,null,1,null,1,null,1,2)))
        assertTrue(solution.isSubtree(
                buildTree(1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2),
                buildTree(1,null,1,null,1,null,1,null,1,null,1,2)))
        assertTrue(solution.isSubtree(
                buildTree(1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2),
                buildTree(1,null,1,null,1,null,1,null,1,null,1,2)))
        assertTrue(solution.isSubtree(
                buildTree(1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2),
                buildTree(1,null,1,null,1,null,1,null,1,null,1,2)))
        assertTrue(solution.isSubtree(
                buildTree(1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2),
                buildTree(1,null,1,null,1,null,1,null,1,null,1,2)))
        assertTrue(solution.isSubtree(
                buildTree(1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2),
                buildTree(1,null,1,null,1,null,1,null,1,null,1,2)))
        assertTrue(solution.isSubtree(
                buildTree(1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2),
                buildTree(1,null,1,null,1,null,1,null,1,null,1,2)))
        assertTrue(solution.isSubtree(
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, 2),
                buildTree(1, null, 1, null, 1, null, 1, null, 1, null, 1, 2)))

        assertFalse(solution.isSubtree(buildTree(1, 2), buildTree(1)))
        assertFalse(solution.isSubtree(buildTree(1), buildTree(2)))
        assertFalse(solution.isSubtree(buildTree(1), buildTree(1, 2)))
        assertFalse(solution.isSubtree(buildTree(1, 2, 3), buildTree(1, 2)))
    }
}