package leetcode.medium._098_validate_bst

import datastructures.tree.bst3LevelsFull
import datastructures.tree.bstWithNulls
import datastructures.tree.buildTree
import datastructures.tree.tree123
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.Test

class ValidateBSTTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun isValidBST() {
        assertTrue(solution.isValidBST(null))
        assertTrue(solution.isValidBST(buildTree(2, 1, 3)))
        assertFalse(solution.isValidBST(tree123))
        assertTrue(solution.isValidBST(bst3LevelsFull))
        assertTrue(solution.isValidBST(bstWithNulls))
    }

    @Test
    fun checkIntOverflow() {
        assertFalse(solution.isValidBST(buildTree(Int.MIN_VALUE, Int.MIN_VALUE)))
        assertFalse(solution.isValidBST(buildTree(Int.MAX_VALUE, Int.MAX_VALUE)))
        assertFalse(solution.isValidBST(buildTree(Int.MAX_VALUE, null, Int.MAX_VALUE)))
    }

    @Test
    fun isValidBST2() {
        assertTrue(solution2.isValidBST(null))
        assertTrue(solution2.isValidBST(buildTree(2, 1, 3)))
        assertFalse(solution2.isValidBST(tree123))
        assertTrue(solution2.isValidBST(bst3LevelsFull))
        assertTrue(solution2.isValidBST(bstWithNulls))
    }

    @Test
    fun checkIntOverflow2() {
        assertFalse(solution2.isValidBST(buildTree(Int.MIN_VALUE, Int.MIN_VALUE)))
        assertFalse(solution2.isValidBST(buildTree(Int.MAX_VALUE, Int.MAX_VALUE)))
        assertFalse(solution2.isValidBST(buildTree(Int.MAX_VALUE, null, Int.MAX_VALUE)))
    }
}
