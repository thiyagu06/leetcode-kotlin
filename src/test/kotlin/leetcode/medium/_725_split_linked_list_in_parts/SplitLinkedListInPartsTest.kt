package leetcode.medium._725_split_linked_list_in_parts

import datastructures.list.linkedListOf
import org.junit.Assert.*
import org.junit.Test

class SplitLinkedListInPartsTest {

    private val solution = Solution()

    @Test
    fun splitListToParts() {
        assertArrayEquals(
            arrayOf(linkedListOf(1, 2, 3)),
            solution.splitListToParts(linkedListOf(1, 2, 3), k = 1)
        )

        assertArrayEquals(
            arrayOf(linkedListOf(1), linkedListOf(2), linkedListOf(3)),
            solution.splitListToParts(linkedListOf(1, 2, 3), k = 3)
        )

        assertArrayEquals(
            arrayOf(linkedListOf(1), linkedListOf(2), linkedListOf(3), null),
            solution.splitListToParts(linkedListOf(1, 2, 3), k = 4)
        )

        assertArrayEquals(
                arrayOf(linkedListOf(1), linkedListOf(2), linkedListOf(3), null, null),
        solution.splitListToParts(linkedListOf(1, 2, 3), k = 5)
        )

        assertArrayEquals(
            arrayOf(linkedListOf(1), linkedListOf(2), linkedListOf(3), linkedListOf(4), null),
            solution.splitListToParts(linkedListOf(1, 2, 3, 4), k = 5)
        )

        assertArrayEquals(
            arrayOf(linkedListOf(1, 2, 3), linkedListOf(4, 5, 6), linkedListOf(7, 8, 9), linkedListOf(10, 11)),
            solution.splitListToParts(linkedListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), k = 4)
        )

        assertArrayEquals(
            arrayOf(linkedListOf(1, 2, 3, 4), linkedListOf(5, 6, 7, 8), linkedListOf(9, 10, 11, 12)),
            solution.splitListToParts(linkedListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), k = 3)
        )

        assertArrayEquals(
            arrayOf(linkedListOf(1, 2, 3), linkedListOf(4, 5, 6), linkedListOf(7, 8, 9), linkedListOf(10, 11, 12)),
            solution.splitListToParts(linkedListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), k = 4)
        )

        assertArrayEquals(
            arrayOf(linkedListOf(1, 2, 3, 4), linkedListOf(5, 6, 7), linkedListOf(8, 9, 10)),
            solution.splitListToParts(linkedListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), k = 3)
        )

        assertArrayEquals(
            arrayOf(linkedListOf(1, 2), linkedListOf(3), linkedListOf(4), linkedListOf(5), linkedListOf(6)),
            solution.splitListToParts(linkedListOf(1, 2, 3, 4, 5, 6), k = 5)
        )

        assertArrayEquals(
            arrayOf(linkedListOf(4, 7, 1, 2, 3), linkedListOf(4, 8, 9, 5)),
            solution.splitListToParts(linkedListOf(4, 7, 1, 2, 3, 4, 8, 9, 5), k = 2)
        )
    }

    @Test
    fun nodesPerBin() {
        assertArrayEquals(intArrayOf(1, 1, 1), solution.nodesPerBin(n = 3, k = 3))
        assertArrayEquals(intArrayOf(1, 1, 1, 0), solution.nodesPerBin(n = 3, k = 4))
        assertArrayEquals(intArrayOf(1, 1, 1, 0, 0), solution.nodesPerBin(n = 3, k = 5))
        assertArrayEquals(intArrayOf(1, 1, 1, 1, 0), solution.nodesPerBin(n = 4, k = 5))
        assertArrayEquals(intArrayOf(1, 1, 1, 1, 1), solution.nodesPerBin(n = 5, k = 5))
        assertArrayEquals(intArrayOf(2, 1, 1, 1, 1), solution.nodesPerBin(n = 6, k = 5))
        assertArrayEquals(intArrayOf(2, 2, 1, 1, 1), solution.nodesPerBin(n = 7, k = 5))
        assertArrayEquals(intArrayOf(2, 2, 1), solution.nodesPerBin(n = 5, k = 3))
    }
}