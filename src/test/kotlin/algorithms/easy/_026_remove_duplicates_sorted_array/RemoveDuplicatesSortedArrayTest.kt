package algorithms.easy._026_remove_duplicates_sorted_array

import org.junit.Test

import org.junit.Assert.*

class RemoveDuplicatesSortedArrayTest {

    private val deduper = Solution()

    @Test
    fun removeDuplicates() {
        assertEquals(0, deduper.removeDuplicates(intArrayOf()))
        assertEquals(1, deduper.removeDuplicates(intArrayOf(1)))
        assertEquals(1, deduper.removeDuplicates(intArrayOf(1, 1)))
        assertEquals(1, deduper.removeDuplicates(intArrayOf(1, 1, 1)))
        assertEquals(2, deduper.removeDuplicates(intArrayOf(1, 1, 1, 7)))
        assertEquals(3, deduper.removeDuplicates(intArrayOf(1, 1, 1, 7, 3)))
    }

}
