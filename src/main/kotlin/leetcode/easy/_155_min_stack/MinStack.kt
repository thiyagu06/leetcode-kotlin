package leetcode.easy._155_min_stack

/**
 * 155 - https://leetcode.com/problems/min-stack/
 */
data class MinStackNode(val value: Int, val minStackValue: Int)

class MinStack {

    /** initialize your data structure here. */
    private val elements = arrayListOf<MinStackNode>()

    private val minElement: Int?
        get() = elements.lastOrNull()?.minStackValue

    val size: Int get() = elements.size

    fun push(x: Int) {
        elements += MinStackNode(value = x, minStackValue = if (minElement != null) minOf(x, minElement!!) else x)
    }

    fun pop() {
        if (elements.isNotEmpty())
            elements.removeAt(elements.lastIndex)
        else throw NoSuchElementException("Stack is empty")
    }

    fun top(): Int =
        if (elements.isNotEmpty()) elements[elements.lastIndex].value
        else throw NoSuchElementException("Stack is empty")

    fun getMin(): Int =
        if (elements.isNotEmpty()) minElement!!
        else throw NoSuchElementException("Stack is empty")

    fun isEmpty(): Boolean = elements.isEmpty()
    fun isNotEmpty(): Boolean = elements.isNotEmpty()
    override fun toString(): String = "MinStack(elements=$elements)"
}
