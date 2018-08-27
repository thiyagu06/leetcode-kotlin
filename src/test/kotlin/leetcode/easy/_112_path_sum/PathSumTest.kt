package leetcode.easy._112_path_sum

import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

class PathSumTest {
    private val solution = Solution()

    @Test
    fun hasPathSum() {
        val tree1 = buildTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)
        assertFalse(solution.hasPathSum(tree1, 21))
        assertTrue(solution.hasPathSum(tree1, 22))

        val tree2 = buildTree(1, 2)
        assertFalse(solution.hasPathSum(tree2, 1))  // must be root-to-leaf path
        assertFalse(solution.hasPathSum(tree2, 2))
    }

}
