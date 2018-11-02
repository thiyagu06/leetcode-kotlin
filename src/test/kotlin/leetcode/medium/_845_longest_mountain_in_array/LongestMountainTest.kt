package leetcode.medium._845_longest_mountain_in_array

import org.junit.Test

import org.junit.Assert.*

class LongestMountainTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun longestMountain() {
        assertEquals(5, solution.longestMountain(intArrayOf(2, 1, 4, 7, 3, 2, 5)))
        assertEquals(6, solution.longestMountain(intArrayOf(1, 2, 3, 2, 1, 0, 2, 3, 1)))

        assertEquals(0, solution.longestMountain(intArrayOf(2, 2, 2)))
        assertEquals(0, solution.longestMountain(intArrayOf(1, 2, 3)))
        assertEquals(0, solution.longestMountain(intArrayOf(3, 2, 3)))
        assertEquals(3, solution.longestMountain(intArrayOf(1, 2, 1)))

        // B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1], not <= & >=
        // Flat peak:
        assertEquals(0, solution.longestMountain(intArrayOf(1, 2, 3, 3, 2, 1)))
        // Mountain after: (1, 2, 1)
        assertEquals(3, solution.longestMountain(intArrayOf(1, 2, 3, 3, 2, 1, 2, 1)))
        // Flat spot during incline
        // Expected answer is 3 (1, 2, 1)
        assertEquals(3, solution.longestMountain(intArrayOf(1, 1, 2, 1)))
        // Flat spot during decline
        // Expected answer is 4 (1, 2, 3, 2)
        assertEquals(4, solution.longestMountain(intArrayOf(1, 2, 3, 2, 2, 1)))
    }

    @Test
    fun longestMountain2() {
        assertEquals(5, solution2.longestMountain(intArrayOf(2, 1, 4, 7, 3, 2, 5)))
        assertEquals(6, solution2.longestMountain(intArrayOf(1, 2, 3, 2, 1, 0, 2, 3, 1)))

        assertEquals(0, solution2.longestMountain(intArrayOf(2, 2, 2)))
        assertEquals(0, solution2.longestMountain(intArrayOf(1, 2, 3)))
        assertEquals(0, solution2.longestMountain(intArrayOf(3, 2, 3)))
        assertEquals(3, solution2.longestMountain(intArrayOf(1, 2, 1)))

        // B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1], not <= & >=
        // Flat peak:
        assertEquals(0, solution2.longestMountain(intArrayOf(1, 2, 3, 3, 2, 1)))
        // Mountain after: (1, 2, 1)
        assertEquals(3, solution2.longestMountain(intArrayOf(1, 2, 3, 3, 2, 1, 2, 1)))
        // Flat spot during incline
        // Expected answer is 3 (1, 2, 1)
        assertEquals(3, solution2.longestMountain(intArrayOf(1, 1, 2, 1)))
        // Flat spot during decline
        // Expected answer is 4 (1, 2, 3, 2)
        assertEquals(4, solution2.longestMountain(intArrayOf(1, 2, 3, 2, 2, 1)))
    }

    @Test
    fun findIncline() {
        assertNull(solution2.findIncline(intArrayOf(1, 1, 0, 1), 0))               // 1-1
        assertNull(solution2.findIncline(intArrayOf(1, 1, 0, 1), 1))               // 1-0
        assertEquals(2..3, solution2.findIncline(intArrayOf(1, 1, 0, 1), 2))       // 0-1
        assertNull(solution2.findIncline(intArrayOf(1, 1, 0, 1), 3))               // 1-end
        assertEquals(0..2, solution2.findIncline(intArrayOf(1, 2, 3, 2, 1), 0))    // 1-2-3
        assertEquals(0..2, solution2.findIncline(intArrayOf(1, 2, 3, 3, 2, 1), 0)) // 1-2-3
    }

    @Test
    fun findDecline() {
        assertNull(solution2.findDecline(intArrayOf(1, 1, 0, 1), 0))                // 1-1
        assertEquals(1..2, solution2.findDecline(intArrayOf(1, 1, 0, 1), 1))        // 1-0
        assertNull(solution2.findDecline(intArrayOf(1, 1, 0, 1), 2))                // 0-1
        assertNull(solution2.findDecline(intArrayOf(1, 1, 0, 1), 3))                // 1-end

        val arr = intArrayOf(1, 2, 3, 2, 3, 1)
        assertNull(solution2.findDecline(arr, 0))           // 1-2
        assertNull(solution2.findDecline(arr, 1))           // 2-3
        assertEquals(2..3, solution2.findDecline(arr, 2))   // 3-2
        assertNull(solution2.findDecline(arr, 3))           // 2-3
        assertEquals(4..5, solution2.findDecline(arr, 4))   // 3-1
    }
}