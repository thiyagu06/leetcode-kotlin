package leetcode.medium._394_decode_string

import extensions.chars.numericValue

/**
 * 394 - https://leetcode.com/problems/decode-string
 */
class Solution {

    /**
     * Time: O(n)  ?
     * Space: O(n) ?
     */
    fun decodeString(s: String): String = when {
        s.isEmpty() -> s
        else -> {
            val k = parseFirstK(s)

            // when k = 1, can either be "ef", or "1[ef]"
            val encodedStrStartIdx =
                if (s[0].isLetter()) 0 else k.toString().length

            // "3[a]2[b4[F]c]": k = 3, encodedStr = "a", remaining = "2[b4[F]c]"
            val (encodedString, remaining) = readFirstEncodedString(s.substring(encodedStrStartIdx))

            if (encodedString.isDecoded()) {
                encodedString.repeat(k) + decodeString(remaining)
            } else {
                decodeString(encodedString).repeat(k) + decodeString(remaining)
            }
        }
    }

    // "ef" -> 1
    // "3[a]" -> 3
    internal fun parseFirstK(s: String): Int = when {
        s.first().isLetter() -> 1
        else -> s.takeWhile { it.isDigit() }.toInt()
    }

    /**
     * Reads the first encoded string, which will start at the beginning of the string (k already parsed),
     * @return the first encoded string, and the remainder of [s].
     */
    internal fun readFirstEncodedString(s: String): Pair<String, String> {
        when {
            // no braces
            s.first().isLetter() -> {
                val encoded = s.takeWhile { it.isLetter() }
                val remainder = s.substring(encoded.length)
                return Pair(encoded, remainder)
            }

            // braces
            else -> {
                var count = 0
                var encoded = ""
                s.forEach { c ->

                    if (c == '[') count++
                    if (c == ']') count--

                    when (c to count) {
                        '[' to 1 -> return@forEach
                        ']' to 0 -> return Pair(encoded, s.substring(encoded.length + 2))
                        else -> encoded += c
                    }

                }
                return Pair(encoded, s.substring(encoded.length + 2))
            }
        }
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    private fun String.isDecoded(): Boolean = all { it.isLetter() }
}

class SolutionTwo {

    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun decodeString(s: String): String {
        var result = s
        while (!result.isDecoded()) {
            result = denestInput(result)
        }
        return result
    }

    internal fun denestInput(input: String): String {
        val segments = arrayListOf<String>()
        var currentEncoding = ""
        var count = 0
        var k = 1
        var kDigits = ""

        input.forEach { c ->
            when {
                c == '[' && count == 0 -> {
                    if (currentEncoding.isNotEmpty()) {
                        segments.add(currentEncoding)
                        currentEncoding = ""
                    }
                    count++
                }
                c == '[' && count > 0 -> {
                    currentEncoding += '['
                    count++
                }

                c == ']' -> {
                    count--
                    if (count > 0) {
                        currentEncoding += ']'
                    } else {
                        segments.add(currentEncoding.repeat(k))
                        currentEncoding = ""
                        k = 1
                        kDigits = ""
                    }
                }

                c == ']' && count > 0 -> {
                    count--
                    currentEncoding += ']'
                }

                c == ']' && count == 0 -> {
                    count--
                    segments.add(currentEncoding.repeat(k))
                    currentEncoding = ""
                    k = 1
                    kDigits = ""
                }

                c.isDigit() && count == 0 -> {
                    kDigits += c.numericValue
                    k = kDigits.toInt()
                }

                else -> currentEncoding += c
            }
        }

        if (currentEncoding.isNotEmpty())
            segments.add(currentEncoding)

        return segments.joinToString("")
    }

    private fun String.isDecoded(): Boolean = all { it.isLetter() }
}

class SolutionThree {
    /**
     * https://leetcode.com/problems/decode-string/discuss/87567/Java-Simple-Recursive-solution
     */
    fun decodeString(s: String): String = when {
        s.isEmpty() -> ""
        else -> with(StringBuilder()) {
            var i = 0
            while (i < s.length) {
                val c = s[i]
                when {
                    c.isDigit() -> {
                        val kStartIdx = i
                        while (s[i] != '[') i++
                        val k = s.substring(kStartIdx, i).toInt()
                        var count = 1
                        val strStartIdx = i + 1
                        i++

                        while (count != 0) {
                            if (s[i] == '[') count++
                            else if (s[i] == ']') count--
                            i++
                        }
                        i--

                        val str = decodeString(s.substring(strStartIdx, i))
                        append(str.repeat(k))
                    }
                    else -> append(c)
                }
                i++
            }
            toString()
        }
    }
}