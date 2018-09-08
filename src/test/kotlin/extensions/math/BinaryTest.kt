package extensions.math

import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Test

class BinaryTest {

    @Test
    fun isEven() {
        setOf(-10, -4, 0, 2, 4, 6, 20, 100, 128).forEach { Assert.assertTrue(it.isEven()) }
        setOf(-9, -3, -1, 1, 3, 7, 21, 101, 127).forEach { Assert.assertFalse(it.isEven()) }
    }

    @Test
    fun isOdd() {
        setOf(-9, -3, -1, 1, 3, 7, 21, 101, 127).forEach { Assert.assertTrue(it.isOdd()) }
        setOf(-10, -4, 0, 2, 4, 6, 20, 100, 128).forEach { Assert.assertFalse(it.isOdd()) }
    }

    @Test
    fun toBinaryString() {
        assertEquals("00000000000000000000000000000000", 0.toBinaryString())
        assertEquals("0000000000000000", 0.toBinaryString(16))
        assertEquals("00000000", 0.toBinaryString(8))

        assertEquals("00000000000000000000000000000001", 1.toBinaryString())
        assertEquals("00000000000000000000000000000010", 2.toBinaryString())
        assertEquals("00000000000000000000000000001010", 10.toBinaryString())

        assertEquals("00000000000000000000000001100001", 97.toBinaryString())

        assertEquals("00000000000000000000000001000011", 67.toBinaryString())
        assertEquals("11111111111111111111111110111101", (-67).toBinaryString())

        assertEquals("11111111111111111111111111111111", (-1).toBinaryString())
        assertEquals("11111111111111111111111111111110", (-2).toBinaryString())

        assertEquals("01111111111111111111111111111110", (Int.MAX_VALUE - 1).toBinaryString())
        assertEquals("01111111111111111111111111111111", Int.MAX_VALUE.toBinaryString())        // 2147483647

        assertEquals("10000000000000000000000000000001", (Int.MIN_VALUE + 1).toBinaryString())
        assertEquals("10000000000000000000000000000000", Int.MIN_VALUE.toBinaryString())        // -2147483648

        // Overflow
        assertEquals(Int.MIN_VALUE.toBinaryString(), (Int.MAX_VALUE + 1).toBinaryString())
        assertEquals(Int.MAX_VALUE.toBinaryString(), (Int.MIN_VALUE - 1).toBinaryString())
    }
}