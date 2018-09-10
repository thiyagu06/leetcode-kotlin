package extensions.iterable

val <T> Iterable<T>.head: T? get() = firstOrNull()
val <T> Iterable<T>.tail: List<T> get() = drop(1)
val <T> Iterable<T>.headAndTail: Pair<T?, List<T>> get() = (head to tail)

//val <T> Iterable<T>.headAndTailLists: Pair<List<T?>, List<T?>> get() = (listOf(head) to tail)