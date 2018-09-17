package leetcode.easy._434_number_of_segments_string

/**
 * 434 - https://leetcode.com/problems/number-of-segments-in-a-string/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun countSegments(s: String): Int = s.split(' ')
        .filterNot { it.isBlank() }
        .size
}

class SolutionTwo {
    /**
     * Same solution, without using library functions.
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun countSegments(s: String): Int {
        val segments = s.splitBy(' ')
        var count = 0
        for (segment in segments) {
            if (segment.isNotEmpty()) {
                count++
            }
        }
        return count
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    private fun String.splitBy(delimiter: Char): List<String> {
        val segments = arrayListOf<String>()
        var currentSegment = ""
        forEach { ch ->
            if (ch != delimiter) {
                currentSegment += ch
            } else {
                segments += currentSegment
                currentSegment = ""
            }
        }
        if (currentSegment.isNotEmpty())
            segments += currentSegment

        return segments
    }
}