package leetcode.easy._235_lca_of_bst

import datastructures.tree.buildTree
import org.junit.Assert.assertEquals
import org.junit.Test

class LowestCommonAncestorBSTTest {
    private val solution = Solution()

    private val tree = buildTree(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5)

    @Test
    fun lowestCommonAncestor() {
        assertEquals(tree, solution.lowestCommonAncestor(tree, tree?.left, tree?.right))
        assertEquals(tree?.left, solution.lowestCommonAncestor(tree, tree?.left, tree?.left?.right))
    }
}