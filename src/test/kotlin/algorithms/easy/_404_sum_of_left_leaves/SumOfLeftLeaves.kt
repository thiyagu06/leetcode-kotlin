package algorithms.easy._404_sum_of_left_leaves

import datastructures.tree.bst3LevelsFull
import datastructures.tree.bstWithNulls
import datastructures.tree.buildTree
import datastructures.tree.tree123
import datastructures.tree.tree1to5
import org.junit.Test

import org.junit.Assert.*

class SumOfLeftLeaves {
    private val solution = Solution()

    @Test
    fun sumOfLeftLeaves() {
        assertEquals(2, solution.sumOfLeftLeaves(tree123))
        assertEquals(4, solution.sumOfLeftLeaves(tree1to5))
        assertEquals(7, solution.sumOfLeftLeaves(bst3LevelsFull))
        assertEquals(9, solution.sumOfLeftLeaves(bstWithNulls))
        assertEquals(24, solution.sumOfLeftLeaves(buildTree(3, 9, 20, null, null, 15, 7)))
        assertEquals(28, solution.sumOfLeftLeaves(buildTree(14, 3, 12, 9, 20, 4, null, null, null, 15, 7)))
    }

}