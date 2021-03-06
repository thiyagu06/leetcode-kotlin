package leetcode.easy._744_find_smallest_letter_greater_than_target

import org.junit.Test

import kotlin.test.assertEquals

class FindSmallestLetterGreaterThanTargetTest {

    private val solution = Solution()

    @Test
    fun nextGreatestLetter() {
        assertEquals('c', solution.nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'a'))
        assertEquals('f', solution.nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'c'))
        assertEquals('f', solution.nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'd'))
        assertEquals('j', solution.nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'g'))
        assertEquals('c', solution.nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'j'))
        assertEquals('c', solution.nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'k'))
    }
}