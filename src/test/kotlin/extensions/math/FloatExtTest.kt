package extensions.math

import org.junit.Assert.*
import org.junit.Test

class FloatExtTest {

    @Test
    fun testMinOf() {
        assertEquals(1f, minOf(1f, 2f, 3f, 4f))
    }
}