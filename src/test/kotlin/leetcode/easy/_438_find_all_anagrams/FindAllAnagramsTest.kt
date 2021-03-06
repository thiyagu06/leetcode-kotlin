package leetcode.easy._438_find_all_anagrams

import org.junit.Test
import kotlin.test.assertEquals

class FindAllAnagramsTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()
    private val solution4 = SolutionFour()
    private val alpha = "abcdefghijklmnopqrstuvwxyz"
    private val bigInput = alpha.repeat(773)

    @Test
    fun findAnagrams() {
        assertEquals(listOf(0, 6), solution.findAnagrams("cbaebabacd", "abc"))
        assertEquals(listOf(0, 1, 2), solution.findAnagrams("abab", "ab"))
        assertEquals(listOf(0), solution.findAnagrams("foo", "foo"))
        assertEquals(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), solution.findAnagrams("abcabcabcabc", "abc"))
        assertEquals(listOf(0), solution.findAnagrams(bigInput, bigInput))
        assertEquals(emptyList(), solution.findAnagrams("a", "abc"))
        assertEquals(emptyList(), solution.findAnagrams("", "abc"))
    }

    @Test
    fun findAnagrams2() {
        assertEquals(listOf(0, 6), solution2.findAnagrams("cbaebabacd", "abc"))
        assertEquals(listOf(0, 1, 2), solution2.findAnagrams("abab", "ab"))
        assertEquals(listOf(0), solution2.findAnagrams("foo", "foo"))
        assertEquals(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), solution2.findAnagrams("abcabcabcabc", "abc"))
        assertEquals(listOf(0), solution2.findAnagrams(bigInput, bigInput))
        assertEquals(emptyList(), solution2.findAnagrams("a", "abc"))
        assertEquals(emptyList(), solution2.findAnagrams("", "abc"))
    }

    @Test
    fun findAnagrams3() {
        assertEquals(listOf(0, 6), solution3.findAnagrams("cbaebabacd", "abc"))
        assertEquals(listOf(0, 1, 2), solution3.findAnagrams("abab", "ab"))
        assertEquals(listOf(0), solution3.findAnagrams("foo", "foo"))
        assertEquals(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), solution3.findAnagrams("abcabcabcabc", "abc"))
        assertEquals(listOf(0), solution3.findAnagrams(bigInput, bigInput))
        assertEquals(emptyList(), solution3.findAnagrams("a", "abc"))
        assertEquals(emptyList(), solution3.findAnagrams("", "abc"))
    }

    @Test
    fun findAnagrams4() {
        assertEquals(listOf(0, 6), solution4.findAnagrams("cbaebabacd", "abc"))
        assertEquals(listOf(0, 1, 2), solution4.findAnagrams("abab", "ab"))
        assertEquals(listOf(0), solution4.findAnagrams("foo", "foo"))
        assertEquals(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), solution4.findAnagrams("abcabcabcabc", "abc"))
        assertEquals(listOf(0), solution4.findAnagrams(bigInput, bigInput))
        assertEquals(emptyList(), solution4.findAnagrams("a", "abc"))
        assertEquals(emptyList(), solution4.findAnagrams("", "abc"))
    }
}
