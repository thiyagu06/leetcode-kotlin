package leetcode.medium._056_merge_intervals

import datastructures.interval.Interval
import datastructures.interval.mergeWith
import datastructures.interval.overlapsWith
import java.util.*

/**
 * 56 - https://leetcode.com/problems/merge-intervals
 */
class Solution {
    /**
     * Time: O(n log(n))
     * Space: O(1)
     */
    fun merge(intervals: List<Interval>): List<Interval> {
        if (intervals.isEmpty() || intervals.size == 1) {
            return intervals
        }

        val merged = LinkedList<Interval>()

        // sort in-place:
        Collections.sort(intervals, compareBy { it.start })
        intervals.forEach { interval ->
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || !merged.last().overlapsWith(interval)) {
                merged.add(interval)
            } else {
                val mergedInterval = interval.mergeWith(merged.removeLast())
                merged.add(mergedInterval)
            }
        }

        return merged
    }
}

