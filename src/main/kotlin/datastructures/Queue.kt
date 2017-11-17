package datastructures

/**
 * Queue interface
 */
interface Queue<T> {
    fun enqueue(value: T)
    fun dequeue(): T?
    fun peek(): T?
    fun isEmpty(): Boolean
    val size: Int
}

/**
 * Queue implementation backed by an [ArrayList].
 */
class ListQueue<T> : Queue<T> {
    private val elements = arrayListOf<T>()

    override fun enqueue(value: T) = elements.add(elements.size, value)

    override fun dequeue(): T? =
            if (elements.isEmpty()) null
            else elements.removeAt(0)

    override fun peek(): T? = elements.firstOrNull()

    override fun isEmpty(): Boolean = elements.isEmpty()

    override val size: Int
        get() = elements.size
}