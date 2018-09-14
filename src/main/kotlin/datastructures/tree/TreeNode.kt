package datastructures.tree

import datastructures.tree.DFSTraversalOrder.INORDER
import datastructures.tree.DFSTraversalOrder.POSTORDER
import datastructures.tree.DFSTraversalOrder.PREORDER
import java.util.*

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

val TreeNode.hasLeft: Boolean get() = left != null
val TreeNode.hasRight: Boolean get() = right != null
val TreeNode.isLeaf: Boolean get() = left == null && right == null
val TreeNode.hasSingleChild: Boolean get() = (hasLeft || hasRight) && !(hasLeft && hasRight)
val TreeNode.hasTwoChildren: Boolean get() = left != null && right != null

val TreeNode.size: Int get() = 1 + (left?.size ?: 0) + (right?.size ?: 0)

/**
 * Can't implement component1/component2, since the types can't be nullable.
 * But this can be used for destructuring (among other uses):
 * ```
 * val (l, r) = tree?.children
 * ```
 */
val TreeNode.children: Pair<TreeNode?, TreeNode?>
    get() = Pair(left, right)

/**
 * Height: the number of edges on the longest path between this node and a leaf.
 */
val TreeNode.height: Int
    get() {
        if (isLeaf) return 0
        return 1 + maxOf(left?.height ?: 0, right?.height ?: 0)
    }

/**
 * Search for a value in the binary tree, returning the node
 * containing the value if it is found, or else null.
 *
 * Time: O(n)
 * Space: O(n)
 */
fun TreeNode?.find(searchValue: Int): TreeNode? {
    this ?: return null

    return when {
        searchValue < `val` -> left?.find(searchValue)
        searchValue > `val` -> right?.find(searchValue)
        else -> this
    }
}

fun TreeNode.contains(value: Int): Boolean = find(value) != null

enum class DFSTraversalOrder { PREORDER, INORDER, POSTORDER; }

/**
 * Perform depth-first traversal on the tree, executing [visit] on each node.
 */
fun TreeNode?.dfs(order: DFSTraversalOrder = INORDER, visit: (TreeNode) -> Unit) {
    this ?: return

    when (order) {
        PREORDER -> {
            visit(this)
            left?.dfs(PREORDER, visit)
            right?.dfs(PREORDER, visit)
        }

        INORDER -> {
            left?.dfs(INORDER, visit)
            visit(this)
            right?.dfs(INORDER, visit)
        }

        POSTORDER -> {
            left?.dfs(POSTORDER, visit)
            right?.dfs(POSTORDER, visit)
            visit(this)
        }
    }
}

/**
 * Traverse the tree (using inorder depth-first search), collecting the values
 * into a [Collection].
 *
 * Time: `O(n)`
 * Space: `O(n)`
 */
fun TreeNode?.collect(acc: MutableList<Int> = arrayListOf()): List<Int> =
    this?.let {
        left?.collect(acc)
        acc += `val`
        right?.collect(acc)
    } ?: acc

/**
 * Traverses the tree with DFS (in the given [traversalOrder]),
 * applies the [transform] to each [TreeNode], and
 * collect the transform result.
 *
 * Time: `O(n)` - assuming `transform` is `<= O(n)`
 * Space: `O(n)`
 */
fun <T> TreeNode?.collect(
    traversalOrder: DFSTraversalOrder = INORDER,
    acc: MutableList<T> = arrayListOf(),
    transform: (TreeNode) -> T
): List<T> {
    this ?: return emptyList()

    dfs(order = traversalOrder) { acc += transform(it) }
    return acc
}

/**
 * Collect the unique values to a Set.
 */
fun TreeNode?.collectUnique(acc: MutableSet<Int> = hashSetOf()): Set<Int> =
    this?.let {
        left?.collectUnique(acc)
        acc += `val`
        right?.collectUnique(acc)
    } ?: acc

/**
 * Return a list of the values in the tree. For binary search trees, the values
 * will be sorted.
 *
 */
fun TreeNode?.toList(): List<Int> = collect { it.`val` }.toList()

/**
 * Execute a breadth-first traversal of the tree.
 */
fun TreeNode?.bfs(visit: (TreeNode) -> Unit) {
    this ?: return

    val queue: Queue<TreeNode> = ArrayDeque<TreeNode>()
    var node: TreeNode = this
    queue.add(node)
    while (queue.isNotEmpty()) {
        node = queue.remove() ?: return
        visit(node)
        node.left?.let { queue.add(it) }
        node.right?.let { queue.add(it) }
    }
}

/**
 * TODO - test
 * Execute a depth-aware breadth-first traversal of the tree.
 *
 * Example usage:
 *
 * ```
 * var treeLevels = hashMapOf<Int, List<Int>>()     // nodes values by depth (Map of Depth => Values)
 * binarySearchTree.depthAwareBFS() { (node, depth) ->
 *     treeLevels[depth] = (treeLevels[depth] ?: emptyList()) + node.`val`
 * }
 * println(treeLevels)
 * ```
 */
