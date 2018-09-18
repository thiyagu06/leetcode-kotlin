package leetcode.easy._438_find_all_anagrams

import java.util.*


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
        val list = ArrayList<Int>()
        if (s.isNullOrBlank() || p.isNullOrBlank())
            return list
        val hash = IntArray(256) //character hash
        // record each character in p to hash
        for (c in p.toCharArray()) {
            hash[c.toInt()]++
        }
        //two points, initialize count to p's length
        var left = 0
        var right = 0
        var count = p.length
        while (right < s.length) {
            // move right every time, if the character exists in p's hash, decrease the count
            // current hash value >= 1 means the character is existing in p
//            if (hash[s[right++].toInt()]-- >= 1) count--
            if (hash[s[right].toInt()] >= 1) {
                count--
            }
            hash[s[right].toInt()]--
            right++

            // when the count is down to 0, means we found the right anagram
            // then add window's left to result list
            if (count == 0)
                list.add(left)

            // if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            // ++ to reset the hash because we kicked out the left
            // only increase the count if the character is in p
            // the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length) {
                if (hash[s[left].toInt()] >= 0)
                    count++
                hash[s[left].toInt()]++
                left++
            }
        }
        return list
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

        val anagramChars = mutableMapOf<Char, Int>()
        p.forEach { ch ->
            anagramChars[ch] = (anagramChars[ch] ?: 0) + 1
        }

        // two points, initialize count to p's length
        var left = 0
        var right = 0
        var count = p.length    // chars in p to find in substring

        while (right < s.length) {
            // move right every time, if the character exists in p's anagramChars, decrease the count
            // current anagramChars value >= 1 means the character is existing in p
            val r = s[right]
            if (anagramChars[r] ?: 0 >= 1) {
                count--
            }
            anagramChars[r] = (anagramChars[r] ?: 0) - 1
            right++

            // when the count is down to 0, means we found the right anagram
            // then add window's left to result
            if (count == 0)
                result.add(left)

            // if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            // ++ to reset the anagramChars because we kicked out the left
            // only increase the count if the character is in p
            // the count >= 0 indicate it was original in the anagramChars, cuz it won't go below 0
            val l = s[left]
            if (right - left == p.length) {
                if (anagramChars[l] ?: 0 >= 0) {
                    count++
                }
                anagramChars[l] = (anagramChars[l] ?: 0) + 1
                left++
            }
        }
        return result
    }

}

