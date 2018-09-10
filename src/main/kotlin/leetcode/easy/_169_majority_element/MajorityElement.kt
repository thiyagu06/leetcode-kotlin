package leetcode.easy._169_majority_element

import extensions.arrays.groupingBy

/**
 * 169 - https://leetcode.com/problems/majority-element/description/
 */

class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun majorityElement(nums: IntArray): Int = nums.groupBy { it }
        .maxBy { (key, occurrences) -> occurrences.size }!!
        .key
}

class AltSolution1 {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun majorityElement(nums: IntArray): Int = nums.groupBy { it }
        .map { (key, values) -> key to values.size }
        .maxBy { (key, freq) -> freq }!!
        .first
}

class AltSolution2 {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun majorityElement(nums: IntArray): Int = nums.groupBy { it }
        .map { (key, values) -> key to values.size }
        .filter { (n, freq) -> freq > (nums.size / 2) }
        .map { (n, _) -> n }
        .single()
}

class AltSolution3 {
    /**
     * Time: O(n log n) - sorting step
     * Space: O(n)
     */
    fun majorityElement(nums: IntArray): Int = nums.groupingBy { it }
        .eachCount()
        .entries
        .sortedByDescending { it.value }
        .first()
        .key
}

class ImperativeSolution {

    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun majorityElement(nums: IntArray): Int {
        val majorityCutoff = (nums.size / 2) + 1
        val frequencies = hashMapOf<Int, Int>()

        nums.forEach { n ->
            frequencies[n] = frequencies.getOrDefault(n, 0) + 1
            if (frequencies[n]!! >= majorityCutoff) {
                return n
            }
        }

        throw IllegalArgumentException("No majority element in nums")
    }
}
