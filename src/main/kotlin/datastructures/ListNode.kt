package datastructures

/**
 * Definition for singly-linked list.
 */
class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null

    override fun toString(): String {
        return "( $`val` )"
    }

    companion object {
        fun from(elements: Collection<Int>): ListNode? {
            if (elements.isEmpty())
                return null

            val preNode = ListNode()        // ptr before head of list.
            var node: ListNode? = preNode
            for (elem in elements) {
                node?.next = ListNode(elem)
                node = node?.next
            }

            return preNode.next
        }
    }
}

fun ListNode.toList(): List<Int> {
    var mList = mutableListOf(this.`val`)
    var nextNode: ListNode? = this?.next
    while (nextNode != null) {
        mList.add(nextNode.`val`)
        nextNode = nextNode.next
    }

    return mList.toList()
}

fun ListNode.toIntArray(): IntArray = toList().toIntArray()

val ListNode.size: Int
    get() {
        var count = 0
        var node: ListNode? = this
        while (node != null) {
            count++
            node = node.next
        }

        return count
    }
