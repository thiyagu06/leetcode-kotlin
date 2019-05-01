package leetcode.hard._564_find_the_closest_palindrome

import extensions.math.isEven
import kotlin.math.abs
import kotlin.math.min

class Solution {
    /**
     * TODO - refactor this mess
     * See [Solutions](https://leetcode.com/problems/find-the-closest-palindrome/solution/)
     *
     * Time: O(l) - scanning, insertion, & deletion take O(l), where l is the length of the string (n).
     * Space: O(l) - Temporary variables are used to store the strings
     */
    fun nearestPalindromic(n: String): String {
        if (n.length == 1) return (n.toInt() - 1).toString()

        // a: replicate 1st half to 2nd half
        val a: String = mirroring(n)

        var diff1: Long = abs(n.toLong() - a.toLong())
        if (diff1 == 0L) {
            diff1 = Long.MAX_VALUE
        }

        // If middle digit is 0:
        // Replace it and all 0s to its left with 9s
        // e.g., "10087" -> "19987"
        var s = StringBuilder(n)
        var i = (s.length - 1) / 2     // Start at mid
        while (i >= 0 && s[i] == '0') {
            s.replace(i, i + 1, "9")   // replace i..i with '9'
            i--
        }
        if (i == 0 && s[i] == '1') {
            // If first digit is 1, delete the 1, and replace new middle digit with 9
            s.delete(0, 1)
            val mid = (s.length - 1) / 2
            s.replace(mid, mid + 1, "9")
        } else {
            //
            s.replace(i, i + 1, (s[i] - 1).toString())
        }
        val b = mirroring(s.toString())
        val diff2 = abs(n.toLong() - b.toLong())

        s = StringBuilder(n)
        i = (s.length - 1) / 2
        // If middle digit is 9:
        // replace it and all 9s to its left with 0s
        while (i >= 0 && s[i] == '9') {
            s.replace(i, i + 1, "0")
            i--
        }
        if (i < 0) {
            s.insert(0, "1")
        } else {
            s.replace(i, i + 1, (s[i] + 1).toString())
        }
        val c = mirroring(s.toString())
        val diff3 = abs(n.toLong() - c.toLong())

        return when {
            min(diff2, diff1) == diff2 && min(diff2, diff3) == diff2 -> b
            min(diff1, diff2) == diff1 && min(diff1, diff3) == diff1 -> a
            else -> c
        }
    }

    /**
     * Replicate the first half of the string to the second half.
     */
    internal fun mirroring(s: String): String {
        val n = s.length
        if (n < 2) return s

        val midIndex = s.length / 2     // 2nd middle for even-length
        val firstHalf = s.substring(0 until midIndex)     // length / 2 -> 2nd middle for even-length
        return if (n.isEven) {
            firstHalf + firstHalf.reversed()
        } else {
            firstHalf + s[midIndex] + firstHalf.reversed()
        }
    }
}