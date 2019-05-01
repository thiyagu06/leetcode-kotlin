package leetcode.easy._101_is_symmetric_tree

import datastructures.tree.buildTree
import org.junit.Test

import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsSymmetricTreeTest {

    private val solution = Solution()
    private val iterativeSolution = IterativeSolution()

    @Test
    fun isSymmetric() {
        assertTrue(solution.isSymmetric(null))
        assertTrue(solution.isSymmetric(buildTree(1)))
        assertTrue(solution.isSymmetric(buildTree(1, 2, 2)))

        //      1
        //     / \
        //    2   2
        //   / \ / \
        //  3  4 4  3
        assertTrue(solution.isSymmetric(buildTree(1, 2, 2, 3, 4, 4, 3)))

        //          1
        //      /       \
        //     2         2
        //    / \       / \
        //   3   4     4   3
        //  /\   /\   /\   /\
        // 5  6 7  8  8 7 6  5
        assertTrue(solution.isSymmetric(buildTree(1, 2, 2, 3, 4, 4, 3, 5, 6, 7, 8, 8, 7, 6, 5)))

        assertFalse(solution.isSymmetric(buildTree(1, 2)))

        //    1
        //   / \
        //  2   2
        //   \   \
        //    3   3
        assertFalse(solution.isSymmetric(buildTree(1, 2, 2, null, 3, null, 3)))

        //      1
        //     / \
        //    2   2
        //   / \ / \
        //  3  4 3  4
        assertFalse(solution.isSymmetric(buildTree(1, 2, 2, 3, 4, 3, 4)))

        assertFalse(solution.isSymmetric(buildTree(9, -42, -42, null, 76, 76, null, null, 13, null, 13)))
    }

    @Test
    fun isSymmetricIterative() {
        assertTrue(iterativeSolution.isSymmetric(null))
        assertTrue(iterativeSolution.isSymmetric(buildTree(1)))
        assertTrue(iterativeSolution.isSymmetric(buildTree(1, 2, 2)))

        //      1
        //     / \
        //    2   2
        //   / \ / \
        //  3  4 4  3
        assertTrue(iterativeSolution.isSymmetric(buildTree(1, 2, 2, 3, 4, 4, 3)))

        //          1
        //      /       \
        //     2         2
        //    / \       / \
        //   3   4     4   3
        //  /\   /\   /\   /\
        // 5  6 7  8  8 7 6  5
        assertTrue(iterativeSolution.isSymmetric(buildTree(1, 2, 2, 3, 4, 4, 3, 5, 6, 7, 8, 8, 7, 6, 5)))

        assertFalse(iterativeSolution.isSymmetric(buildTree(1, 2)))

        //    1
        //   / \
        //  2   2
        //   \   \
        //    3   3
        assertFalse(iterativeSolution.isSymmetric(buildTree(1, 2, 2, null, 3, null, 3)))

        //      1
        //     / \
        //    2   2
        //   / \ / \
        //  3  4 3  4
        assertFalse(iterativeSolution.isSymmetric(buildTree(1, 2, 2, 3, 4, 3, 4)))

        assertFalse(iterativeSolution.isSymmetric(buildTree(9, -42, -42, null, 76, 76, null, null, 13, null, 13)))
    }
}