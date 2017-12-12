package algorithms.medium._394_decode_string

import datastructures.stack.ArrayStack
import extensions.numericValue

/**
 * @author nrojiani
 * @date 12/11/17
 */
class Solution {
    fun decodeString(s: String): String {
        var result = s
        while ('[' in result) {
            result = denestInput(result)
        }
        return result
    }

    internal fun denestInput(input: String): String {
        var result = ""
        var currentStr = ""
        var stack = ArrayStack<Char>()
        var k = 1
        var kDigits = ""

        input.forEach { c ->
            when (c) {
                '[' -> {
                    stack.push('[')
                    if (stack.size > 1) {
                        currentStr += '['
                    }
                }

                ']' -> {
                    stack.pop()
                    if (stack.isNotEmpty()) {
                        currentStr += ']'
                    } else {
                        result += currentStr.repeat(k)
                        currentStr = ""
                        k = 1
                        kDigits = ""
                    }
                }

                in '0'..'9' -> {
                    if (stack.isEmpty()) {
                        kDigits += c.numericValue()
                        k = kDigits.toInt()
                    } else {
                        currentStr += c
                    }
                }

                in 'a'..'z' -> {
                    if (stack.isEmpty()) {  // un-nested input, like ef in "3[a]ef"
                        result += c
                    } else {
                        currentStr += c
                    }
                }
            }
        }

        return result
    }
}