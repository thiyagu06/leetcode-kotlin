package leetcode.easy._530_min_abs_diff_bst

import datastructures.tree.bst3LevelsFull
import datastructures.tree.bstWithNulls
import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

class MinAbsDifferenceTest {

    private val solution = Solution()

    @Test
    fun getMinimumDifference() {
        assertEquals(0, solution.getMinimumDifference(null))
        assertEquals(1, solution.getMinimumDifference(buildTree(1, null, 3, 2)))
        assertEquals(1, solution.getMinimumDifference(buildTree(0, null, 3, 2)))
        assertEquals(0, solution.getMinimumDifference(buildTree(3, 3)))
        assertEquals(1, solution.getMinimumDifference(bst3LevelsFull))
        assertEquals(1, solution.getMinimumDifference(bstWithNulls))
        assertEquals(9, solution.getMinimumDifference(buildTree(236, 104, 701, null, 227, null, 911)))
    }
}