package leetcode.medium._513_find_bottom_left_tree_value

import datastructures.tree.buildTree
import kotlin.test.assertEquals
import org.junit.Test

class FindBottomLeftTreeValueTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()
    private val solution4 = SolutionFour()

    @Test
    fun findBottomLeftValue() {
        assertEquals(1, solution.findBottomLeftValue(buildTree(2, 1, 3)))
        assertEquals(3, solution.findBottomLeftValue(buildTree(2, null, 3)))
        assertEquals(7, solution.findBottomLeftValue(buildTree(1, 2, 3, 4, null, 5, 6, null, null, 7)))
        assertEquals(5, solution.findBottomLeftValue(buildTree(2, 1, 3, null, null, 4, null, 5)))
        assertEquals(5, solution.findBottomLeftValue(buildTree(2, 1, 3, null, null, 4, null, null, 5)))
    }

    @Test
    fun findBottomLeftValue2() {
        assertEquals(1, solution2.findBottomLeftValue(buildTree(2, 1, 3)))
        assertEquals(3, solution2.findBottomLeftValue(buildTree(2, null, 3)))
        assertEquals(7, solution2.findBottomLeftValue(buildTree(1, 2, 3, 4, null, 5, 6, null, null, 7)))
        assertEquals(5, solution2.findBottomLeftValue(buildTree(2, 1, 3, null, null, 4, null, 5)))
        assertEquals(5, solution2.findBottomLeftValue(buildTree(2, 1, 3, null, null, 4, null, null, 5)))
    }

    @Test
    fun findBottomLeftValue3() {
        assertEquals(1, solution3.findBottomLeftValue(buildTree(2, 1, 3)))
        assertEquals(3, solution3.findBottomLeftValue(buildTree(2, null, 3)))
        assertEquals(7, solution3.findBottomLeftValue(buildTree(1, 2, 3, 4, null, 5, 6, null, null, 7)))
        assertEquals(5, solution3.findBottomLeftValue(buildTree(2, 1, 3, null, null, 4, null, 5)))
        assertEquals(5, solution3.findBottomLeftValue(buildTree(2, 1, 3, null, null, 4, null, null, 5)))
    }

    @Test
    fun findBottomLeftValue4() {
        assertEquals(1, solution4.findBottomLeftValue(buildTree(2, 1, 3)))
        assertEquals(3, solution4.findBottomLeftValue(buildTree(2, null, 3)))
        assertEquals(7, solution4.findBottomLeftValue(buildTree(1, 2, 3, 4, null, 5, 6, null, null, 7)))
        assertEquals(5, solution4.findBottomLeftValue(buildTree(2, 1, 3, null, null, 4, null, 5)))
        assertEquals(5, solution4.findBottomLeftValue(buildTree(2, 1, 3, null, null, 4, null, null, 5)))
    }
}