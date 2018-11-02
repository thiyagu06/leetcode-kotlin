package leetcode.easy._872_leaf_similar_trees

import datastructures.tree.buildTree
import datastructures.tree.tree123
import datastructures.tree.tree1to5
import org.junit.Test

import org.junit.Assert.*

class LeafSimilarTreesTest {

    private val solution = Solution()

    @Test
    fun leafSimilar() {
        assertTrue(
            solution.leafSimilar(
                buildTree(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4),
                buildTree(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8)
            )
        )
        assertTrue(solution.leafSimilar(tree1to5, tree1to5))
        assertFalse(solution.leafSimilar(tree1to5, tree123))
    }
}