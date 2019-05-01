package leetcode.medium._094_binary_tree_inorder_traversal

import datastructures.tree.TreeNode
import java.util.ArrayDeque
import java.util.Deque

/**
 * 94 - https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
class Solution {
    /**
     * Recursive
     * Time: O(n)
     * Space: O(n)
     */
    fun inorderTraversal(root: TreeNode?, values: MutableList<Int> = arrayListOf()): List<Int> =
        root?.let {
            root.left?.let { left -> inorderTraversal(left, values) }
            values += root.`val`
            root.right?.let { right -> inorderTraversal(right, values) }
        } ?: values
}

class SolutionTwo {
    /**
     * Iterative
     * http://tinyurl.com/y7s227k9
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val visited: MutableList<Int> = arrayListOf()
        val stack: Deque<TreeNode?> = ArrayDeque()
        var node: TreeNode? = root

        while (node != null || stack.isNotEmpty()) {
            /* Push left children */
            while (node != null) {
                stack.push(node)
                node = node.left
            }

            node = stack.pop()
            node?.let {
                visited += it.`val`
            }
            node = node?.right
        }

        return visited
    }
}

class DebugSolutionTwo {
    /**
     * Iterative
     * http://tinyurl.com/y7s227k9
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val visited: MutableList<Int> = arrayListOf()
        val stack: Deque<TreeNode?> = ArrayDeque()
        var node: TreeNode? = root

        while (node != null || stack.isNotEmpty()) {
            println("\nouter loop: node: $node, stack: $stack, visited: $visited")
            /* Push left children */
            val debugStackSizeBefore = stack.size
            if (node != null) println("1. inner loop (push all left children onto stack)")
            else println("1. node is null -> skip inner loop")
            while (node != null) {
                stack.push(node)
                node = node.left
            }
            if (stack.size > debugStackSizeBefore) {
                println("Stack after pushing all L children: $stack")
            }

            // Node will be null. Top of stack has lowest L child.
            println("2. Pop stack: node = ${stack.peek()}")
            node = stack.pop()
            node?.let {
                println("visited: $visited -> ${visited + it.`val`}")
                visited += it.`val`
            }
            println("3. Go right: node = node?.right: $node -> ${node?.right}")
            node = node?.right
            println("end outer loop")
        }

        println("END\n==========================\n")
        return visited
    }
}
