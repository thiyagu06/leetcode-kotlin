package leetcode.easy._242_valid_anagram

import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.Test

class ValidAnagramTest {

    private val solution = Solution()
    private val solutionTwo = SolutionTwo()
    private val solutionThree = SolutionThree()
    private val solutionFour = SolutionFour()

    @Test
    fun isAnagram() {
        assertTrue(solution.isAnagram(s = "anagram", t = "nagaram"))
        assertTrue(solution.isAnagram(s = "rac", t = "car"))
        assertFalse(solution.isAnagram(s = "rat", t = "car"))
        assertFalse(solution.isAnagram(s = "aa", t = "a"))
    }

    @Test
    fun isAnagram2() {
        assertTrue(solutionTwo.isAnagram(s = "anagram", t = "nagaram"))
        assertTrue(solutionTwo.isAnagram(s = "rac", t = "car"))
        assertFalse(solutionTwo.isAnagram(s = "rat", t = "car"))
        assertFalse(solutionTwo.isAnagram(s = "aa", t = "a"))
    }

    @Test
    fun isAnagram3() {
        assertTrue(solutionThree.isAnagram(s = "anagram", t = "nagaram"))
        assertTrue(solutionThree.isAnagram(s = "rac", t = "car"))
        assertFalse(solutionThree.isAnagram(s = "rat", t = "car"))
        assertFalse(solutionThree.isAnagram(s = "aa", t = "a"))
    }

    @Test
    fun isAnagram4() {
        assertTrue(solutionFour.isAnagram(s = "anagram", t = "nagaram"))
        assertTrue(solutionFour.isAnagram(s = "rac", t = "car"))
        assertFalse(solutionFour.isAnagram(s = "rat", t = "car"))
        assertFalse(solutionFour.isAnagram(s = "aa", t = "a"))
    }
}