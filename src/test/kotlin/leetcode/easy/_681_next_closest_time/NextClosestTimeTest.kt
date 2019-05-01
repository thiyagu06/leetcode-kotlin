package leetcode.easy._681_next_closest_time

import org.junit.Test

import org.junit.Assert.*

class NextClosestTimeTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun nextClosestTime() {
        // HH:M?
        assertEquals("19:39", solution.nextClosestTime("19:34"))
        // HH:??
        assertEquals("12:41", solution.nextClosestTime("12:34"))
        assertEquals("21:51", solution.nextClosestTime("21:45"))
        // H?:??
        assertEquals("11:00", solution.nextClosestTime("10:59"))
        // ??:??
        assertEquals("22:22", solution.nextClosestTime("23:59"))
        // No solution
        assertEquals("00:00", solution.nextClosestTime("00:00"))
        assertEquals("11:11", solution.nextClosestTime("11:11"))
        assertEquals("22:22", solution.nextClosestTime("22:22"))
    }

    @Test
    fun nextClosestTime2() {
        // HH:M?
        assertEquals("19:39", solution2.nextClosestTime("19:34"))
        // HH:??
        assertEquals("12:41", solution2.nextClosestTime("12:34"))
        assertEquals("21:51", solution2.nextClosestTime("21:45"))
        // H?:??
        assertEquals("11:00", solution2.nextClosestTime("10:59"))
        // ??:??
        assertEquals("22:22", solution2.nextClosestTime("23:59"))
        // No solution
        assertEquals("00:00", solution2.nextClosestTime("00:00"))
        assertEquals("11:11", solution2.nextClosestTime("11:11"))
        assertEquals("22:22", solution2.nextClosestTime("22:22"))
    }
}