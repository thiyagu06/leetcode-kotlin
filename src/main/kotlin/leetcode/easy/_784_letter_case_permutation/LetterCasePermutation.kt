package leetcode.easy._784_letter_case_permutation

import extensions.chars.invertCase
import java.util.*

/**
 * 784 - https://leetcode.com/problems/find-pivot-index
 */
class Solution {
    /**
     * Backtracking
     *
     * Time: O(2^n) ?
     * Space: O(?)
     */
    fun letterCasePermutation(S: String): List<String> {
        val permutations = arrayListOf<String>()
        generatePermutations(S, "", permutations)
        return permutations
    }

    private fun generatePermutations(s: String, current: String, permutations: MutableList<String>) {
        when {
            s.isEmpty() -> permutations += current
            s.first().isLetter() -> {
                generatePermutations(s.drop(1), current + s.first(), permutations)
                generatePermutations(s.drop(1), current + s.first().invertCase(), permutations)
            }
            else -> generatePermutations(s.drop(1), current + s.first(), permutations)
        }
    }
}

class SolutionTwo {
    /**
     * Iterative
     *
     * Time: O(2^n) ?
     * Space: O(n)
     */
    fun letterCasePermutation(S: String): List<String> {
        val queue: Queue<String> = LinkedList()
        queue.offer(S)

        for (i in S.indices) {
            if (S[i].isDigit()) continue

            (0 until queue.size).forEach {
                val current = queue.poll()
                val chars = current.toCharArray()

                chars[i] = chars[i].toUpperCase()
                queue.offer(String(chars))

                chars[i] = chars[i].toLowerCase()
                queue.offer(String(chars))
            }
        }

        return queue.toList()
    }
}

class SolutionThree {
    /**
     * Iterative Version. Compare to Subsets I.
     *
     * Time: O(2^n) ?
     * Space: O(n)
     */
    fun letterCasePermutation(S: String): List<String> {
        val permutations: MutableList<String> = arrayListOf(S)

        for ((i, ch) in S.withIndex()) {
            if (ch.isLetter()) {
                val invertedAtIndex = permutations.map { s ->
                    s.take(i) + s[i].invertCase() + s.drop(i + 1)
                }
                permutations.addAll(invertedAtIndex)
            }
        }

        return permutations
    }
}