package leetcode.easy._520_detect_capital

import org.junit.Test

import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DetectCapitalTest {

    private val solution = Solution()

    @Test
    fun detectCapitalUse() {
        assertTrue(solution.detectCapitalUse("USA"))
        assertFalse(solution.detectCapitalUse("FlaG"))
    }
}