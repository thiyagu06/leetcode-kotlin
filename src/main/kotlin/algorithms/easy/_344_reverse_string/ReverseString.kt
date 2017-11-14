package algorithms.easy._344_reverse_string

/**
 * 344 - https://leetcode.com/problems/reverse-string/description/
 *
 * @author nrojiani
 * @date 11/8/17
 */
class Solution {
    /*
     The easy way:
     fun reverseString(s: String): String = s.reversed()
     */

    fun reverseString(s: String): String {
        val chars = s.toCharArray()
        var (i, j) = (0 to s.lastIndex)
        while (i < j) {
            val temp = chars[i]
            chars[i] = chars[j]
            chars[j] = temp
            i++
            j--
        }
        return chars.joinToString("")
    }
}