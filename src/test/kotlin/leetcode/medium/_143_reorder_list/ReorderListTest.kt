package leetcode.medium._143_reorder_list

import datastructures.list.linkedListOf
import org.junit.Test

import org.junit.Assert.*

class ReorderListTest {
    private val solution = Solution()

    @Test
    fun reorderList() {
        val input1 = linkedListOf(1, 2, 3, 4)
        solution.reorderList(input1)
        println(input1.toList())
        assertEquals(linkedListOf(1, 4, 2, 3), input1)

        val input2 = linkedListOf(1, 2, 3, 4, 5)
        solution.reorderList(input2)
        println(input2.toList())
        assertEquals(linkedListOf(1, 5, 2, 4, 3), input2)
    }
}