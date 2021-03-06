package leetcode.easy._242_valid_anagram

import extensions.strings.characterFrequencies

const val NUMBER_OF_LETTERS = 26

/**
 * 242 - https://leetcode.com/problems/valid-anagram/
 *
 * Note: You may assume the string contains only lowercase alphabets.
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1) - character table used is of constant size
     */
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val charTable = IntArray(NUMBER_OF_LETTERS)

        s.forEach { c ->
            charTable[c.letterIndex()]++
        }

        t.forEach { c ->
            val cIndex = c.letterIndex()
            charTable[cIndex]--
            if (charTable[cIndex] < 0) return false
        }
        return true
    }

    /** Maps a-z to indices 0..25 */
    private fun Char.letterIndex(): Int = this.toLowerCase() - 'a'
}

class SolutionTwo {
    /**
     * Time: O(n log n)
     * Space: O(1) - ignore space used by `toCharArray()` - see https://leetcode.com/problems/valid-anagram/solution/
     */
    fun isAnagram(s: String, t: String): Boolean = s.toCharArray().sorted() == t.toCharArray().sorted()
}

class SolutionThree {
    /**
     * Time: O(n)
     * Space: O(1) - uses space for HashMaps, but size of each is limited to 26 mappings.
     */
    fun isAnagram(s: String, t: String): Boolean = s.length == t.length &&
            s.characterFrequencies() == t.characterFrequencies()
}

class SolutionFour {
    /**
     * Time: O(n)
     * Space: O(1) - uses space for HashMap, but size is limited to 26 mappings.
     */
    fun isAnagram(s: String, t: String): Boolean {
        val sChars: MutableMap<Char, Int> = HashMap()
        s.forEach { c ->
            sChars[c] = (sChars[c] ?: 0) + 1
        }

        t.forEach { c ->
            if (c in sChars) {
                sChars[c] = sChars.getValue(c) - 1
                sChars.remove(key = c, value = 0)   // if ch => 0, remove mapping
            } else {
                return false
            }
        }
        return sChars.isEmpty()
    }
}