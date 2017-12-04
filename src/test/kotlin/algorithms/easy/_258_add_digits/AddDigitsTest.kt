package algorithms.easy._258_add_digits

import org.junit.Test

import org.junit.Assert.*

class AddDigitsTest {

    private val solution = Solution()

    @Test
    fun addDigits() {
        assertEquals(0, solution.addDigits(-1))
        assertEquals(0, solution.addDigits(0))
        assertEquals(1, solution.addDigits(1))
        assertEquals(9, solution.addDigits(9))
        assertEquals(2, solution.addDigits(38))
        assertEquals(6, solution.addDigits(492))
    }

}