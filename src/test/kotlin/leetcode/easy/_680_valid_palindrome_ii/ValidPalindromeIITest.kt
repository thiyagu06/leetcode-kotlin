package leetcode.easy._680_valid_palindrome_ii

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidPalindromeIITest {

    private val solution = Solution()

    @Test
    fun validPalindrome() {
        assertTrue(solution.validPalindrome("aba"))
        assertTrue(solution.validPalindrome("abba"))
        assertTrue(solution.validPalindrome("abbba"))
        assertTrue(solution.validPalindrome("zaba"))
        assertTrue(solution.validPalindrome("azba"))
        assertTrue(solution.validPalindrome("abza"))
        assertTrue(solution.validPalindrome("abaz"))

        assertTrue(solution.validPalindrome("abbbaa"))
        assertTrue(solution.validPalindrome("aaabbbaa"))
        assertTrue(solution.validPalindrome("abcdcdba"))
        assertFalse(solution.validPalindrome("adccad"))
        assertFalse(solution.validPalindrome("daccda"))
    }
}