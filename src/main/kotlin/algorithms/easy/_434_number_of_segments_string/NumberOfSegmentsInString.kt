package algorithms.easy._434_number_of_segments_string

/**
 * 434 - https://leetcode.com/problems/number-of-segments-in-a-string/description/
 */
class Solution {
    /**
     * TODO: Add Tests
     * Time: O(?)
     * Space: O(?)
     */
    fun countSegments(s: String): Int = s.split(" ")
            .filterNot { it.isBlank() }
            .size
}