package algorithms.easy._101_is_symmetric_tree

import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

class IsSymmetricTreeTest {

    private val solution = Solution()

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
        //    3    3
        assertFalse(solution.isSymmetric(buildTree(1, 2, 2, null, 3, null, 3)))

        //      1
        //     / \
        //    2   2
        //   / \ / \
        //  3  4 3  4
        assertFalse(solution.isSymmetric(buildTree(1, 2, 2, 3, 4, 3, 4)))
    }
}