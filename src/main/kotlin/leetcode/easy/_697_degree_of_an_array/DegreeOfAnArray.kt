package leetcode.easy._697_degree_of_an_array

/**
 * 697 - https://leetcode.com/problems/degree-of-an-array/description/
 */
class Solution {
    fun findShortestSubArray(nums: IntArray): Int {
        val degreesAndRanges = findAllDegreesAndRanges(nums)
        val maxDegreeWithMinRange = degreesAndRanges.values
            .maxWith(
                compareBy<DegreeAndRange> { it.degree }
                    .thenByDescending { (it.range.last - it.range.first + 1) })!!
        return maxDegreeWithMinRange.range.last - maxDegreeWithMinRange.range.first + 1
    }

    /**
     * Returns a map of n => Pair<degree, (firstOccurrence..lastOccurrence)
     */
    internal fun findAllDegreesAndRanges(nums: IntArray): Map<Int, DegreeAndRange> =
        nums.foldIndexed(hashMapOf()) { index, acc, n ->
            val existingValue = acc[n]
            if (existingValue == null) {
                acc[n] = DegreeAndRange(1, (index..index))
            } else {
                acc[n] = DegreeAndRange(existingValue.degree + 1, (existingValue.range.start..index))
            }
            acc
        }
}

data class DegreeAndRange(val degree: Int, val range: IntRange)
