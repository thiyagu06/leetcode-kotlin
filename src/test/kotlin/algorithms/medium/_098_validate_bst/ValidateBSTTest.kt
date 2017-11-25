package algorithms.medium._098_validate_bst

import datastructures.tree.bst3LevelsFull
import datastructures.tree.bstWithNulls
import datastructures.tree.buildTree
import datastructures.tree.tree123
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * @author nrojiani
 * @date 11/23/17
 */
class ValidateBSTTest {

    private val solution = Solution()

    @Test
    fun isValidBST() {
        assertTrue(solution.isValidBST(null))
        assertTrue(solution.isValidBST(buildTree(2, 1, 3)))
        assertFalse(solution.isValidBST(tree123))
        assertTrue(solution.isValidBST(bst3LevelsFull))
        assertTrue(solution.isValidBST(bstWithNulls))
        assertFalse(solution.isValidBST(buildTree(Int.MIN_VALUE, Int.MIN_VALUE)))
        assertFalse(solution.isValidBST(buildTree(Int.MAX_VALUE, Int.MAX_VALUE)))
    }

}