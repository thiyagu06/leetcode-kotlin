package algorithms.easy._108_convert_sorted_array_to_bst

import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

class ConvertSortedArrayToBSTTest {

    private val solution = Solution()
    private val solutionAlt = SolutionAlt()

    @Test
    fun sortedArrayToBST() {
        assertEquals(
            buildTree(0, -3, 9, -10, null, 5),
            solution.sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))
        )

        assertEquals(
            buildTree(0, -3, 9, -10, null, 5),
            solutionAlt.sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))
        )
    }
}