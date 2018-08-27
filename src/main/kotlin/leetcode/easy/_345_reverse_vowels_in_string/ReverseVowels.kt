package algorithms.easy._345_reverse_vowels_in_string

import extensions.chars.isVowel
import extensions.arrays.swap

/**
 * 345 - https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 */
class Solution {
    fun reverseVowels(s: String): String {
        val chars = s.toCharArray()
        var i = 0
        var j = s.lastIndex
        while (i < j) {
            when {
                !chars[i].isVowel() -> i++
                !chars[j].isVowel() -> j--
                else -> {
                    chars.swap(i, j)
                    i++
                    j--
                }
            }
        }

        return chars.joinToString("")
    }
}
