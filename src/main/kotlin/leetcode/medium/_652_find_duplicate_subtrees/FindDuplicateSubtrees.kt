package leetcode.medium._652_find_duplicate_subtrees

import datastructures.tree.TreeNode
import datastructures.tree.hasLeft
import datastructures.tree.hasRight
import datastructures.tree.isLeaf

/**
 * 652 - https://leetcode.com/problems/find-duplicate-subtrees
 */
class Solution {
    /**
     * Serialization Approach: https://leetcode.com/problems/find-duplicate-subtrees/solution/
     * Time: O(n^2)
     * Space: O(n^2)
     */
    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        val subtreeFreqs = hashMapOf<String, Int>()
        val dupes = arrayListOf<TreeNode>()
        serializeAndCacheSubtrees(root, subtreeFreqs, dupes)
        return dupes
    }

    private fun serializeAndCacheSubtrees(
        root: TreeNode?,
        counts: MutableMap<String, Int>,
        dupes: MutableList<TreeNode>
    ): String {
        val serialized = when {
            root == null -> ""
            root.isLeaf -> "${root.`val`}"
            root.hasLeft && !root.hasRight -> "${root.`val`}(${serializeAndCacheSubtrees(root.left, counts, dupes)})"
            !root.hasLeft && root.hasRight -> "${root.`val`}()(${serializeAndCacheSubtrees(root.right, counts, dupes)})"
            else -> "${root.`val`}" +
                    "(${serializeAndCacheSubtrees(root.left, counts, dupes)})" +
                    "(${serializeAndCacheSubtrees(root.right, counts, dupes)})"
        }

        counts[serialized] = (counts[serialized] ?: 0) + 1
        if (counts[serialized]!! == 2) {
            dupes.add(root!!)
        }

        return serialized
    }
}