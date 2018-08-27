package algorithms.easy._783_min_distance_bst_nodes

import datastructures.tree.TreeNode
import datastructures.tree.collect
import extensions.lists.toPair
import kotlin.math.min

/**
 * 783 - https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 */
class Solution {
    fun minDiffInBST(root: TreeNode?): Int =
        root.collect().sorted()
            .chunkedPairs()
            .fold(Int.MAX_VALUE) { acc, (curr,  next) ->
                min(next - curr, acc)
            }
}

// Makeshift replacement for Kotlin 1.2's windowed() function
private fun <T> List<T>.chunkedPairs(partialWindows: Boolean = false): List<Pair<T, T>> {
    val resultList: ArrayList<List<T>> = arrayListOf()
    var index = 0
    while (index < this.size) {
        val windowSize = 2.coerceAtMost(this.size - index)
        if (windowSize < 2 && !partialWindows) break
        resultList.add(List(windowSize) { this[it + index] })
        index++
    }
    return resultList.map { it.toPair() }
}