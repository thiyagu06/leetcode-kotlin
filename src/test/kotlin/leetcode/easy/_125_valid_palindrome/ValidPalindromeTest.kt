package leetcode.easy._125_valid_palindrome

import org.junit.Test

import org.junit.Assert.*

class ValidPalindromeTest {
    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun isPalindrome() {
        assertTrue(solution.isPalindrome(""))
        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"))
        assertTrue(solution.isPalindrome("9A man, a plan, a canal: Panama9"))
        assertFalse(solution.isPalindrome("race a car"))
        assertFalse(solution.isPalindrome("9A man, a plan, a canal: Panama7"))
    }

    @Test
    fun isPalindrome2() {
        assertTrue(solution2.isPalindrome(""))
        assertTrue(solution2.isPalindrome("A man, a plan, a canal: Panama"))
        assertTrue(solution2.isPalindrome("9A man, a plan, a canal: Panama9"))
        assertFalse(solution2.isPalindrome("race a car"))
        assertFalse(solution2.isPalindrome("9A man, a plan, a canal: Panama7"))
    }

}
