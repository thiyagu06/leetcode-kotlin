package leetcode.easy._290_word_pattern

import com.google.common.collect.HashBiMap

/**
 * 290 - https://leetcode.com/problems/word-pattern/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun wordPattern(pattern: String, str: String): Boolean {
        val words = str.split(" ").filter { it.isNotBlank() }

        // not surjective
        if (pattern.length != words.size)
            return false

        val letterToWord = hashMapOf<Char, String>()
        val wordToLetter = hashMapOf<String, Char>()



        pattern.forEachIndexed { i, letter ->
            val word = words[i]

            if (letterToWord.contains(letter) && letterToWord[letter] != word)
                return false

            if (wordToLetter.contains(word) && wordToLetter[word] != letter)
                return false

            letterToWord[letter] = word
            wordToLetter[word] = letter
        }

        return true
    }
}

class Solution2 {
    /**
     * Uses Guava's BiMap.
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun wordPattern(pattern: String, str: String): Boolean {
        val words = str.split(" ").filter { it.isNotBlank() }

        if (pattern.length != words.size)
            return false

        val biMap: HashBiMap<Char, String> = HashBiMap.create(maxOf(words.size, pattern.length))
        pattern.foldIndexed(biMap) { i, acc, c ->
            val bijective = (if (acc.containsKey(c)) acc[c] == words[i] else true)
                    && (if (acc.containsValue(words[i])) acc.inverse()[words[i]] == c else true)

            if (!bijective) return false

            acc[c] = words[i]
            acc
        }

        return true
    }
}