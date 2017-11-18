package datastructures

import datastructures.DFSTraveralOrder.INORDER
import datastructures.DFSTraveralOrder.POSTORDER
import datastructures.DFSTraveralOrder.PREORDER

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
internal fun TreeNode.find(value: Int): TreeNode? = when {
    value < `val` && hasLeft -> left?.find(value)
    value > `val` && hasRight -> right?.find(value)
    else -> this
}

internal fun TreeNode.contains(value: Int): Boolean = find(value) != null


internal enum class DFSTraveralOrder { PREORDER, INORDER, POSTORDER; }

/**
 * Perform depth-first search on the tree, executing [visit] on each node.
 */
internal fun TreeNode?.depthFirstSearch(order: DFSTraveralOrder = INORDER, visit: (TreeNode) -> Unit) {
    this ?: return

    if (order == PREORDER)
        visit(this)

    left?.let { it.depthFirstSearch(order, visit) }

    if (order == INORDER)
        visit(this)

    right?.let { it.depthFirstSearch(order, visit) }

    if (order == POSTORDER)
        visit(this)
}

/**
 * Traverse the tree, collecting all the values into a [Collection<Int>]
 */
internal fun TreeNode?.collect(acc: MutableCollection<Int> = arrayListOf()): Collection<Int> =
        this?.let {
            left?.let { it.collect(acc) }
            acc += `val`
            right?.let { it.collect(acc) }
        } ?: acc

/**
 * Traverse the tree and collect the result of applying the transform to each [TreeNode].
 */
internal fun <T> TreeNode?.collect(traversalOrder: DFSTraveralOrder = INORDER,
                                   acc: MutableCollection<T> = arrayListOf(),
                                   transform: (TreeNode) -> T): Collection<T> {
    this ?: return emptyList()

    depthFirstSearch(order = traversalOrder) { acc += transform(it) }
    return acc
}

internal fun TreeNode?.toList(): List<Int> = collect { it.`val` }.toList()

// TODO: Iterative DFS
// TODO: BFS

/**
 * Create a binary tree from the given elements.
 * Insertion order is the same as LeetCode's 'Tree Visualizer'
 * @param elements The values to add to the tree.
 * @return The root of a binary tree containing the [elements], or `null` if
 * elements is empty.
 */
internal fun buildTree(elements: List<Int?>): TreeNode? {
    if (elements.isEmpty())
        return null

    require(elements[0] != null) { "Root cannot be null" }

    val root = TreeNode(elements.first()!!)
    var parent = root
    var parentQueue: Queue<TreeNode> = ListQueue()
    parentQueue.enqueue(parent)
    var i = 0
    while (i < elements.size) {
        parent = parentQueue.dequeue() ?: return root

        parent.left = if (elements[i] != null) TreeNode(elements[i]!!) else null
        i++
        parent.left?.let {
            parentQueue.enqueue(it)
        }


        parent.right = if (elements[i] != null) TreeNode(elements[i]!!) else null
        i++
        parent.right?.let {
            parentQueue.enqueue(it)
        }
    }

    return root
}

