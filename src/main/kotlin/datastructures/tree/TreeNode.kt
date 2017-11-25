package datastructures.tree

import datastructures.tree.DFSTraversalOrder.INORDER
import datastructures.tree.DFSTraversalOrder.POSTORDER
import datastructures.tree.DFSTraversalOrder.PREORDER
import datastructures.queue.ListQueue
import datastructures.queue.Queue

/**
 * Definition for a binary tree node.
 */
class TreeNode(var `val`: Int = 0, var left: TreeNode? = null, var right: TreeNode? = null) {

    override fun toString(): String = "($`val`)"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TreeNode

        if (`val` != other.`val`) return false
        if (left != other.left) return false
        if (right != other.right) return false

        return true
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + (left?.hashCode() ?: 0)
        result = 31 * result + (right?.hashCode() ?: 0)
        return result
    }
}

internal val TreeNode.hasLeft: Boolean
    get() = left != null

internal val TreeNode.hasRight: Boolean
    get() = right != null

internal val TreeNode.hasTwoChildren: Boolean
    get() = left != null && right != null

internal val TreeNode.isLeaf: Boolean
    get() = left == null && right == null

internal val TreeNode.size: Int
    get() = 1 + (left?.size ?: 0) + (right?.size ?: 0)


/**
 * Search for a value in the binary tree, returning the node
 * containing the value if it is found, or else null.
 *
 * Time: O(n)
 * Space: O(n)
 */
internal fun TreeNode?.find(searchValue: Int): TreeNode? {
    this ?: return null

    return when {
        searchValue < `val` -> left?.find(searchValue)
        searchValue > `val` -> right?.find(searchValue)
        else -> this
    }
}

internal fun TreeNode.contains(value: Int): Boolean = find(value) != null

internal enum class DFSTraversalOrder { PREORDER, INORDER, POSTORDER; }

/**
 * Perform depth-first search on the tree, executing [visit] on each node.
 */
internal fun TreeNode?.depthFirstSearch(order: DFSTraversalOrder = INORDER, visit: (TreeNode) -> Unit) {
    this ?: return

    if (order == PREORDER)
        visit(this)

    left?.depthFirstSearch(order, visit)

    if (order == INORDER)
        visit(this)

    right?.depthFirstSearch(order, visit)

    if (order == POSTORDER)
        visit(this)
}

/**
 * Traverse the tree (using inorder depth-first search), collecting the values
 * into a [Collection<Int>].
 */
internal fun TreeNode?.collect(acc: MutableCollection<Int> = arrayListOf()): Collection<Int> =
        this?.let {
            left?.collect(acc)
            acc += `val`
            right?.collect(acc)
        } ?: acc

/**
 * Traverses the tree with DFS (in the given [traversalOrder]),
 * applies the [transform] to each [TreeNode], and
 * collect the transform result.
 */
internal fun <T> TreeNode?.collect(traversalOrder: DFSTraversalOrder = INORDER,
                                   acc: MutableCollection<T> = arrayListOf(),
                                   transform: (TreeNode) -> T): Collection<T> {
    this ?: return emptyList()

    depthFirstSearch(order = traversalOrder) { acc += transform(it) }
    return acc
}

/**
 * Return a list of the values in the tree. For binary search trees, the values
 * will be sorted.
 *
 */
internal fun TreeNode?.toList(): List<Int> = collect { it.`val` }.toList()

// TODO: Iterative DFS
// TODO: BFS


internal fun TreeNode?.isBST(validRange: IntRange = (Int.MIN_VALUE..Int.MAX_VALUE)): Boolean {
    this ?: return true

    val leftSubtreeRange = validRange.first..(`val` - 1)
    val rightSubtreeRange = (`val` + 1)..validRange.last

    return `val` in validRange && left.isBST(leftSubtreeRange) && right.isBST(rightSubtreeRange)
}

/**
 * Returns a list of all root-to-leaf paths.
 */
internal fun TreeNode?.rootToLeafPaths(): List<List<Int>> {
    this ?: return emptyList()

    val paths = arrayListOf<List<Int>>()
    rootToLeafPathsHelper(emptyList(), paths)
    return paths
}

private fun TreeNode?.rootToLeafPathsHelper(currentPath: List<Int>, paths: MutableList<List<Int>>) {
    this ?: return

    if (isLeaf) {
        paths += (currentPath + `val`)
    } else {
        left?.rootToLeafPathsHelper(currentPath + `val`, paths)
        right?.rootToLeafPathsHelper(currentPath + `val`, paths)
    }
}

/**
 * Create a binary tree from the given elements.
 * Insertion order is the same as LeetCode's 'Tree Visualizer'
 * @param elements The values to add to the tree.
 * @return The root of a binary tree containing the [elements], or `null` if
 *         elements is empty.
 */
internal fun buildTree(vararg elements: Int?): TreeNode? {
    if (elements.isEmpty())
        return null

    require(elements[0] != null) { "Root cannot be null" }

    val root = TreeNode(elements.first()!!)
    var parent = root
    val parentQueue: Queue<TreeNode> = ListQueue()
    parentQueue.enqueue(parent)
    var i = 1
    while (i < elements.size) {
        parent = parentQueue.dequeue() ?: return root

        parent.left = if (elements[i] != null) TreeNode(elements[i]!!) else null
        i++
        parent.left?.let {
            parentQueue.enqueue(it)
        }

        if (i > elements.lastIndex)
            return root

        parent.right = if (elements[i] != null) TreeNode(elements[i]!!) else null
        i++
        parent.right?.let {
            parentQueue.enqueue(it)
        }
    }

    return root
}

/**
 * Create a binary search tree from the given elements.
 * Insertion order is the same as LeetCode's 'Tree Visualizer'.
 * For the BST property to be satisfied, all left subtree values must be less than the root,
 * and all right subtree values must be greater. Duplicates are not permitted.
 * @param elements The values to add to the tree.
 * @return The root of a BST containing the [elements], or `null` if
 *         elements is empty.
 * @throws IllegalArgumentException if the elements cannot create a valid binary search tree.
 */
internal fun buildBST(vararg elements: Int?): TreeNode? {
    val tree = buildTree(*elements)
    require(tree.isBST()) { "The elements in the order provided violate the BST property." }
    return tree
}

/**
 * ```
 *    1
 *   / \
 * 2     3
 * ```
 */
internal val tree123 =
        TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
        }

/**
 * ```
 *        5
 *      /   \
 *    3      8
 *   / \    / \
 * 1    4  6    9
 * ```
 */
internal val bst3LevelsFull =
        TreeNode(5).apply {
            left = TreeNode(3).apply {
                left = TreeNode(1)
                right = TreeNode(4)
            }
            right = TreeNode(8).apply {
                left = TreeNode(6)
                right = TreeNode(9)
            }
        }

/**
 * ```
 *           7
 *         /   \
 *       4      9
 *      /      /
 *    3       8
 *   /
 *  1
 * ```
 */
internal val bstWithNulls =
        TreeNode(7).apply {
            left = TreeNode(4).apply {
                left = TreeNode(3).apply {
                    left = TreeNode(1)
                }
            }
            right = TreeNode(9).apply {
                left = TreeNode(8)
            }
        }
