package leetcode.medium._623_add_one_row_to_tree

import datastructures.tree.buildTree
import org.junit.Test

import kotlin.test.assertEquals

class AddOneRowToTreeTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun addOneRow() {
        assertEquals(buildTree(4, 1, 1, 2, null, null, 6, 3, 1, 5), solution.addOneRow(buildTree(4, 2, 6, 3, 1, 5), v = 1, d = 2))
        assertEquals(buildTree(4, 2, null, 1, 1, 3, null, null, 1), solution.addOneRow(buildTree(4, 2, null, 3, 1), v = 1, d = 3))
        assertEquals(buildTree(1, 4, null, 2, 6, 3, 1, 5), solution.addOneRow(buildTree(4, 2, 6, 3, 1, 5), v = 1, d = 1))
        assertEquals(buildTree(1, 1, 1), solution.addOneRow(buildTree(1), v = 1, d = 2))
    }

    @Test
    fun addOneRow2() {
        assertEquals(buildTree(4, 1, 1, 2, null, null, 6, 3, 1, 5), solution2.addOneRow(buildTree(4, 2, 6, 3, 1, 5), v = 1, d = 2))
        assertEquals(buildTree(4, 2, null, 1, 1, 3, null, null, 1), solution2.addOneRow(buildTree(4, 2, null, 3, 1), v = 1, d = 3))
        assertEquals(buildTree(1, 4, null, 2, 6, 3, 1, 5), solution2.addOneRow(buildTree(4, 2, 6, 3, 1, 5), v = 1, d = 1))
        assertEquals(buildTree(1, 1, 1), solution2.addOneRow(buildTree(1), v = 1, d = 2))
    }
}