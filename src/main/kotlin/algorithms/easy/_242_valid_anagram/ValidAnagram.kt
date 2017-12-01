package algorithms.easy._242_valid_anagram

/**
 * 242 - https://leetcode.com/problems/valid-anagram/description/
 *
 * Note: You may assume the string contains only lowercase alphabets.
 */
class Solution {
    /**
     * Time: O(n log n)
     * Space: O(n)
     */
    fun isAnagram(s: String, t: String): Boolean = s.toCharArray().sorted() == t.toCharArray().sorted()
}