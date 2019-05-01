package leetcode.easy._482_license_key_formatting

import org.junit.Test

import kotlin.test.assertEquals

class LicenseKeyFormattingTest {

    private val solution = Solution()

    @Test
    fun licenseKeyFormatting() {
        assertEquals("5F3Z-2E9W", solution.licenseKeyFormatting(S = "5F3Z-2e-9-w", K = 4))
        assertEquals("2-5G-3J", solution.licenseKeyFormatting(S = "2-5g-3-J", K = 2))
    }
}