package leetcode.easy._389_find_the_difference

import org.junit.Test

import org.junit.Assert.*

class FindTheDifferenceTest {

    private val solution = Solution()

    @Test
    fun findTheDifference() {
        assertEquals('e', solution.findTheDifference("abcd", "abcde"))
        assertEquals('e', solution.findTheDifference("", "e"))
        assertEquals('e', solution.findTheDifference("e", "ee"))
    }
}