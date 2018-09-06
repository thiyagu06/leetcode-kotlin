package extensions.arrays

/**
 * `Matrix` = `Array<IntArray>`
 */
typealias Matrix = Array<IntArray>

// TODO: Matrix -> IntMatrix
// TODO: create BooleanMatrix

val Matrix.rows: Int get() = size
val Matrix.columns: Int get() = if (isEmpty()) 0 else this[0].size

val Matrix.lastRow: Int get() = lastIndex
val Matrix.lastColumn: Int get() = if (isEmpty()) -1 else this[0].lastIndex

val Matrix.rowRange: IntRange get() = 0..lastIndex
val Matrix.columnRange: IntRange get() = if (isEmpty()) 0..-1 else 0..this[0].lastIndex

fun Matrix.toList(): List<List<Int>> = fold(mutableListOf()) { acc, intArr ->
    acc.apply {
        acc.add(intArr.toList())
    }
}

fun Matrix.dfs(
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
fun List<List<Int>>.toMatrix(): Matrix = Array(size = size, init = { i -> this[i].toIntArray() })

fun Matrix.transpose(): Matrix {
    val transposed: Matrix = Array(columns) { IntArray(rows) }
    (0..lastRow).forEach { i ->
        (0..lastColumn).forEach { j ->
            transposed[j][i] = this[i][j]
        }
    }
    return transposed
}