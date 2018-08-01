package algorithms.easy._344_reverse_string

import org.junit.Test

import org.junit.Assert.*

class ReverseStringTest {

    private val solution = Solution()

    @Test
    fun reverseString() {
        assertEquals("cba", solution.reverseString("abc"))
        assertEquals("niltok", solution.reverseString("kotlin"))
    }
}