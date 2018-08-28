package algorithms.easy._125_valid_palindrome

import org.junit.Test

import org.junit.Assert.*

class ValidPalindromeTest {
    private val solution = Solution()

    @Test
    fun isPalindrome() {
        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"))
        assertFalse(solution.isPalindrome("race a car"))
    }

}