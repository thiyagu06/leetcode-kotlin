package leetcode.easy._058_length_of_last_word

/**
 * 58 - https://leetcode.com/problems/length-of-last-word/
 */
class Solution {
    fun lengthOfLastWord(s: String): Int = when {
        s.isBlank() -> 0
        else -> s.split(" ")
                .last { it.isNotEmpty() }
                .length
    }
}
