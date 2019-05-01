package leetcode.easy._108_convert_sorted_array_to_bst

import datastructures.tree.buildTree
import org.junit.Test

import kotlin.test.assertEquals

class ConvertSortedArrayToBSTTest {

    private val solution = Solution()

    @Test
    fun sortedArrayToBST() {
        assertEquals(
            buildTree(2, 1, 3, null, null, null, 4),
            solution.sortedArrayToBST(intArrayOf(1, 2, 3, 4))
        )

        assertEquals(
            buildTree(0, -10, 5, null, -3, null, 9),
            solution.sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))
        )

        assertEquals(
            buildTree(0, -3, 3, -10, -2, 1, 5, null, null, null, null, null, null, null, 9),
            solution.sortedArrayToBST(intArrayOf(-10, -3, -2, 0, 1, 3, 5, 9))
        )
    }
}
