package algorithms.easy._520_detect_capital

import org.junit.Test

import org.junit.Assert.*

class DetectCapitalTest {

    private val solution = Solution()

    @Test
    fun detectCapitalUse() {
        assertTrue(solution.detectCapitalUse("USA"))
        assertFalse(solution.detectCapitalUse("FlaG"))
    }
}