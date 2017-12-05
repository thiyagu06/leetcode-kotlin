package extensions

import org.junit.Test

import org.junit.Assert.*

/**
 * @author nrojiani
 * @date 11/20/17
 */
class StringExtTest {
    @Test
    fun reverseCharsInRange() {
        assertEquals("hlleo", "hello".reverseCharsInRange(1..3))
        assertEquals("niltok", "kotlin".reverseCharsInRange(0..5))
        assertEquals("kotlin", "kotlin".reverseCharsInRange(0..0))
        assertEquals("ktolin", "kotlin".reverseCharsInRange(1..2))
    }

    @Test(expected = StringIndexOutOfBoundsException::class)
    fun `reverseCharsInRange throws exception when range is invalid`() {
        assertEquals("kotlni", "kotlin".reverseCharsInRange(4..7))
    }

    @Test
    fun swappingCharsAt() {
        assertEquals("notlik", "kotlin".swappingCharsAt(0, 5))
        assertEquals("kntlio", "kotlin".swappingCharsAt(1, 5))
        assertEquals("kitlon", "kotlin".swappingCharsAt(1, 4))
        assertEquals("koltin", "kotlin".swappingCharsAt(2, 3))
        assertEquals("kotlin", "kotlin".swappingCharsAt(3, 3))
    }

    @Test
    fun characterFrequencies() {
        assertEquals(mapOf('k' to 1, 'o' to 1, 't' to 1, 'l' to 1, 'i' to 1, 'n' to 1),
                "kotlin".characterFrequencies())
        assertEquals(mapOf('f' to 1, 'o' to 2), "foo".characterFrequencies())
        assertEquals(mapOf('f' to 1, 'o' to 2), "FOo".characterFrequencies())
    }

}