fun TreeNode?.depthAwareBFS(visit: (Pair<TreeNode, Int>) -> Unit) {
    this ?: return

    val queue: Queue<Pair<TreeNode, Int>> = ArrayDeque<Pair<TreeNode, Int>>()
    queue.add(Pair(this, 0))

    while (queue.isNotEmpty()) {
        val (node, depth) = queue.remove()!!
        visit(node to depth)
        node.left?.let {
            queue.add(Pair(it, depth + 1))
        }
        node.right?.let {
            queue.add(Pair(it, depth + 1))
        }
    }
}

/**
 * Get the values in the tree by depth.
 */
fun TreeNode?.levels(): List<List<Int>> {
    this ?: return emptyList()

    val queue: Queue<Pair<TreeNode, Int>> = ArrayDeque<Pair<TreeNode, Int>>()
    queue.add(this to 0)

    val levels = arrayListOf<MutableList<Int>>()

    while (queue.isNotEmpty()) {
        val (node, depth) = queue.remove()!!

        if (depth > levels.lastIndex) {
            levels.add(arrayListOf(node.`val`))
        } else {
            levels[depth].add(node.`val`)
        }

        node.left?.let { queue.add(it to depth + 1) }
        node.right?.let { queue.add(it to depth + 1) }
    }

    return levels
}

fun TreeNode?.isBST(validRange: IntRange = (Int.MIN_VALUE..Int.MAX_VALUE)): Boolean {
    this ?: return true

    val leftSubtreeRange = validRange.first..(`val` - 1)
    val rightSubtreeRange = (`val` + 1)..validRange.last

    return `val` in validRange && left.isBST(leftSubtreeRange) && right.isBST(rightSubtreeRange)
}

/**
 * Returns a list of all root-to-leaf paths.
 */
fun TreeNode?.rootToLeafPaths(
    currentPath: List<Int> = emptyList(),
    paths: MutableList<List<Int>> = mutableListOf()
): List<List<Int>> =
    this?.let {
        left?.rootToLeafPaths(currentPath = currentPath + `val`, paths = paths)
        right?.rootToLeafPaths(currentPath = currentPath + `val`, paths = paths)

        if (isLeaf)
            paths += (currentPath + `val`)
        paths
    } ?: paths

/**
 * Returns a list of all (downward) paths. A path is defined as any sequence of nodes (length >= 1).
 * Sequences where a descendant precedes an ancestor are not permitted.
 */
fun TreeNode?.allPaths(
    pathsToParent: List<List<Int>> = emptyList(),
    paths: MutableList<List<Int>> = mutableListOf()
): List<List<Int>> =
    this?.let {
        val pathsToRoot = listOf(listOf(`val`)) + pathsToParent.map { path -> path + `val` }
        paths += pathsToRoot

        left?.allPaths(pathsToParent = pathsToRoot, paths = paths)
        right?.allPaths(pathsToParent = pathsToRoot, paths = paths)

        paths
    } ?: paths

/**
 * Create a binary tree from the given elements.
 * Insertion order is the same as LeetCode's 'Tree Visualizer'
 * @param elements The values to add to the tree.
 * @return The root of a binary tree containing the [elements]
 * @throws IllegalArgumentException If [elements] is empty
 */
fun buildTree(vararg elements: Int?): TreeNode? {
    require (elements.isNotEmpty()) { "Cannot build empty tree" }

    require(elements[0] != null) { "Root cannot be null" }

    val root = TreeNode(elements.first()!!)
    var parent = root
    val parentQueue: Queue<TreeNode> = ArrayDeque<TreeNode>()
    parentQueue.add(parent)
    var i = 1
    while (i < elements.size) {
        parent = parentQueue.remove() ?: return root

        parent.left = if (elements[i] != null) TreeNode(elements[i]!!) else null
        i++
        parent.left?.let {
            parentQueue.add(it)
        }

        if (i > elements.lastIndex)
            return root

        parent.right = if (elements[i] != null) TreeNode(elements[i]!!) else null
        i++
        parent.right?.let {
            parentQueue.add(it)
        }
    }

    return root
}

/**
 * Build tree from LeetCode's array representation:
 * buildTreeFromString("[1, 2, 3]") -> buildTree(1, 2, 3)
 */
fun buildTreeFromString(input: String): TreeNode? {
    require(input.first() == '[' && input.last() == ']') {
        "Invalid format: $input"
    }

    val withoutBraces = input.drop(1).dropLast(1)
    val elements = withoutBraces.split(',')
        .asSequence()
        .map { it.trim() }
        .map { c ->
            when {
                c[0] == '-' -> {
                    if (!c.drop(1).all { it.isDigit() }) {
                        throw IllegalArgumentException("Expected digits after negative sign")
                    } else {
                        c.toInt()
                    }
                }
                c.all { it.isDigit() } -> c.toInt()
                c == "null" -> null
                else -> throw IllegalArgumentException("Unable to parse input")
            }
        }
        .toList()
    return buildTree(*elements.toTypedArray())
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
fun buildBST(vararg elements: Int?): TreeNode? {
    val tree = buildTree(*elements)
    require(tree.isBST()) { "The elements in the order provided violate the BST property." }
    return tree
}
