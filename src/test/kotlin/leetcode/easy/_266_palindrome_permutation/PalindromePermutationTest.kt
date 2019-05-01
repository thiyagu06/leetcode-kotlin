package leetcode.easy._266_palindrome_permutation

import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.Test

class PalindromePermutationTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun canPermutePalindrome() {
        assertFalse(solution.canPermutePalindrome("code"))
        assertTrue(solution.canPermutePalindrome("aab"))
        assertTrue(solution.canPermutePalindrome("carerac"))
        assertTrue(solution.canPermutePalindrome(""))
        assertFalse(solution.canPermutePalindrome("Aa"))
        assertFalse(solution.canPermutePalindrome("AaBb//a"))
        assertTrue(solution.canPermutePalindrome("aabbhijkkjih"))
    }

    @Test
    fun canPermutePalindrome2() {
        assertFalse(solution2.canPermutePalindrome("code"))
        assertTrue(solution2.canPermutePalindrome("aab"))
        assertTrue(solution2.canPermutePalindrome("carerac"))
        assertTrue(solution2.canPermutePalindrome(""))
        assertFalse(solution2.canPermutePalindrome("Aa"))
        assertFalse(solution2.canPermutePalindrome("AaBb//a"))
        assertTrue(solution2.canPermutePalindrome("aabbhijkkjih"))
    }
}