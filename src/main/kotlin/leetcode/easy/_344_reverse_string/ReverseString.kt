package leetcode.easy._344_reverse_string

import extensions.arrays.swap

/**
 * 344 - https://leetcode.com/problems/reverse-string/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun reverseString(s: CharArray) {
        var (i, j) = 0 to s.lastIndex
        while (i < j) s.swap(i++, j--)
    }
}
