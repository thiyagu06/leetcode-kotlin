package datastructures.queue

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