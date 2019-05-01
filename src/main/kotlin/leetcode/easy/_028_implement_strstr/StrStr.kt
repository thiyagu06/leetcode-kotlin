package leetcode.easy._028_implement_strstr

import extensions.arrays.NOT_FOUND

/**
 * 28 - https://leetcode.com/problems/implement-strstr/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun strStr(haystack: String, needle: String): Int = haystack.indexOf(needle)
}

class SolutionTwo {

    /**
     * Without using Kotlin's [String.indexOf].
     * Time: O(?)
     * Space: O(?)
     */
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0

        for (i in 0..(haystack.length - needle.length)) {
            if (haystack.substring(i, i + needle.length) == needle) {
                return i
            }
        }
        return NOT_FOUND
    }
}

class SolutionThree {

    /**
     * Without using any std lib functions.
     * Time: O(?)
     * Space: O(?)
     */
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0

        for (i in 0..(haystack.length - needle.length)) {
            var j = 0
            while (j < needle.length) {
                if (haystack[i + j] == needle[j]) {
                    j++
                } else {
                    break
                }
            }
            if (j == needle.length) return i
        }

        return NOT_FOUND
    }
}