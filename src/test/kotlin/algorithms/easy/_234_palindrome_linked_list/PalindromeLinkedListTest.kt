package algorithms.easy._234_palindrome_linked_list

import datastructures.list.linkedListOf
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PalindromeLinkedListTest {

    private val solution = Solution()
    private val followup = FollowUpSolution()

    @Test
    fun isPalindrome() {
        assertTrue(solution.isPalindrome(null))
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
        assertTrue(followup.isPalindrome(null))
        assertTrue(followup.isPalindrome(linkedListOf(1)))
        assertTrue(followup.isPalindrome(linkedListOf(1, 1)))
        assertTrue(followup.isPalindrome(linkedListOf(1, 2, 1)))
        assertTrue(followup.isPalindrome(linkedListOf(1, 2, 2, 1)))
        assertTrue(followup.isPalindrome(linkedListOf(1, 2, 3, 2, 1)))
        assertFalse(followup.isPalindrome(linkedListOf(1, 2)))
        assertFalse(followup.isPalindrome(linkedListOf(1, 2, 2)))
    }

}