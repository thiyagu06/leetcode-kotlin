package extensions.arrays

/**
 * `IntMatrix` = `Array<IntArray>`
 */
typealias IntMatrix = Array<IntArray>

val IntMatrix.rows: Int get() = size
val IntMatrix.columns: Int get() = if (isEmpty()) 0 else this[0].size

val IntMatrix.lastRow: Int get() = lastIndex
val IntMatrix.lastColumn: Int get() = if (isEmpty()) -1 else this[0].lastIndex

val IntMatrix.rowRange: IntRange get() = 0..lastIndex
val IntMatrix.columnRange: IntRange get() = if (isEmpty()) 0..-1 else 0..this[0].lastIndex

fun IntMatrix.toList(): List<List<Int>> = fold(mutableListOf()) { acc, intArr ->
    acc.apply {
        acc.add(intArr.toList())
    }
}

fun IntMatrix.debugString(): String = with(StringBuilder()) {
    rowRange.forEach { r ->
        append(this@debugString[r].contentToString())
        if (r < this@debugString.lastIndex)
            append("\n")
    }
    toString()
}

fun IntMatrix.dfs(
    visited: Array<BooleanArray> = Array(size) { BooleanArray(this[0].size) },
    visit: (Int, Int) -> Unit
) {
    rowRange.forEach { r ->
        columnRange.forEach { c ->
            visited[r][c] = true
            visit(r, c)
        }
    }
}

/**
 * Create a 2D array from a list of lists.
 */
fun List<List<Int>>.toMatrix(): IntMatrix = Array(size = size, init = { i -> this[i].toIntArray() })

fun IntMatrix.transpose(): IntMatrix {
    val transposed: IntMatrix = Array(columns) { IntArray(rows) }
    (0..lastRow).forEach { i ->
        (0..lastColumn).forEach { j ->
            transposed[j][i] = this[i][j]
        }
    }
    return transposed
}