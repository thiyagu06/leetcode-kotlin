package algorithms.easy._242_valid_anagram

import org.junit.Test

import org.junit.Assert.*

class ValidAnagramTest {

    private val solution = Solution()

    @Test
    fun isAnagram() {
        assertTrue(solution.isAnagram(s = "anagram", t = "nagaram"))
        assertTrue(solution.isAnagram(s = "rac", t = "car"))
        assertFalse(solution.isAnagram(s = "rat", t = "car"))
    }
}