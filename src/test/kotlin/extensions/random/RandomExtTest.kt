package extensions.random

import kotlin.test.assertTrue
import org.junit.Test
import java.security.SecureRandom
import java.util.Random
import java.util.concurrent.ThreadLocalRandom

class RandomExtTest {
    @Test
    fun testGetRandomNumberGenerator() {
        var standardRandom = getRandomNumberGenerator(RNGSecurityLevel.STANDARD)
        assertTrue(standardRandom is Random)

        standardRandom = getRandomNumberGenerator(RNGSecurityLevel.STANDARD, threadLocal = false)
        assertTrue(standardRandom is Random)

        val threadLocalRandom = getRandomNumberGenerator(RNGSecurityLevel.STANDARD, threadLocal = true)
        assertTrue(threadLocalRandom is ThreadLocalRandom)

        val secureRandom = getRandomNumberGenerator(RNGSecurityLevel.CRYPTOGRAPHICALLY_SECURE)
        assertTrue(secureRandom is SecureRandom)
    }
}