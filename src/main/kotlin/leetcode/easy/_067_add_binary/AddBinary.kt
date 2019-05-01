package leetcode.easy._067_add_binary

import extensions.chars.numericValue

/**
 * 67 - https://leetcode.com/problems/add-binary/
 */
class Solution {
    /**
     * Using `String` - does compiler convert it to `StringBuilder` under the hood?
     * Time: O(?)
     * Space: O(?)
     */
    fun addBinary(a: String, b: String): String {
        var (aIndex, bIndex) = a.lastIndex to b.lastIndex
        var carry = 0
        var result = ""

        while (aIndex >= 0 || bIndex >= 0) {
            val aBit = if (aIndex >= 0) a[aIndex--].numericValue else 0
            val bBit = if (bIndex >= 0) b[bIndex--].numericValue else 0

            when (val sum = aBit + bBit + carry) {
                in 0..1 -> {
                    result = Character.forDigit(sum, 10) + result
                    carry = 0
                }
                2 -> {
                    result = "0$result"
                    carry = 1
                }
                3 -> {
                    result = "1$result"
                    carry = 1
                }
            }
        }

        if (carry == 1)
            result = "1$result"

        return result
    }
}

class SolutionTwo {
    /**
     * Using `StringBuilder` instead of `String`
     * Time: O(n) - where n is the number of digits in the longer binary string
     * Space: O()
     */
    fun addBinary(a: String, b: String): String = buildString {
        var (aIndex, bIndex) = a.lastIndex to b.lastIndex
        var carry = 0
        while (aIndex >= 0 || bIndex >= 0) {
            val aBit = if (aIndex >= 0) a[aIndex--].numericValue else 0
            val bBit = if (bIndex >= 0) b[bIndex--].numericValue else 0
            val sum = aBit + bBit + carry

            insert(0, aBit xor bBit xor carry)   // append the proper result bit
            when (sum) {
                in 0..1 -> carry = 0
                in 2..3 -> carry = 1
            }
        }

        if (carry == 1) insert(0, 1)
    }
}