package leetcode.medium._015_three_sum

import extensions.arrays.valueToIndexMap
import extensions.arrays.valueToIndicesMap

/**
 * 15 - https://leetcode.com/problems/3sum/
 */
class Solution {
    /**
     * Create index map, loop i & j, and find valid c's for each a, b pair.
     *
     * Time: O(n^2)
     * Space: O(n)
     *
     * Runtime: 2660 ms
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        val zeroSumTriplets: MutableSet<List<Int>> = HashSet()
        val indexMap = nums.withIndex().groupBy(keySelector = { it.value }, valueTransform = { it.index })

        for (i in 0..(nums.lastIndex - 2)) {
            // After each i loop, we already have all triplets that begin with nums[i].
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            for (j in (i + 1) until nums.lastIndex) {
                // a = nums[i], b = nums[j]
                // Need a + b + c = 0, so c = -(a + b)
                val c = -(nums[i] + nums[j])
                indexMap[c]?.filter { k ->
                    i < k && j < k
                }?.forEach { k ->
                    zeroSumTriplets += listOf(nums[i], nums[j], nums[k])
                }
            }
        }

        return zeroSumTriplets.map { sublist -> sublist.sorted() }.distinct()
    }
}

class SolutionTwo {
    /**
     * Same as [Solution], except this tracks the pairs that have been completed (whether they
     * are part of a solution triplet or not), and in j loop, continue if we've already seen if
     * there is a triplet starting with the values at indices i & j
     *
     * Time: O(n^2)
     * Space: O(n)
     *
     * Runtime: 1740 ms
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        val zeroSumTriplets: MutableSet<List<Int>> = HashSet()
        val indexMap = nums.valueToIndicesMap()
        val completedPairs = hashSetOf<Pair<Int, Int>>()

        for (i in 0..(nums.lastIndex - 2)) {
            for (j in (i + 1) until nums.lastIndex) {
                if ((nums[i] to nums[j]) in completedPairs) {
                    continue
                }

                // a = nums[i], b = nums[j]
                // Need a + b + c = 0, so c = -(a + b)
                val c = -(nums[i] + nums[j])
                indexMap[c]?.filter { k ->
                    i < k && j < k
                }?.forEach { k ->
                    zeroSumTriplets += listOf(nums[i], nums[j], nums[k])
                    completedPairs += (nums[i] to nums[j])
                }
            }
        }

        return zeroSumTriplets.map { sublist -> sublist.sorted() }.distinct()
    }
}

class SolutionThree {
    /**
     * In this version, sort first - the indices aren't required in the solution triplets,
     * just the values
     *
     * Time: O(n^2)
     * Space: O(n)
     *
     * Runtime: 1544 ms
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val zeroSumTriplets: MutableSet<List<Int>> = HashSet()
        val indexMap = nums.valueToIndicesMap()
        val completedPairs = hashSetOf<Pair<Int, Int>>()

        for (i in 0..(nums.lastIndex - 2)) {
            for (j in (i + 1) until nums.lastIndex) {
                if ((nums[i] to nums[j]) in completedPairs) {
                    continue
                }

                // a = nums[i], b = nums[j]
                // Need a + b + c = 0, so c = -(a + b)
                val c = -(nums[i] + nums[j])
                indexMap[c]?.filter { k ->
                    k > i && k > j
                }?.forEach { k ->
                    zeroSumTriplets += listOf(nums[i], nums[j], nums[k])
                    completedPairs += (nums[i] to nums[j])
                }
            }
        }

        return zeroSumTriplets.toList()
    }
}

class SolutionFour {
    /**
     * Same as [SolutionThree], except for values in indexMap is last index, not all indices where key appears.
     * We don't need all indices since they are duplicates, and the last is most likely to be > i, j.
     *
     * Time: O(n^2)
     * Space: O(n)
     *
     * Runtime: 1136 ms
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val zeroSumTriplets: MutableSet<List<Int>> = HashSet()
        val indexMap = nums.valueToIndexMap()
        val completedPairs = hashSetOf<Pair<Int, Int>>()

        for (i in 0..(nums.lastIndex - 2)) {
            for (j in (i + 1) until nums.lastIndex) {
                if ((nums[i] to nums[j]) in completedPairs) {
                    continue
                }

                // a = nums[i], b = nums[j]
                // Need a + b + c = 0, so c = -(a + b)
                val c = -(nums[i] + nums[j])
                val k = indexMap[c] ?: -1   // index of c
                if (k > i && k > j) {
                    zeroSumTriplets += listOf(nums[i], nums[j], nums[k])
                    completedPairs += (nums[i] to nums[j])
                }
            }
        }

        return zeroSumTriplets.toList()
    }
}