package leetcode.hard._072_edit_distance

import kotlin.test.assertEquals
import org.junit.Test

class EditDistanceTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun minDistance() {
        assertEquals(3, solution.minDistance("kitten", "sitting"))
        assertEquals(6, solution.minDistance("algorithm", "rhythm"))
        assertEquals(5, solution.minDistance("intention", "execution"))
        assertEquals(1, solution.minDistance("cat", "cut"))
        assertEquals(3, solution.minDistance("cat", "dog"))
        assertEquals(3, solution.minDistance("saturday", "sunday"))
        assertEquals(3, solution.minDistance("sunday", "saturday"))
        assertEquals(2, solution.minDistance("sleeping", "fleeting"))
        assertEquals(5, solution.minDistance("sleep", "fleeting"))
        assertEquals(1, solution.minDistance("", "a"))
    }

    @Test
    fun minDistance2() {
        assertEquals(3, solution2.minDistance("kitten", "sitting"))
        assertEquals(6, solution2.minDistance("algorithm", "rhythm"))
        assertEquals(5, solution2.minDistance("intention", "execution"))
        assertEquals(1, solution2.minDistance("cat", "cut"))
        assertEquals(3, solution2.minDistance("cat", "dog"))
        assertEquals(3, solution2.minDistance("saturday", "sunday"))
        assertEquals(3, solution2.minDistance("sunday", "saturday"))
        assertEquals(2, solution2.minDistance("sleeping", "fleeting"))
        assertEquals(5, solution2.minDistance("sleep", "fleeting"))
        assertEquals(1, solution2.minDistance("", "a"))
    }
}