package algorithms.easy._219_contains_duplicate_ii

import org.junit.Test

import org.junit.Assert.*

class ContainsDuplicatesIITest {
    private val solution = Solution()

    @Test
    fun containsNearbyDuplicate() {
        val arr = intArrayOf(3, 1, 3)
        assertFalse(solution.containsNearbyDuplicate(arr, 0))
        assertFalse(solution.containsNearbyDuplicate(arr, 1))
        assertTrue(solution.containsNearbyDuplicate(arr, 2))

        assertTrue(solution.containsNearbyDuplicate(intArrayOf(-1, -1), 1))
    }

}
