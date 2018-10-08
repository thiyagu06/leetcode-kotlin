package leetcode.easy._538_convert_bst_to_greater_tree

import datastructures.tree.TreeNode
import datastructures.tree.collect
import java.util.LinkedList

/**
 * 538 - https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
class Solution {
    /**
     * Suboptimal - see comment
     *
     * Time: O(n^2)
     * Space: O(n)
     */
    fun convertBST(root: TreeNode?): TreeNode? {
        root ?: return null

        val treeValues = root.collect()         // node values in sorted order
        return convertBST(root, treeValues)
    }

    private fun convertBST(root: TreeNode?, treeValues: List<Int>): TreeNode? {
        root ?: return null

        // This operation is O(n) and done for every node -> O(n * n) = O(n^2)
        val convertedRootValue = treeValues.asSequence().dropWhile { it < root.`val` }.sum()

        return TreeNode(convertedRootValue).apply {
            left = convertBST(root.left, treeValues)
            right = convertBST(root.right, treeValues)
        }
    }
}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun convertBST(root: TreeNode?): TreeNode? {
        // Collect values with inorder DFS
        val originalKeys = arrayListOf<Int>()
        inorderDFS(root, originalKeys)

        // Iterate backwards through collected keys, create List of new keys
        val newKeys = greaterThanKeys(originalKeys)

        // Create map of key => new key
        val keyMap = (originalKeys zip newKeys).toMap()

        // Build new tree using map
        return buildTransformedTree(root, keyMap)
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    private fun buildTransformedTree(node: TreeNode?, transformMap: Map<Int, Int>): TreeNode? =
        node?.let {
            TreeNode(transformMap[node.`val`]!!).apply {
                left = buildTransformedTree(node.left, transformMap)
                right = buildTransformedTree(node.right, transformMap)
            }
        }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    private fun inorderDFS(root: TreeNode?, collected: MutableList<Int>): List<Int> {
        root ?: return collected

        inorderDFS(root.left, collected)
        collected += root.`val`
        inorderDFS(root.right, collected)

        return collected
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    private fun greaterThanKeys(sortedValues: List<Int>): List<Int> {
        val result = LinkedList<Int>()
        var reverseSum = 0
        (sortedValues.lastIndex downTo 0).forEach { i ->
            reverseSum += sortedValues[i]
            result.addFirst(reverseSum)
        }
        return result
    }
}