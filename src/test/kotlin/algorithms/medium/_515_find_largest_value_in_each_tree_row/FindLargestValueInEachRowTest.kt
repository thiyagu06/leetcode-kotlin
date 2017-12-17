package algorithms.medium._515_find_largest_value_in_each_tree_row

import datastructures.tree.buildTree
import datastructures.tree.tree123
import org.junit.Assert.assertEquals
import org.junit.Test

class FindLargestValueInEachRowTest {

    private val bfsSolution = Solution()
    private val dfsSolution = Solution2()

    @Test
    fun largestValuesBFS() {
        val tree = buildTree(1, 3, 2, 5, 3, null, 9)
        assertEquals(listOf(1, 3, 9), bfsSolution.largestValues(tree))
    }

    @Test
    fun largestValuesDFS() {
        assertEquals(listOf(1, 3, 9), dfsSolution.largestValues(buildTree(1, 3, 2, 5, 3, null, 9)))
    }

    @Test
    fun valuesByDepth() {
        assertEquals(mapOf(0 to listOf(1), 1 to listOf(2, 3)), dfsSolution.valuesByDepth(tree123))
    }
}