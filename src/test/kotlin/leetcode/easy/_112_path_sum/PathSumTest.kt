package leetcode.easy._112_path_sum

import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

class PathSumTest {
    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    @Test
    fun hasPathSum() {
        assertFalse(solution.hasPathSum(null, 0))   // determined by LeetCode
        val tree1 = buildTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)
        assertFalse(solution.hasPathSum(tree1, 21))
        assertTrue(solution.hasPathSum(tree1, 22))

        val tree2 = buildTree(1, 2)
        assertFalse(solution.hasPathSum(tree2, 1))  // must be root-to-leaf path
        assertFalse(solution.hasPathSum(tree2, 2))

        assertTrue(solution.hasPathSum(buildTree(-5, 3, 1), -2))
    }

    @Test
    fun hasPathSum2() {
        assertFalse(solution2.hasPathSum(null, 0))  // determined by LeetCode
        val tree1 = buildTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)
        assertFalse(solution2.hasPathSum(tree1, 21))
        assertTrue(solution2.hasPathSum(tree1, 22))

        val tree2 = buildTree(1, 2)
        assertFalse(solution2.hasPathSum(tree2, 1))  // must be root-to-leaf path
        assertFalse(solution2.hasPathSum(tree2, 2))

        assertTrue(solution2.hasPathSum(buildTree(-5, 3, 1), -2))
    }

    @Test
    fun hasPathSum3() {
        assertFalse(solution3.hasPathSum(null, 0))  // determined by LeetCode
        val tree1 = buildTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)
        assertFalse(solution3.hasPathSum(tree1, 21))
        assertTrue(solution3.hasPathSum(tree1, 22))

        val tree2 = buildTree(1, 2)
        assertFalse(solution3.hasPathSum(tree2, 1))  // must be root-to-leaf path
        assertFalse(solution3.hasPathSum(tree2, 2))

        assertTrue(solution3.hasPathSum(buildTree(-5, 3, 1), -2))
    }

}
