package extensions

import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore
import java.math.BigInteger

/**
 *
 */
class NumberExtTest {

    @Ignore
    @Test
    fun charForDigit() {
    }

    @Ignore
    @Test
    fun valueOfNRightmostDigits() {
    }

    @Ignore
    @Test
    fun valueOfNLeftmostDigits() {
    }

    @Ignore
    @Test
    fun valueOfLeftmostDigit() {
    }

    @Ignore
    @Test
    fun valueOfRightmostDigit() {
    }

    @Ignore
    @Test
    fun numberOfDigits() {
    }

    @Ignore
    @Test
    fun digits() {
    }

    @Test
    fun factorial() {
        assertEquals(BigInteger.ONE, 0.factorial())
        assertEquals(BigInteger.ONE, 1.factorial())
        assertEquals(BigInteger.valueOf(2L), 2.factorial())
        assertEquals(BigInteger.valueOf(6L), 3.factorial())
        assertEquals(BigInteger.valueOf(24L), 4.factorial())
        assertEquals(BigInteger.valueOf(120L), 5.factorial())
        assertEquals(BigInteger.valueOf(720L), 6.factorial())
        assertEquals(BigInteger.valueOf(5040L), 7.factorial())
        assertEquals(BigInteger.valueOf(3628800L), 10.factorial())
    }

}