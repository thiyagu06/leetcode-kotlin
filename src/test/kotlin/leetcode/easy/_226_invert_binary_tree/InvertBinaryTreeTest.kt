package leetcode.easy._226_invert_binary_tree

import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

class InvertBinaryTreeTest {

    private val solution1 = Solution1()
    private val solution2 = Solution2()
    private val solution3 = Solution3()

    @Test
    fun invertTree1() {
        assertEquals(buildTree(2, 3, 1), solution1.invertTree(buildTree(2, 1, 3)))
        assertEquals(buildTree(2, null, 3), solution1.invertTree(buildTree(2, 3)))
        assertEquals(buildTree(2, 3), solution1.invertTree(buildTree(2, null, 3)))
        assertEquals(buildTree(4, 7, 2, 9, 6, 3, 1),
                solution1.invertTree(
                        buildTree(4, 2, 7, 1, 3, 6, 9)))
    }

    @Test
    fun invertTree2() {
        assertEquals(buildTree(2, 3, 1), solution2.invertTree(buildTree(2, 1, 3)))
        assertEquals(buildTree(2, null, 3), solution2.invertTree(buildTree(2, 3)))
        assertEquals(buildTree(2, 3), solution2.invertTree(buildTree(2, null, 3)))
        assertEquals(buildTree(4, 7, 2, 9, 6, 3, 1),
                solution2.invertTree(
                        buildTree(4, 2, 7, 1, 3, 6, 9)))
    }

    @Test
    fun invertTree3() {
        assertEquals(buildTree(2, 3, 1), solution3.invertTree(buildTree(2, 1, 3)))
        assertEquals(buildTree(2, null, 3), solution3.invertTree(buildTree(2, 3)))
        assertEquals(buildTree(2, 3), solution3.invertTree(buildTree(2, null, 3)))
        assertEquals(buildTree(4, 7, 2, 9, 6, 3, 1),
                solution3.invertTree(
                        buildTree(4, 2, 7, 1, 3, 6, 9)))
    }


}
