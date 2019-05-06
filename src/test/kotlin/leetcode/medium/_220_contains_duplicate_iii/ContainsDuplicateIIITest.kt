package leetcode.medium._220_contains_duplicate_iii

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ContainsDuplicateIIITest {

    private val solution = Solution()

    @Test
    fun containsNearbyAlmostDuplicate() {
        assertTrue(solution.containsNearbyAlmostDuplicate(intArrayOf(1, 2, 3, 1), k = 3, t = 0))
        assertTrue(solution.containsNearbyAlmostDuplicate(intArrayOf(1, 0, 1, 1), k = 1, t = 2))
        assertFalse(solution.containsNearbyAlmostDuplicate(intArrayOf(1, 5, 9, 1, 5, 9), k = 2, t = 3))
        assertFalse(solution.containsNearbyAlmostDuplicate(intArrayOf(-1, Int.MAX_VALUE), k = 2, t = 3))
    }
}