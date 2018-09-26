package leetcode.easy._819_most_common_word

/**
 * 819 - https://leetcode.com/problems/most-common-word/
 */
class Solution {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String =
        paragraph.split(" ", ".", ",", "!", "?", ";", "'")
            .map { it.toLowerCase() }
            .filterNot { it.isBlank() }
            .groupingBy { it }
            .eachCount()
            .filterNot { it.key in banned }
            .maxBy { it.value }!!
            .key
}