package datastructures.stack

/**
 * @author nrojiani
 * @date 11/22/17
 */
interface Stack<T> {
    fun push(element: T)
    fun pop(): T
    fun peek(): T
    fun isEmpty(): Boolean
    fun isNotEmpty(): Boolean
    val size: Int
}