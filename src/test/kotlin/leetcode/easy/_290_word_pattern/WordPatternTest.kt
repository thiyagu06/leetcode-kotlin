package leetcode.easy._290_word_pattern

import org.junit.Test

import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WordPatternTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun wordPattern() {
        assertTrue(solution.wordPattern("abba", "dog cat cat dog"))
        assertFalse(solution.wordPattern("abba", "dog cat cat fish"))
        assertFalse(solution.wordPattern("aaaa", "dog cat cat dog"))
        assertFalse(solution.wordPattern("abba", "dog dog dog dog"))
        assertTrue(solution.wordPattern("aaaa", "dog dog dog dog"))
        assertTrue(solution.wordPattern("abba", "dog cat cat   dog"))
        assertTrue(solution.wordPattern("", ""))
        assertFalse(solution.wordPattern("jquery", "jquery"))
    }

    @Test
    fun wordPattern2() {
        assertTrue(solution2.wordPattern("abba", "dog cat cat dog"))
        assertFalse(solution2.wordPattern("abba", "dog cat cat fish"))
        assertFalse(solution2.wordPattern("aaaa", "dog cat cat dog"))
        assertFalse(solution2.wordPattern("abba", "dog dog dog dog"))
        assertTrue(solution2.wordPattern("aaaa", "dog dog dog dog"))
        assertTrue(solution2.wordPattern("abba", "dog cat cat   dog"))
        assertTrue(solution2.wordPattern("", ""))
        assertFalse(solution2.wordPattern("jquery", "jquery"))
    }
}