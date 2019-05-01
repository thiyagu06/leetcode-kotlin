package leetcode.hard._564_find_the_closest_palindrome

import org.junit.Test

import org.junit.Assert.*

class FindClosestPalindromeTest {

    private val solution = Solution()

    @Test
    fun nearestPalindromic() {
        assertEquals("0", solution.nearestPalindromic("1"))
        assertEquals("8", solution.nearestPalindromic("9"))
        assertEquals("22", solution.nearestPalindromic("19"))
        assertEquals("99", solution.nearestPalindromic("100"))
        assertEquals("111", solution.nearestPalindromic("121"))
        assertEquals("121", solution.nearestPalindromic("123"))
        assertEquals("15351", solution.nearestPalindromic("15399"))

        // middle digit is 0
        assertEquals("20002", solution.nearestPalindromic("20001"))     // b > a
        assertEquals("9999", solution.nearestPalindromic("10000"))      // b > a
        assertEquals("10101", solution.nearestPalindromic("10087"))     // ?

        // middle digit is 9
        assertEquals("15951", solution.nearestPalindromic("15909"))     // a > c
        assertEquals("11011", solution.nearestPalindromic("10987"))     // c > a
    }

    @Test
    fun mirroring() {
        assertEquals("121", solution.mirroring("123"))
        assertEquals("11", solution.mirroring("19"))
        assertEquals("10001", solution.mirroring("10000"))
        assertEquals("10001", solution.mirroring("10087"))
        assertEquals("10901", solution.mirroring("10987"))
        assertEquals("1001", solution.mirroring("1098"))
        assertEquals("7", solution.mirroring("7"))
        assertEquals("77", solution.mirroring("79"))
        assertEquals("7777", solution.mirroring("7777"))
    }
}