/**
 * MutableList extensions
 */

/**
 * Add an element to the beginning of the list.
 */
internal fun <E> MutableList<E>.prepend(element: E): Unit = add(0, element)

/**
 * Inserts all of the elements in the specified collection [elements] into this list at the beginning of the list.
 * @return `true` if the list was changed as the result of the operation.
 */
internal fun <E> MutableList<E>.prependAll(elements: Collection<E>): Boolean = addAll(0, elements)

/**
 * Add an element to the end of the list.
 */
internal fun <E> MutableList<E>.append(element: E): Boolean = add(element)

/**
 * Inserts all of the elements in the specified collection [elements] into this list at the end of the list.
 * @return `true` if the list was changed as the result of the operation.
 */
internal fun <E> MutableList<E>.appendAll(elements: Collection<E>): Boolean = addAll(elements)

