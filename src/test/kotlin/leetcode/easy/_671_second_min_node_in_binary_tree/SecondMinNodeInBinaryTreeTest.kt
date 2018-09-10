package leetcode.easy._671_second_min_node_in_binary_tree

import datastructures.tree.buildTree
import org.junit.Assert.assertEquals
import org.junit.Test

class SecondMinNodeInBinaryTreeTest {

    private val solution = Solution()
    private val solution2 = Solution2()
    private val solution3 = Solution3()

    @Test
    fun findSecondMinimumValue() {
        assertEquals(-1, solution.findSecondMinimumValue(buildTree(2, 2, 2)))
        assertEquals(5, solution.findSecondMinimumValue(buildTree(2, 2, 5, null, null, 5, 7)))
        assertEquals(2, solution.findSecondMinimumValue(buildTree(1, 3, 1, 3, 3, 2, 1)))
        assertEquals(3, solution.findSecondMinimumValue(buildTree(1, 3, 5, 3, 3, 5, 7)))
        assertEquals(3, solution.findSecondMinimumValue(buildTree(1, 5, 3, 5, 5, 5, 3)))
        assertEquals(2, solution.findSecondMinimumValue(buildTree(1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3, 8, 4, 8, 3, 3, 1, 6, 2, 1)))
    }

    @Test
    fun findSecondMinimumValue2() {
        assertEquals(-1, solution2.findSecondMinimumValue(buildTree(2, 2, 2)))
        assertEquals(5, solution2.findSecondMinimumValue(buildTree(2, 2, 5, null, null, 5, 7)))
        assertEquals(2, solution2.findSecondMinimumValue(buildTree(1, 3, 1, 3, 3, 2, 1)))
        assertEquals(3, solution2.findSecondMinimumValue(buildTree(1, 3, 5, 3, 3, 5, 7)))
        assertEquals(3, solution2.findSecondMinimumValue(buildTree(1, 5, 3, 5, 5, 5, 3)))
        assertEquals(2, solution2.findSecondMinimumValue(buildTree(1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3, 8, 4, 8, 3, 3, 1, 6, 2, 1)))
    }

    @Test
    fun findSecondMinimumValue3() {
        assertEquals(-1, solution3.findSecondMinimumValue(buildTree(2, 2, 2)))
        assertEquals(5, solution3.findSecondMinimumValue(buildTree(2, 2, 5, null, null, 5, 7)))
        assertEquals(2, solution3.findSecondMinimumValue(buildTree(1, 3, 1, 3, 3, 2, 1)))
        assertEquals(3, solution3.findSecondMinimumValue(buildTree(1, 3, 5, 3, 3, 5, 7)))
        assertEquals(3, solution3.findSecondMinimumValue(buildTree(1, 5, 3, 5, 5, 5, 3)))
        assertEquals(2, solution3.findSecondMinimumValue(buildTree(1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3, 8, 4, 8, 3, 3, 1, 6, 2, 1)))
    }

    @Test
    fun placeValueInMins() {
        assertEquals(Pair<Int?, Int?>(9, null), solution.placeValueInMins(9, mins = Pair<Int?, Int?>(null, null)))
        assertEquals(Pair<Int?, Int?>(2, null), solution.placeValueInMins(2, mins = Pair<Int?, Int?>(null, null)))
        assertEquals(Pair<Int?, Int?>(2, null), solution.placeValueInMins(2, mins = Pair<Int?, Int?>(2, null)))
        assertEquals(Pair<Int?, Int?>(9, 12), solution.placeValueInMins(12, mins = Pair<Int?, Int?>(9, null)))
        assertEquals(Pair<Int?, Int?>(7, 9), solution.placeValueInMins(7, mins = Pair<Int?, Int?>(9, null)))
        assertEquals(Pair<Int?, Int?>(7, 9), solution.placeValueInMins(7, mins = Pair<Int?, Int?>(9, 12)))
        assertEquals(Pair<Int?, Int?>(9, 10), solution.placeValueInMins(10, mins = Pair<Int?, Int?>(9, 12)))
        assertEquals(Pair<Int?, Int?>(9, 12), solution.placeValueInMins(9, mins = Pair<Int?, Int?>(9, 12)))
        assertEquals(Pair<Int?, Int?>(9, 12), solution.placeValueInMins(12, mins = Pair<Int?, Int?>(9, 12)))
        assertEquals(Pair<Int?, Int?>(9, 12), solution.placeValueInMins(15, mins = Pair<Int?, Int?>(9, 12)))
    }
}