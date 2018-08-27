package algorithms.easy._687_longest_univalue_path

import datastructures.tree.bst3LevelsFull
import datastructures.tree.bstWithNulls
import datastructures.tree.buildTree
import datastructures.tree.tree123
import datastructures.tree.tree1to5
import datastructures.tree.treeUnbalanced
import datastructures.tree.treeUnbalanced2
import org.junit.Test

import org.junit.Assert.*

class LongestUnivaluePathTest {

    private val solution = Solution()
    private val solution2 = Solution2()

    @Test
    fun longestUnivaluePath() {
        assertEquals(0, solution.longestUnivaluePath(tree123))
        assertEquals(0, solution.longestUnivaluePath(tree1to5))
        assertEquals(0, solution.longestUnivaluePath(bst3LevelsFull))
        assertEquals(0, solution.longestUnivaluePath(bstWithNulls))
        assertEquals(0, solution.longestUnivaluePath(buildTree(1)))
        assertEquals(1, solution.longestUnivaluePath(buildTree(1, 1)))
        assertEquals(1, solution.longestUnivaluePath(buildTree(1, null, 1)))
        assertEquals(2, solution.longestUnivaluePath(buildTree(5, 4, 5, 1, 1, 5)))
        assertEquals(2, solution.longestUnivaluePath(buildTree(1, 4, 5, 4, 4, 5)))
        assertEquals(2, solution.longestUnivaluePath(buildTree(1, 1, 1)))
        assertEquals(3, solution.longestUnivaluePath(buildTree(1, 1, 1, 1)))
        assertEquals(2, solution.longestUnivaluePath(treeUnbalanced))
        assertEquals(10, solution.longestUnivaluePath(treeUnbalanced2))
    }

    @Test
    fun longestUnivaluePath2() {
        assertEquals(0, solution2.longestUnivaluePath(tree123))
        assertEquals(0, solution2.longestUnivaluePath(tree1to5))
        assertEquals(0, solution2.longestUnivaluePath(bst3LevelsFull))
        assertEquals(0, solution2.longestUnivaluePath(bstWithNulls))
        assertEquals(0, solution2.longestUnivaluePath(buildTree(1)))
        assertEquals(1, solution2.longestUnivaluePath(buildTree(1, 1)))
        assertEquals(1, solution2.longestUnivaluePath(buildTree(1, null, 1)))
        assertEquals(2, solution2.longestUnivaluePath(buildTree(5, 4, 5, 1, 1, 5)))
        assertEquals(2, solution2.longestUnivaluePath(buildTree(1, 4, 5, 4, 4, 5)))
        assertEquals(2, solution2.longestUnivaluePath(buildTree(1, 1, 1)))
        assertEquals(3, solution2.longestUnivaluePath(buildTree(1, 1, 1, 1)))
        assertEquals(2, solution2.longestUnivaluePath(treeUnbalanced))
        assertEquals(10, solution2.longestUnivaluePath(treeUnbalanced2))
    }
}