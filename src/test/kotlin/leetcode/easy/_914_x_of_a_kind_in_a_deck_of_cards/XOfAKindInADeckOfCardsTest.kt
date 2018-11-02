package leetcode.easy._914_x_of_a_kind_in_a_deck_of_cards

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class XOfAKindInADeckOfCardsTest {

    private val solution = Solution()

    @Test
    fun hasGroupsSizeX() {
        assertTrue(solution.hasGroupsSizeX(intArrayOf(1, 2, 3, 4, 4, 3, 2, 1)))
        assertFalse(solution.hasGroupsSizeX(intArrayOf(1, 1, 1, 2, 2, 2, 3, 3)))
        assertFalse(solution.hasGroupsSizeX(intArrayOf(1)))
        assertTrue(solution.hasGroupsSizeX(intArrayOf(1, 1)))
        assertTrue(solution.hasGroupsSizeX(intArrayOf(1, 1, 2, 2, 2, 2)))
        assertTrue(solution.hasGroupsSizeX(intArrayOf(0, 0, 0, 1, 1, 1, 2, 2, 2)))
    }
}