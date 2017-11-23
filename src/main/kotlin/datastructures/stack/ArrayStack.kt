package datastructures.stack

/**
 * Stack implemented with an ArrayList.
 *
 * @author nrojiani
 * @date 11/22/17
 */
class ArrayStack<T> : Stack<T> {

    private val elements = arrayListOf<T>()

    override val size: Int
        get() = elements.size

    override fun push(element: T) {
        elements += element
    }

    override fun pop(): T =
            if (elements.isNotEmpty()) {
                elements.removeAt(elements.lastIndex)
            } else {
                throw NoSuchElementException("Stack is empty")
            }

    override fun peek(): T =
            if (elements.isNotEmpty()) {
                elements[elements.lastIndex]
            } else {
                throw NoSuchElementException("Stack is empty")
            }

    override fun isEmpty(): Boolean = elements.isEmpty()

    override fun isNotEmpty(): Boolean = !elements.isEmpty()

    override fun toString(): String = "ArrayStack(elements=$elements)"

}