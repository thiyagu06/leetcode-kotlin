package extensions

import java.util.concurrent.ConcurrentHashMap

const val DEFAULT_CAPACITY = 1 shl 8

/* https://github.com/aballano/MnemoniK */
fun <A, B, R> ((A, B) -> R).memoize(initialCapacity: Int = DEFAULT_CAPACITY, concurrent: Boolean = false): (A, B) -> R {
    val cache: MutableMap<Pair<A, B>, R> = if (concurrent) ConcurrentHashMap(initialCapacity) else HashMap(initialCapacity)
    return { a: A, b: B ->
        cache.getOrPut(a to b, { this(a, b) })
    }
}

// TODO

///**
// * From the book "Programming in Kotlin", with some modification
// *
// * Usage:
// * val memoizedResult = memoize(::myFunction)
// */
//fun <A, R> memoize(function: (A) -> R, concurrent: Boolean = false): (A) -> R {
//    val map: MutableMap<A, R> = if (concurrent) ConcurrentHashMap() else HashMap()
//    return { a ->
//        map.getOrPut(a) {
//            function(a)
//        }
//    }
//}
//
///**
// * From the book "Programming in Kotlin"
// * Usage:}
// *
// * val memoizedResult = ::myFunction.memoized()
// */
//fun <A, R> Function1<A, R>.memoized(concurrent: Boolean = false): (A) -> R {
//    val map: MutableMap<A, R> = if (concurrent) ConcurrentHashMap() else HashMap()
//    return {
//        a -> map.getOrPut(a) {
//            this.invoke(a)
//        }
//    }
//}