package extensions

import java.util.*

/**
 * Various Kotlin extensions using
 *
 * @author nrojiani
 * @date 11/15/17
 */

/**
 * Returns an immutable list consisting of [n] copies of the
 * specified object.
 *
 * See Java's [Collections.nCopies].
 */
fun <T> T.nCopies(n: Int): List<T> = Collections.nCopies(n, this)

/**
 * Returns an immutable list consisting of [n] copies of the
 * specified object.
 *
 * See Java's [Collections.nCopies].
 */
fun <T> T.repeated(n: Int): List<T> = Collections.nCopies(n, this)
