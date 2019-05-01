package leetcode.easy._989_add_to_array_form_of_int

import kotlin.math.max

/**
 * 989 - https://leetcode.com/problems/add-to-array-form-of-integer/
 */
class Solution {
    /**
     * TODO
     * Time: O(?)
     * Space: O(?)
     */
    fun addToArrayForm(A: IntArray, K: Int): List<Int> {
        val aList = A.toList()
        val kList = K.toString().map { it.toString().toInt() }
        val longerAddendSize = max(aList.size, kList.size)
        val result: MutableList<Int> = IntArray(size = longerAddendSize + 1) { 0 }.toMutableList()

        var aIndex = aList.lastIndex
        var kIndex = kList.lastIndex
        var rIndex = result.lastIndex
        var carry = 0

        while (rIndex >= 0) {
            val aOperand = if (aIndex >= 0) aList[aIndex--] else 0
            val kOperand = if (kIndex >= 0) kList[kIndex--] else 0
            val sum = aOperand + kOperand + carry
            carry = sum / 10
            result[rIndex--] = sum % 10
        }

        if (carry == 1)
            result[rIndex] = 1

        return if (result.first() == 0) result.drop(1) else result
    }

}