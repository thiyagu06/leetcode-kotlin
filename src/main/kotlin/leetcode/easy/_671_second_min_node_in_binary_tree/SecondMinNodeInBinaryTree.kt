package leetcode.easy._671_second_min_node_in_binary_tree

import datastructures.tree.TreeNode
import datastructures.tree.collectUnique
import datastructures.tree.isLeaf
import extensions.tuples.neitherNull

/**
 * 671 - https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun findSecondMinimumValue(root: TreeNode?): Int {
        val mins = findSecondMinimumValue(root, Pair(null, null))
        return extractResult(mins)
    }

    private fun findSecondMinimumValue(root: TreeNode?, parentMins: Pair<Int?, Int?>): Pair<Int?, Int?> {
        root ?: return parentMins

        var mins = placeValueInMins(root.`val`, parentMins)

        return when {
            root.isLeaf || mins.neitherNull() && root.`val` >= mins.second!! -> mins
            else -> {
                mins = findSecondMinimumValue(root.left, mins)
                mins = findSecondMinimumValue(root.right, mins)
                mins
            }
        }

    }

    internal fun placeValueInMins(value: Int, mins: Pair<Int?, Int?>): Pair<Int?, Int?> =
            when {
                mins.first == null -> Pair(value, null)
                value == mins.first -> mins
                mins.second == null ->
                    Pair(minOf(mins.first!!, value), maxOf(mins.first!!, value))

                value < mins.first!! -> Pair(value, mins.first)
                value > mins.first!! && value < mins.second!! -> Pair(mins.first, value)
                else -> mins    // value == mins.first || value >= mins.second!! -> mins
            }

    private fun extractResult(mins: Pair<Int?, Int?>): Int = mins.second ?: -1
}

class Solution2 {
    /**
     * Same complexity, but much simpler
     * Time: O(n)
     * Space: O(n)
     */
    fun findSecondMinimumValue(root: TreeNode?): Int {
        val treeValues = root.collectUnique()
        val firstMin = root!!.`val`
        val secondMin = treeValues.fold(Int.MAX_VALUE) { acc, n ->
            if (n > firstMin && n < acc) n else acc
        }
        return if (secondMin == Int.MAX_VALUE) -1 else secondMin
    }
}

class Solution3 {
    /**
     * Approach 2 - https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/solution/
     * Time: O(n)
     * Space: O(n)
     */
    fun findSecondMinimumValue(root: TreeNode?): Int {
        root ?: return -1

        val secondMin = findSecondMinimumValue(root, firstMin = root.`val`)
        return if (secondMin < Long.MAX_VALUE) secondMin.toInt() else -1
    }


    private fun findSecondMinimumValue(root: TreeNode?, firstMin: Int, secondMin: Long = Long.MAX_VALUE): Long {
        root ?: return secondMin

        var newSecondMin = secondMin
        if (root.`val` > firstMin && root.`val` < secondMin) {
            newSecondMin = root.`val`.toLong()
        } else if (root.`val` == firstMin) {
            newSecondMin = findSecondMinimumValue(root.left, firstMin, newSecondMin)
            newSecondMin = findSecondMinimumValue(root.right, firstMin, newSecondMin)
        }
        return newSecondMin
    }
}