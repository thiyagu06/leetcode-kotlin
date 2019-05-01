package leetcode.easy._219_contains_duplicate_ii

import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.Test

class ContainsDuplicatesIITest {
    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun containsNearbyDuplicate() {
        val arr = intArrayOf(3, 1, 3)
        assertFalse(solution.containsNearbyDuplicate(arr, 0))
        assertFalse(solution.containsNearbyDuplicate(arr, 1))
        assertTrue(solution.containsNearbyDuplicate(arr, 2))

        assertTrue(solution.containsNearbyDuplicate(intArrayOf(-1, -1), 1))
    }

    @Test
    fun containsNearbyDuplicate2() {
        val arr = intArrayOf(3, 1, 3)
        assertFalse(solution2.containsNearbyDuplicate(arr, 0))
        assertFalse(solution2.containsNearbyDuplicate(arr, 1))
        assertTrue(solution2.containsNearbyDuplicate(arr, 2))
        assertTrue(solution2.containsNearbyDuplicate(intArrayOf(-1, -1), 1))
    }
}
