package leetcode.medium._148_sort_list

import datastructures.list.linkedListOf
import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore

class SortListTest {

    private val solution = Solution()

    @Ignore("Unimplemented")
    @Test
    fun sortList() {
        assertEquals(
            linkedListOf(1, 2, 3, 4),
            solution.sortList(linkedListOf(1, 3, 2, 4))
        )

        assertEquals(
            linkedListOf(1, 2, 3, 4),
            solution.sortList(linkedListOf(1, 4, 2, 3))
        )

        assertEquals(
            linkedListOf(1, 0, 3, 4, 5),
            solution.sortList(linkedListOf(1, 5, 3, 4, 0))
        )
    }
}