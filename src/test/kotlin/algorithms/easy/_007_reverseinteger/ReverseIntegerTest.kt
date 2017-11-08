package algorithms.easy._007_reverseinteger

import org.junit.Assert.*
import org.junit.Test

/**
 * @author nrojiani
 * @date 11/7/17
 */
class ReverseIntegerTest {
    private val reverseInteger = Solution()

    @Test fun testReverse() {
        assertEquals(0, reverseInteger.reverse(0))
        assertEquals(1, reverseInteger.reverse(1))
        assertEquals(-1, reverseInteger.reverse(-1))
        assertEquals(-1, reverseInteger.reverse(-100))
        assertEquals(1001, reverseInteger.reverse(1001))
        assertEquals(-1001, reverseInteger.reverse(-1001))
        assertEquals(1234567, reverseInteger.reverse(7654321))
        assertEquals(-1234567, reverseInteger.reverse(-7654321))
        assertEquals(-1234567, reverseInteger.reverse(-76543210))
    }

    @Test fun testReverseOverflows() {
        // 8463847412 > Int.MAX_VALUE
        assertEquals(0, reverseInteger.reverse(Int.MIN_VALUE))

        // 7463847412 > Int.MAX_VALUE
        assertEquals(0, reverseInteger.reverse(Int.MAX_VALUE))
    }

}