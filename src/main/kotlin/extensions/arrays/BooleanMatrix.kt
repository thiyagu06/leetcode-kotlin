package extensions.arrays

/**
 * `BooleanMatrix` = `Array<BooleanArray>`
 */
typealias BooleanMatrix = Array<BooleanArray>

val BooleanMatrix.rows: Int get() = size
val BooleanMatrix.columns: Int get() = if (isEmpty()) 0 else this[0].size

val BooleanMatrix.lastRow: Int get() = lastIndex
val BooleanMatrix.lastColumn: Int get() = if (isEmpty()) -1 else this[0].lastIndex

val BooleanMatrix.rowRange: IntRange get() = 0..lastIndex
val BooleanMatrix.columnRange: IntRange get() = if (isEmpty()) 0..-1 else 0..this[0].lastIndex

fun BooleanMatrix.toList(): List<List<Boolean>> = fold(mutableListOf()) { acc, intArr ->
    acc.apply {
        acc.add(intArr.toList())
    }
}

fun BooleanMatrix.debugString(): String = with(StringBuilder()) {
    rowRange.forEach { r ->
        append(this@debugString[r].contentToString())
        if (r < this@debugString.lastIndex)
            append("\n")
    }
    toString()
}

/**
 * Create a 2D array from a list of lists.
 */
fun List<List<Boolean>>.toMatrix(): BooleanMatrix = Array(size = size, init = { i -> this[i].toBooleanArray() })
