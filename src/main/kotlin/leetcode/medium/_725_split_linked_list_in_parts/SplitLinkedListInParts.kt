package leetcode.medium._725_split_linked_list_in_parts

import datastructures.list.ListNode
import datastructures.list.size

/**
 * 725 - https://leetcode.com/problems/split-linked-list-in-parts
 */
class Solution {
    /**
     * Time: O(n + k)
     * Space: O(max(n, k))
     */
    fun splitListToParts(root: ListNode?, k: Int): Array<ListNode?> {
        /* Initialize with sentinel nodes. */
        val result = Array<ListNode?>(k) { ListNode(Int.MIN_VALUE) }    // Each index is a (possibly null) linked list

        // pointers to end nodes of each list
        val tailNodes: MutableList<ListNode?> = result.map { it }.toMutableList()

        var node: ListNode? = root  // current node in input list

        val n = root.size
        val nodesPerBin = nodesPerBin(n, k)

        for ((i, capacity) in nodesPerBin.withIndex()) {
            repeat(capacity) {
                tailNodes[i]?.next = ListNode(node!!.`val`)
                tailNodes[i] = tailNodes[i]?.next
                tailNodes[i]?.next = null

                node = node?.next
            }
        }

        /* replace sentinel nodes with first nodes */
        return result.map { it?.next }.toTypedArray()
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    internal fun nodesPerBin(n: Int, k: Int): IntArray {
        val nodesByIndex = IntArray(k)
        val numEmptyBins = if ((k - n) < 0) 0 else k - n
        val extras = if (k > n) 0 else n % k    // how many bins (from index 0) will have 1 more node than last nodes
        return when (numEmptyBins) {
            0 -> {
                nodesByIndex.indices.map { i ->
                    /* Evenly distribute, with extras going in first bins */
                    if (i < extras) (n / k) + 1 else n / k
                }
            }
            else -> (0 until k).map { i ->
                if (i < n) 1 else 0
            }
        }.toIntArray()
    }
}