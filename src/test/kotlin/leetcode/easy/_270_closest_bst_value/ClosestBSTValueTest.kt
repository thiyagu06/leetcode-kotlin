package leetcode.easy._270_closest_bst_value

import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

class ClosestBSTValueTest {

    private val solution = Solution()

    @Test
    fun closestValue() {
        assertEquals(4, solution.closestValue(buildTree(4, 2, 5, 1, 3), 3.714286))
    }
}