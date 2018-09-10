package leetcode.easy._009_palindrome_number

import org.junit.Test

import org.junit.Assert.*

class PalindromeNumberTest {
    private val solution = Solution()
    private val solution2 = Solution2()

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
        assertFalse(solution.isPalindrome(1000021))

        // Overflow
        assertFalse(solution.isPalindrome(Int.MIN_VALUE))
        assertFalse(solution.isPalindrome(Int.MAX_VALUE))
    }

    @Test
    fun isPalindrome2() {
        assertTrue(solution2.isPalindrome(1))
        assertTrue(solution2.isPalindrome(11))
        assertTrue(solution2.isPalindrome(121))
        assertTrue(solution2.isPalindrome(1221))
        assertTrue(solution2.isPalindrome(12321))
        assertTrue(solution2.isPalindrome(123454321))
        assertFalse(solution2.isPalindrome(-1))
        assertFalse(solution2.isPalindrome(12))
        assertFalse(solution2.isPalindrome(1000021))

        // Overflow
        assertFalse(solution2.isPalindrome(Int.MIN_VALUE))
        assertFalse(solution2.isPalindrome(Int.MAX_VALUE))
    }


}
