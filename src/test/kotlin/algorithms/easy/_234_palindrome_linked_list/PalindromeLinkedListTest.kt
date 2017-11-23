package algorithms.easy._234_palindrome_linked_list

import datastructures.list.linkedListOf
import org.junit.Assert.*
import org.junit.Test

/**
 * @author nrojiani
 * @date 11/22/17
 */
class PalindromeLinkedListTest {

    private val solution = Solution()
    private val followup = FollowUpSolution()

    @Test
    fun isPalindrome() {
        assertTrue(solution.isPalindrome(linkedListOf(1)))
        assertTrue(solution.isPalindrome(linkedListOf(1, 1)))
        assertTrue(solution.isPalindrome(linkedListOf(1, 2, 1)))
        assertTrue(solution.isPalindrome(linkedListOf(1, 2, 2, 1)))
        assertTrue(solution.isPalindrome(linkedListOf(1, 2, 3, 2, 1)))
        assertFalse(solution.isPalindrome(linkedListOf(1, 2)))
        assertFalse(solution.isPalindrome(linkedListOf(1, 2, 2)))
    }

    @Test
    fun isPalindromeFollowup() {
        assertTrue(followup.isPalindrome(linkedListOf(1)))
        assertTrue(followup.isPalindrome(linkedListOf(1, 1)))
        assertTrue(followup.isPalindrome(linkedListOf(1, 2, 1)))
        assertTrue(followup.isPalindrome(linkedListOf(1, 2, 2, 1)))
        assertTrue(followup.isPalindrome(linkedListOf(1, 2, 3, 2, 1)))
        assertFalse(followup.isPalindrome(linkedListOf(1, 2)))
        assertFalse(followup.isPalindrome(linkedListOf(1, 2, 2)))
    }

    @Test
    fun reverseFirstXNodes() {
        assertEquals(linkedListOf(1), followup.reverseFirstXNodes(linkedListOf(1, 2, 3), 1))
        assertEquals(linkedListOf(2, 1), followup.reverseFirstXNodes(linkedListOf(1, 2, 3), 2))
        assertEquals(linkedListOf(3, 2, 1), followup.reverseFirstXNodes(linkedListOf(1, 2, 3), 3))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `reverseFirstXNodes throws exception when x is greater than the list's size`() {
        followup.reverseFirstXNodes(linkedListOf(1, 2, 3), 4)
    }
}