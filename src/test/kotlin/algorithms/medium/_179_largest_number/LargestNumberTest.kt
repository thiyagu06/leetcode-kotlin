package algorithms.medium._179_largest_number

import org.junit.Test

import org.junit.Assert.*

class LargestNumberTest {

    private val solution = Solution()

    @Test
    fun largestNumber() {
        assertEquals("210", solution.largestNumber(intArrayOf(10, 2)))
        assertEquals("9534330", solution.largestNumber(intArrayOf(3, 30, 34, 5, 9)))
        assertEquals("332331", solution.largestNumber(intArrayOf(331, 332)))
        assertEquals("0", solution.largestNumber(intArrayOf(0, 0)))
        assertEquals("0", solution.largestNumber(intArrayOf(0, 0, 0)))
        assertEquals("10", solution.largestNumber(intArrayOf(0, 1)))
        assertEquals("21474836471", solution.largestNumber(intArrayOf(Int.MAX_VALUE, 1)))
    }
}