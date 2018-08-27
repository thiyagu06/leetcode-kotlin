package leetcode.easy._232_implement_queue_using_stacks

import datastructures.stack.ArrayStack

/**
 * 232 - https://leetcode.com/problems/implement-queue-using-stacks/description/
 */
class MyQueue {

    /** Initialize your data structure here. */
    private val stackNewest = ArrayStack<Int>()     // Newest items on top
    private val stackOldest = ArrayStack<Int>()     // Oldest items on top

    val size: Int get() = stackNewest.size + stackOldest.size

    /** Push element x to the back of queue - enqueue */
    fun push(x: Int) {
        stackNewest.push(x)
    }

    /** Removes the element from in front of queue and returns that element - dequeue */
    fun pop(): Int {
        if (stackOldest.isEmpty())
            transferFromNewestToOldest()

        return stackOldest.pop()
    }

    /** Get the front element */
    fun peek(): Int {
        if (stackOldest.isEmpty())
            transferFromNewestToOldest()

        return stackOldest.peek()
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean = size == 0
    fun isNotEmpty(): Boolean = !empty()

    fun toList(): List<Int> = stackOldest.toList() + stackNewest.toList()

    private fun transferFromNewestToOldest() {
        while (stackNewest.isNotEmpty()) {
            stackOldest.push(stackNewest.pop())
        }
    }
}
