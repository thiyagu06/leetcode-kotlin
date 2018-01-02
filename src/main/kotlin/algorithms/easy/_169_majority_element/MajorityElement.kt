package algorithms.easy._169_majority_element

/**
 * 169 - https://leetcode.com/problems/majority-element/description/
 */
class Solution {
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

class ImperativeSolution {

    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun majorityElement(nums: IntArray): Int {
        val majorityCutoff = (nums.size / 2) + 1
        val frequencies = mutableMapOf<Int, Int>()
        for (x in nums) {
            frequencies[x] = frequencies.getOrPut(x, { 0 }) + 1
            if (frequencies[x]!! >= majorityCutoff)
                return x
        }

        return -1   // will never hit here since the majority element always exists.
    }
}
