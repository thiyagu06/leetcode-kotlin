package leetcode.medium._086_partition_list

import datastructures.list.ListNode
import datastructures.list.linkedListOf
import org.junit.Test

import kotlin.test.assertEquals
import kotlin.test.assertNull

class PartitionListTest {

    private val solution = Solution()

    @Test
    fun partition() {
        assertEquals(
            linkedListOf(1, 2, 2, 4, 3, 5),
            solution.partition(head = linkedListOf(1, 4, 3, 2, 5, 2), x = 3)
        )

        /* Edge cases */
        val nullList: ListNode? = null
        assertNull(solution.partition(nullList, x = 9))

        assertEquals(
            linkedListOf(1, 3, 4, 2),
            solution.partition(head = linkedListOf(1, 3, 4, 2), x = 5)
        )
        assertEquals(
            linkedListOf(7, 9, 5),
            solution.partition(head = linkedListOf(7, 9, 5), x = 5)
        )
    }
}