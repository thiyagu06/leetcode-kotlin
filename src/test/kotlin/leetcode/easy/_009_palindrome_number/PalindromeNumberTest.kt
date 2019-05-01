package leetcode.easy._009_palindrome_number

import org.junit.Test

import kotlin.test.assertTrue
import kotlin.test.assertFalse

class PalindromeNumberTest {
    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()
    private val solution4 = SolutionFour()

    @Test
    fun isPalindrome() {
        assertTrue(solution.isPalindrome(0))
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
        assertTrue(solution2.isPalindrome(0))
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

    @Test
    fun isPalindrome3() {
        assertTrue(solution3.isPalindrome(0))
        assertTrue(solution3.isPalindrome(1))
        assertTrue(solution3.isPalindrome(11))
        assertTrue(solution3.isPalindrome(121))
        assertTrue(solution3.isPalindrome(1221))
        assertTrue(solution3.isPalindrome(12321))
        assertTrue(solution3.isPalindrome(123454321))
        assertFalse(solution3.isPalindrome(-1))
        assertFalse(solution3.isPalindrome(12))
        assertFalse(solution3.isPalindrome(1000021))

        // Overflow
        assertFalse(solution3.isPalindrome(Int.MIN_VALUE))
        assertFalse(solution3.isPalindrome(Int.MAX_VALUE))
    }

    @Test
    fun isPalindrome4() {
        assertTrue(solution4.isPalindrome(0))
        assertTrue(solution4.isPalindrome(1))
        assertTrue(solution4.isPalindrome(11))
        assertTrue(solution4.isPalindrome(121))
        assertTrue(solution4.isPalindrome(1221))
        assertTrue(solution4.isPalindrome(12321))
        assertTrue(solution4.isPalindrome(123454321))
        assertFalse(solution4.isPalindrome(-1))
        assertFalse(solution4.isPalindrome(12))
        assertFalse(solution4.isPalindrome(1000021))

        // Overflow
        assertFalse(solution4.isPalindrome(Int.MIN_VALUE))
        assertFalse(solution4.isPalindrome(Int.MAX_VALUE))
    }
}
