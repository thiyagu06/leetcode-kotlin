package datastructures.list

/**
 * Definition for singly-linked list, from LeetCode.
 * Note: although `val` is declared with a default argument, LeetCode
 * won't compile if you try to create a node without passing an argument.
 */
class ListNode(var `val`: Int = 0) : Iterable<Int> {

    var next: ListNode? = null

    override fun toString(): String = "($`val`)"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ListNode

        if (`val` != other.`val`) return false
        if (next != other.next) return false

        return true
    }

    override fun hashCode(): Int = `val`

    /**
     * Returns an iterator over the elements of this object.
     */
    override fun iterator(): Iterator<Int> = toList().iterator()

    companion object {
        /**
         * Create a linked list from the given [Collection].
         * @param elements The elements to add to the list.
         * @return The head of a linked list of the [elements], or null if [elements] is empty.
         */
        fun from(elements: Collection<Int>): ListNode? =
            if (elements.isEmpty()) null else linkedListOf(*elements.toIntArray())
    }
}

/**
 * @return the number of elements in the linked list (starting from this [ListNode]).
 *
 * **Time**: `O(n)`
 *
 * **Space**: `O(1)`
 */
val ListNode?.size: Int
    get() {
        var count = 0
        var node: ListNode? = this
        while (node != null) {
            count++
            node = node.next
        }

        return count
    }

/**
 * Return the middle node in the list, or null if the receiver is null.
 * When the size of the list is even, the "2nd middle" node is returned.
 *
 * ```
 * oddList: (1)->(2)->(3)
 * evenList: (1)->(2)->(3)->(4)
 *
 * oddList.middleNode   // (2)
 * evenList.middleNode  // (3)
 * ```
 *
 * **Time**: `O(n)`
 *
 * **Space**: `O(1)`
 */
val ListNode?.middleNode: ListNode?
    get() {
        var tortoise: ListNode? = this
        var hare: ListNode? = this

        while (hare?.next != null) {
            tortoise = tortoise?.next
            hare = hare.next?.next
        }

        return tortoise
    }

/** Return all nodes after this node. */
val ListNode?.tail: ListNode? get() = this?.next

/**
 * Performs the given action on each *node* in the list.
 * To iterate over each value in the list, use [ListNode.iterator].
 */
fun ListNode?.forEachNode(action: (ListNode) -> Unit) {
    this ?: return
    var node: ListNode? = this
    while (node != null) {
        action(node)
        node = node.next
    }
}

/**
 * Returns a new [ListNode] in reverse order.
 * Non-mutating.
 *
 * **Time**: `O(n)`
 *
 * **Space**: `O(n)`
 */
fun ListNode?.reversed(): ListNode? {
    this ?: return null

    val copyHead = this.copyOf()

    var prev: ListNode? = null
    var curr: ListNode? = copyHead
    var next: ListNode? = copyHead?.next

    while (curr != null) {
        curr.next = prev

        prev = curr
        curr = next
        next = next?.next
    }

    return prev
}

/**
 * Returns a new list which is a copy of the original list.
 * Changes to the copy will not affect the original list.
 *
 * **Time**: `O(n)`
 *
 * **Space**: `O(n)`
 */
fun ListNode.copyOf(): ListNode? {
    val sentinel = ListNode(Int.MIN_VALUE)
    var copy: ListNode? = sentinel
    var node: ListNode? = this
    while (node != null) {
        copy?.next = ListNode(node.`val`)
        node = node.next
        copy = copy?.next
    }
    return sentinel.next
}

/**
 * Create a linked list from the given elements.
 * @param elements The elements to add to the list.
 * @return The head of a linked list of the [elements].
 * @throws IllegalArgumentException if [elements] is empty.
 */
fun linkedListOf(vararg elements: Int): ListNode {
    require(elements.isNotEmpty()) { "Cannot create ListNode without elements." }

    val sentinel = ListNode()
    var node = sentinel
    for (element in elements) {
        val newNode = ListNode(element)
        node.next = newNode
        node = newNode
    }

    return sentinel.next!!
}

/**
 * @return a [List] of the values of each node in the linked list.
 */
fun ListNode.toList(): List<Int> {
    val list = mutableListOf(this.`val`)
    var nextNode: ListNode? = this.next
    while (nextNode != null) {
        list.add(nextNode.`val`)
        nextNode = nextNode.next
    }

    return list.toList()
}

/**
 * @return a [Set] containing the (distinct) values in the linked list.
 */
fun ListNode.toSet(): Set<Int> {
    val set = hashSetOf(this.`val`)
    var nextNode: ListNode? = this.next
    while (nextNode != null) {
        if (!set.contains(nextNode.`val`)) {
            set.add(nextNode.`val`)
        }
        nextNode = nextNode.next
    }

    return set
}

/**
 * @return an [IntArray] containing the values in the linked list.
 */
fun ListNode.toIntArray(): IntArray = toList().toIntArray()

/**
 * The list contents as a [String]: (1)->(2)->(3)
 *
 * @return a [String] representation of the List.
 */
fun ListNode?.contentToString(): String {
    this ?: return "(null)"

    return buildString {
        var node: ListNode? = this@contentToString
        while (node != null) {
            append(node)
            node = node.next
        }
        toString()
    }.replace(")(", ")->(")
}
