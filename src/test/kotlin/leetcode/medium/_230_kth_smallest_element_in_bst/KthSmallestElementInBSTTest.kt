package leetcode.medium._230_kth_smallest_element_in_bst

import datastructures.tree.bst3LevelsFull
import datastructures.tree.bstWithNulls
import datastructures.tree.buildBST
import org.junit.Test

import kotlin.test.assertEquals

class KthSmallestElementInBSTTest {

    private val solution = Solution()
    private val followup = FollowUpSolution()

    @Test
    fun kthSmallest() {
        assertEquals(1, solution.kthSmallest(buildBST(1), 1))
        assertEquals(1, solution.kthSmallest(bst3LevelsFull, 1))
        assertEquals(5, solution.kthSmallest(bst3LevelsFull, 4))
        assertEquals(9, solution.kthSmallest(bst3LevelsFull, 7))
        assertEquals(4, solution.kthSmallest(bstWithNulls, 3))
    }

    @Test
    fun kthSmallestFollowup() {
        assertEquals(1, followup.kthSmallest(buildBST(1), 1))
        assertEquals(1, followup.kthSmallest(bst3LevelsFull, 1))
        assertEquals(5, followup.kthSmallest(bst3LevelsFull, 4))
        assertEquals(9, followup.kthSmallest(bst3LevelsFull, 7))
        assertEquals(4, followup.kthSmallest(bstWithNulls, 3))
    }
}