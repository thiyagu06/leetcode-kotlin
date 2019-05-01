package leetcode.medium._129_sum_root_to_leaf_numbers

import datastructures.tree.buildTree
import org.junit.Test

import kotlin.test.assertEquals

class SumRootToLeafNumbersTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun sumNumbers() {
        assertEquals(25, solution.sumNumbers(buildTree(1, 2, 3)))
        assertEquals(1026, solution.sumNumbers(buildTree(4, 9, 0, 5, 1)))
    }

    @Test
    fun sumNumbers2() {
        assertEquals(25, solution2.sumNumbers(buildTree(1, 2, 3)))
        assertEquals(1026, solution2.sumNumbers(buildTree(4, 9, 0, 5, 1)))
    }
}