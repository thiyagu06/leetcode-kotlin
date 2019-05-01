package leetcode.easy._501_find_mode_in_bst

import datastructures.tree.bst3LevelsFull
import datastructures.tree.bstWithNulls
import datastructures.tree.buildTree
import org.junit.Assert.assertArrayEquals
import org.junit.Test

class FindModeInBSTTest {

    private val solution = Solution()

    @Test
    fun findMode() {
        assertArrayEquals(intArrayOf(), solution.findMode(null))
        assertArrayEquals(intArrayOf(2), solution.findMode(buildTree(1, null, 2, 2)))
        assertArrayEquals(intArrayOf(1, 3, 4, 5, 6, 8, 9), solution.findMode(bst3LevelsFull))
        assertArrayEquals(intArrayOf(1, 3, 4, 7, 8, 9), solution.findMode(bstWithNulls))
    }
}