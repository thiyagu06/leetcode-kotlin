package datastructures

/**
 * Definition for a binary tree node.
 */
class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null

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

// TODO DFS
