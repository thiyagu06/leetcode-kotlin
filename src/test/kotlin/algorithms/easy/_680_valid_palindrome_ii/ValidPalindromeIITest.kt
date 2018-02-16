package algorithms.easy._680_valid_palindrome_ii

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ValidPalindromeIITest {

    private val solution = Solution()
    private val solution2 = Solution2()

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

    @Test
    fun validPalindrome2() {
        assertTrue(solution2.validPalindrome("aba"))
        assertTrue(solution2.validPalindrome("abba"))
        assertTrue(solution2.validPalindrome("abbba"))
        assertTrue(solution2.validPalindrome("zaba"))
        assertTrue(solution2.validPalindrome("azba"))
        assertTrue(solution2.validPalindrome("abza"))
        assertTrue(solution2.validPalindrome("abaz"))

        assertTrue(solution2.validPalindrome("abbbaa"))
        assertTrue(solution2.validPalindrome("aaabbbaa"))
        assertTrue(solution2.validPalindrome("abcdcdba"))
        assertFalse(solution2.validPalindrome("adccad"))
        assertFalse(solution2.validPalindrome("daccda"))
    }

}