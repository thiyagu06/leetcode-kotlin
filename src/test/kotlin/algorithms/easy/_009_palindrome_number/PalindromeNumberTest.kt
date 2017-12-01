package algorithms.easy._009_palindrome_number

import org.junit.Test

import org.junit.Assert.*

class PalindromeNumberTest {
    private val solution = Solution()

    @Test
    fun isPalindrome() {
        assertTrue(solution.isPalindrome(1))
        assertTrue(solution.isPalindrome(11))
        assertTrue(solution.isPalindrome(121))
        assertTrue(solution.isPalindrome(1221))
        assertTrue(solution.isPalindrome(12321))
        assertTrue(solution.isPalindrome(123454321))
        assertFalse(solution.isPalindrome(-1))
        assertFalse(solution.isPalindrome(12))
    }

    @Test
    fun isPalindromeOverflow() {
        assertFalse(solution.isPalindrome(Int.MIN_VALUE))
        assertFalse(solution.isPalindrome(Int.MAX_VALUE))
    }

}
