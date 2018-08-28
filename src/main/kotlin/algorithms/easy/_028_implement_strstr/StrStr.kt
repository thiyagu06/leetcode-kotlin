package algorithms.easy._028_implement_strstr

/**
 * 28 - https://leetcode.com/problems/implement-strstr/description/
 */
class Solution {
    /**
     * TODO: Add Tests
     * Time: O(?)
     * Space: O(?)
     */
    fun strStr(haystack: String, needle: String): Int =
            haystack.findAnyOf(setOf(needle))?.first ?: -1
}

class SolutionWithoutLibraryMethods {

    /**
     * TODO: Add Tests
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