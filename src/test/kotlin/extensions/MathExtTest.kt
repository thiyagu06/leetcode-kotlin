package extensions

import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test
import java.math.BigInteger

/**
 *
 */
class MathExtTest {
    @Ignore
    @Test
    fun powerSet() {
    }

    @Test
    fun combinations() {
        assertEquals(
                listOf(emptyList<Int>()),
                extensions.combinations(listOf(1, 2, 3), 0))

        assertEquals(
                listOf(listOf(1), listOf(2), listOf(3)),
                extensions.combinations(listOf(1, 2, 3), 1))

        assertEquals(
                listOf(listOf(1, 2), listOf(1, 3), listOf(2, 3)),
                extensions.combinations(listOf(1, 2, 3), 2))

        assertEquals(
                listOf(listOf(1, 2, 3)),
                extensions.combinations(listOf(1, 2, 3)))
    }

    @Test
    fun choose() {
        assertEquals(BigInteger.ONE, choose(0, 0))

        (0..10).forEach { i ->
            assertEquals(BigInteger.ONE, extensions.choose(i, 0))                    // C(n, 0)
            assertEquals(BigInteger.ONE, extensions.choose(i, i))                       // C(n, n)
        }

        assertEquals(BigInteger.valueOf(7L), extensions.choose(7, 1))   // C(n, 1)
        assertEquals(BigInteger.valueOf(7L), extensions.choose(7, 6))   // C(n, n-1)
        assertEquals(BigInteger.valueOf(21L), extensions.choose(7, 2))
        assertEquals(BigInteger.valueOf(21L), extensions.choose(7, 5))
        assertEquals(BigInteger.valueOf(35L), extensions.choose(7, 3))
        assertEquals(BigInteger.valueOf(35L), extensions.choose(7, 4))

        assertEquals(BigInteger.valueOf(10272278170L), extensions.choose(50, 10))
        assertEquals(BigInteger.valueOf(10272278170L), extensions.choose(50, 40))
        assertEquals(BigInteger.valueOf(121548660036300L), extensions.choose(50, 24))
        assertEquals(BigInteger.valueOf(126410606437752L), extensions.choose(50, 25))
        assertEquals(BigInteger.valueOf(121548660036300L), extensions.choose(50, 26))

        assertEquals(BigInteger.valueOf(75287520L), extensions.choose(100, 5))
        assertEquals(BigInteger("100891344545564193334812497256"), extensions.choose(100, 50))
    }
}