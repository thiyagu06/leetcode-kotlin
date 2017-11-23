package algorithms.easy._028_implement_strstr

/**
 * 28 - https://leetcode.com/problems/implement-strstr/description/
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * @author nrojiani
 * @date 11/10/17
 */
class Solution {
    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun strStr(haystack: String, needle: String): Int =
            haystack.findAnyOf(setOf(needle))?.first ?: -1
}

class SolutionWithoutLibraryMethods {

    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun strStr(haystack: String, needle: String): Int {
        if (needle == "")
            return 0

        haystack.forEachIndexed { index, _ ->
            if (index + needle.length <= haystack.length
                    && haystack.substring(index, index + needle.length) == needle)
                return index
        }
        return -1
    }
}