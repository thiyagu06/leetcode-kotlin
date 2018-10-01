package extensions.math

import org.junit.Assert.*
import org.junit.Test

class IntExtTest {

    @Test
    fun testMinOf() {
        assertEquals(1, minOf(1, 2, 3, 4))
    }

    @Test
    fun isEven() {
        setOf(-10, -4, 0, 2, 4, 6, 20, 100, 128).forEach { assertTrue(it.isEven) }
        setOf(-9, -3, -1, 1, 3, 7, 21, 101, 127).forEach { assertFalse(it.isEven) }
    }

    @Test
    fun isOdd() {
        setOf(-9, -3, -1, 1, 3, 7, 21, 101, 127).forEach { assertTrue(it.isOdd) }
        setOf(-10, -4, 0, 2, 4, 6, 20, 100, 128).forEach { assertFalse(it.isOdd) }
    }

    @Test
    fun charForDigit() {
        assertEquals('0', 0.charForDigit())
        assertEquals('1', 1.charForDigit())
        assertEquals('9', 9.charForDigit())
    }

    @Test
    fun digits() {
        assertEquals(listOf(0), 0.digits())
        assertEquals(listOf(1), 1.digits())
        assertEquals(listOf(9, 9), 99.digits())
        assertEquals(listOf(1, 2, 3, 4), 1234.digits())
    }

    @Test(expected = IllegalArgumentException::class)
    fun `digits throws when negative`() {
        (-7).digits()
    }

    @Test
    fun numberOfDigits() {
        assertEquals(4, 1234.numberOfDigits())
        assertEquals(2, 99.numberOfDigits())
        assertEquals(2, 10.numberOfDigits())
        assertEquals(1, 9.numberOfDigits())
        assertEquals(1, 1.numberOfDigits())
        assertEquals(1, (-1).numberOfDigits())
        assertEquals(1, (-9).numberOfDigits())
        assertEquals(2, (-10).numberOfDigits())
        assertEquals(4, (-9999).numberOfDigits())
        assertEquals(1, 0.numberOfDigits())
        assertEquals(10, Int.MAX_VALUE.numberOfDigits())
        assertEquals(10, Int.MIN_VALUE.numberOfDigits())
    }

    @Test
    fun mostSignificantDigit() {
        assertEquals(1, 123.mostSignificantDigit())
    }

    @Test
    fun leastSignificantDigit() {
        assertEquals(3, 123.leastSignificantDigit())
    }

    @Test
    fun nMostSignificantDigits() {
        assertEquals(12, 123.nMostSignificantDigits(2))
    }

    @Test
    fun nLeastSignificantDigits() {
        assertEquals(23, 123.nLeastSignificantDigits(2))
    }
}