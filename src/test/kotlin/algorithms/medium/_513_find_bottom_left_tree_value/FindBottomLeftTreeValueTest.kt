package algorithms.medium._513_find_bottom_left_tree_value

import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

class FindBottomLeftTreeValueTest {

    private val solution = Solution()

    @Test
    fun findBottomLeftValue() {
        assertEquals(1, solution.findBottomLeftValue(buildTree(2, 1, 3)))
        assertEquals(3, solution.findBottomLeftValue(buildTree(2, null, 3)))
        assertEquals(7, solution.findBottomLeftValue(buildTree(1, 2, 3, 4, null, 5, 6, null, null, 7)))
    }
}