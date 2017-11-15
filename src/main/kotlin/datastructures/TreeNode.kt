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

val TreeNode.hasLeft: Boolean
    get() = left != null

val TreeNode.hasRight: Boolean
    get() = right != null

val TreeNode.hasTwoChildren: Boolean
    get() = left != null && right != null

val TreeNode.isLeaf: Boolean
    get() = left == null && right == null


val TreeNode.size: Int
    get() = 1 + (left?.size ?: 0) + (right?.size ?: 0)
