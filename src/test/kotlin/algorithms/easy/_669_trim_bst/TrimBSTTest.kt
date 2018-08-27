package algorithms.easy._669_trim_bst

import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

class TrimBSTTest {

    private val solution = Solution()

    @Test
    fun trimBST() {
        assertEquals(buildTree(1, null, 2), solution.trimBST(buildTree(1, 0, 2), 1, 2))
        assertEquals(buildTree(3, 2, null, 1), solution.trimBST(buildTree(3, 0, 4, null, 2, null, null, 1), 1, 3))
        assertEquals(buildTree(1), solution.trimBST(buildTree(2, 1), 0, 1))
    }
}