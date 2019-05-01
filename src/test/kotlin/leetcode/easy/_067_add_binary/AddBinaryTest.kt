package leetcode.easy._067_add_binary

import org.junit.Test

import org.junit.Assert.*

class AddBinaryTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun addBinary() {
        assertEquals("0", solution.addBinary("0", "0"))
        assertEquals("1", solution.addBinary("1", "0"))
        assertEquals("1", solution.addBinary("0", "1"))
        assertEquals("10", solution.addBinary("1", "1"))
        assertEquals("100", solution.addBinary("11", "1"))
        assertEquals("100", solution.addBinary("1", "11"))
        assertEquals("110", solution.addBinary("11", "11"))
        assertEquals("1011", solution.addBinary("1010", "1"))
        assertEquals("10101", solution.addBinary("1010", "1011"))
    }

    @Test
    fun addBinary2() {
        assertEquals("0", solution2.addBinary("0", "0"))
        assertEquals("1", solution2.addBinary("1", "0"))
        assertEquals("1", solution2.addBinary("0", "1"))
        assertEquals("10", solution2.addBinary("1", "1"))
        assertEquals("100", solution2.addBinary("11", "1"))
        assertEquals("100", solution2.addBinary("1", "11"))
        assertEquals("110", solution2.addBinary("11", "11"))
        assertEquals("1011", solution2.addBinary("1010", "1"))
        assertEquals("10101", solution2.addBinary("1010", "1011"))
    }
}