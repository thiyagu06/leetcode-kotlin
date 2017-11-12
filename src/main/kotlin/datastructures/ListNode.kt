package datastructures

/**
 * Definition for singly-linked list.
 */
class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null

    override fun toString(): String {
        return "($`val`)"
    }

    companion object {
        /**
         * Create a linked list from the given elements.
         * @param elements The elements to add to the list.
         * @return The head of a linked list of the [elements], or null if [elements] is empty.
         */
        fun from(elements: Collection<Int>): ListNode? {
            if (elements.isEmpty())
                return null

            val sentinel = ListNode()
            var node: ListNode? = sentinel
            for (element in elements) {
                node?.next = ListNode(element)
                node = node?.next
            }

            return sentinel.next
        }
    }
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
 * @return a list containing the elements in the linked list.
 */
fun ListNode.toList(): List<Int> {
    var list = mutableListOf(this.`val`)
    var nextNode: ListNode? = this?.next
    while (nextNode != null) {
        list.add(nextNode.`val`)
        nextNode = nextNode.next
    }

    return list.toList()
}

/**
 * @return an [IntArray] containing the elements in the linked list.
 */
fun ListNode.toIntArray(): IntArray = toList().toIntArray()

/**
 * @return the number of elements in the linked list from this [ListNode].
 */
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

/**
 * The list contents as a String: (1)->(2)->(3)
 *
 * @return a String representation of the List.
 */
fun ListNode.contentToString(): String = with(StringBuilder()) {
    var node: ListNode? = this@contentToString
    while (node != null) {
        append(node)
        node = node?.next
    }
    toString()
}.replace(")(", ")->(")


fun main(args: Array<String>) {
    val list = listOf("args: ", *args)

    println(list)
}
