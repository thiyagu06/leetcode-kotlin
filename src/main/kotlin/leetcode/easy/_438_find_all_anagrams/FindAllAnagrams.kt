package leetcode.easy._438_find_all_anagrams

import extensions.chars.asciiValue
import kotlin.collections.ArrayList
import kotlin.collections.List
import kotlin.collections.forEach
import kotlin.collections.mutableMapOf
import kotlin.collections.set


/**
 * 438 - https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */
class Solution {
    /**
     * Sliding Window
     * Credit: http://tinyurl.com/y9vaz2mf
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun findAnagrams(s: String, p: String): List<Int> {
        val result = ArrayList<Int>()
        if (s.isNullOrBlank() || p.isNullOrBlank())
            return result

        val hash = IntArray(256)                    // ASCII character hash

        for (c in p.toCharArray()) {
            hash[c.asciiValue]++
        }

        var left = 0
        var right = 0
        var count = p.length
        while (right < s.length) {
            val r = s[right]
            if (hash[r.asciiValue] >= 1) {
                count--
            }
            hash[s[right].asciiValue]--
            right++

            if (count == 0)
                result.add(left)

            val l = s[left]
            if (right - left == p.length) {
                if (hash[l.asciiValue] >= 0) {
                    count++
                }
                hash[l.asciiValue]++
                left++
            }
        }
        return result
    }
}

class SolutionTwo {
    /**
     * Sliding Window
     * Credit: http://tinyurl.com/y9vaz2mf
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun findAnagrams(s: String, p: String): List<Int> {
        val result = ArrayList<Int>()

        if (s.isNullOrBlank() || p.isNullOrBlank()) {
            return result
        }

        val hash = mutableMapOf<Char, Int>()
        p.forEach { ch ->
            hash[ch] = (hash[ch] ?: 0) + 1
        }

        var leftIdx = 0
        var rightIdx = 0
        var count = p.length    // chars in p to find in substring

        while (rightIdx < s.length) {

            val r = s[rightIdx]
            // move right every time, if s[rightIdx] is in p, decrease the count
            // current hash value >= 1 means the character exists in p and hasn't been found in current window
            if (hash.containsKey(r) && hash[r]!! >= 1) {
                count--
            }
            hash[r] = (hash[r] ?: 0) - 1
            rightIdx++

            // if the count reaches 0, it means we found an anagram. Add leftIdx to result.
            if (count == 0) {
                result.add(leftIdx)
            }

            // if we find the window's size == p.length + 1, then we have to move narrow the window.
            // hash[l] += 1 no matter what (could be negative)
            // only increase the count if the character is in p
            // the hash[l] >= 0 indicates it was originally in the hash (otherwise hash[l] would be negative).
            val l = s[leftIdx]
            val windowSize = rightIdx - leftIdx + 1
            if (windowSize > p.length) {
                if (hash.containsKey(l) && hash[l]!! >= 0) {
                    count++
                }
                hash[l] = (hash[l] ?: 0) + 1
                leftIdx++
            }

        }
        return result
    }
}

class SolutionThree {
    /**
     * Sliding Window
     * Credit: http://tinyurl.com/y9vaz2mf
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun findAnagrams(s: String, p: String): List<Int> {
        val result = ArrayList<Int>()

        if (s.isNullOrBlank() || p.isNullOrBlank())
            return result

        val hash = IntArray(256)                    // ASCII character hash

        // record each character in p to hash
        p.toCharArray().forEach { c ->
            hash[c.asciiValue]++
        }

        // two pointers; initialize count to p's length
        var leftIdx = 0
        var rightIdx = 0
        var count = p.length

        while (rightIdx < s.length) {
            // move right every time, if the character exists in p's hash, decrease the count
            // current hash value >= 1 means the character exists in p
            val r = s[rightIdx]
            if (hash[r.asciiValue] >= 1) {
                count--
            }
            hash[r.asciiValue]--
            rightIdx++

            // if the count reaches 0, it means we found the right anagram.
            // Add window's leftIdx to result
            if (count == 0)
                result.add(leftIdx)

            // if we find the window's size equals to p, then we have to move leftIdx (narrow the window) to find the
            // new match window.
            // count++ to reset the hash because we kicked out the s[leftIdx] letter
            // only increase the count if the character is in p
            // the count >= 0 indicates it was originally in the hash, cuz it won't go below 0 (?)
            val l = s[leftIdx]
            if (rightIdx - leftIdx == p.length) {
                if (hash[l.asciiValue] >= 0) {
                    count++
                }
                hash[l.asciiValue]++
                leftIdx++
            }
        }
        return result
    }
}
