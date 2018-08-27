package algorithms.easy._506_relative_ranks

/**
 * 506 - https://leetcode.com/problems/relative-ranks/description/
 *
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 */
class Solution {
    /**
     * Time: O(n log n)
     * Space: O(n)
     */
    fun findRelativeRanks(nums: IntArray): Array<String> {
        // [(numsIndex, score)]
        val indexedScoresByDescendingScore = nums.withIndex().sortedByDescending { (_, score) -> score }

        // Add rankIndex: [(numsIndex, score, rankIndex)]
        val sortedByRank = indexedScoresByDescendingScore.mapIndexed { rankIndex, (numsIndex, score) ->
            Triple(numsIndex, score, rankIndex)
        }

        // Sort by numsIndex
        val sortedByOriginalIndex = sortedByRank.sortedBy { (numsIndex, _, _) -> numsIndex }

        return sortedByOriginalIndex.fold(arrayOf()) { acc, (numsIndex, score, rankIndex) ->
            val rank = rankIndex + 1
            acc + when (rank) {
                1 -> "Gold Medal"
                2 -> "Silver Medal"
                3 -> "Bronze Medal"
                else -> "$rank"
            }
        }
    }
}