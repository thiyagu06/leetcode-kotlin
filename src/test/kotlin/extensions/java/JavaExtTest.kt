package extensions.java

import org.junit.Test

import kotlin.test.assertEquals

class JavaExtTest {

    @Test
    fun repeated() {
        assertEquals(listOf(7, 7, 7), 7.repeated(3))
    }
}