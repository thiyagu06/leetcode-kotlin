package debug

/**
 * Debugging
 *
 * @author nrojiani
 * @date 11/25/17
 */


const val START_SEPARATOR = "-----------------------------------DEBUG START-------------------------------------------"
const val END_SEPARATOR =   "------------------------------------DEBUG END--------------------------------------------"
/**
 * ```
 * val a = 7
 * val b = 9.99
 * val c = "foobar"
 *
 * printVars("a" to a, "b" to b, "c" to c)
 * ```
 */
fun printVars(vararg variables: Pair<String, Any>): Unit {
    println(START_SEPARATOR)
    variables.forEach { (variableName, variable) ->
        println(variableName + " = " + variable)
    }
    println(END_SEPARATOR)
}
