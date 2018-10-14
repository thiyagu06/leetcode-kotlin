package leetcode.easy._606_construct_string_from_binary_tree

import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

class ConstructStringFromBinaryTreeTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun tree2str() {
        assertEquals("", solution.tree2str(null))
        assertEquals("1", solution.tree2str(buildTree(1)))
        assertEquals("1(2)", solution.tree2str(buildTree(1, 2)))
        assertEquals("1()(3)", solution.tree2str(buildTree(1, null, 3)))
        assertEquals("1(2)(3)", solution.tree2str(buildTree(1, 2, 3)))
        assertEquals("1(2(4))(3)", solution.tree2str(buildTree(1, 2, 3, 4)))
        assertEquals("1(2()(4))(3)", solution.tree2str(buildTree(1, 2, 3, null, 4)))
        assertEquals("1(2(4)(5))(3(6)(7))", solution.tree2str(buildTree(1, 2, 3, 4, 5, 6, 7)))
        assertEquals("1(2(4(8)(9))(5(10)(11)))(3(6(12)(13))(7(14)(15)))",
                solution.tree2str(buildTree(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)))
    }

    @Test
    fun tree2str2() {
        assertEquals("", solution2.tree2str(null))
        assertEquals("1", solution2.tree2str(buildTree(1)))
        assertEquals("1(2)", solution2.tree2str(buildTree(1, 2)))
        assertEquals("1()(3)", solution2.tree2str(buildTree(1, null, 3)))
        assertEquals("1(2)(3)", solution2.tree2str(buildTree(1, 2, 3)))
        assertEquals("1(2(4))(3)", solution2.tree2str(buildTree(1, 2, 3, 4)))
        assertEquals("1(2()(4))(3)", solution2.tree2str(buildTree(1, 2, 3, null, 4)))
        assertEquals("1(2(4)(5))(3(6)(7))", solution2.tree2str(buildTree(1, 2, 3, 4, 5, 6, 7)))
        assertEquals("1(2(4(8)(9))(5(10)(11)))(3(6(12)(13))(7(14)(15)))",
            solution2.tree2str(buildTree(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)))
    }
}