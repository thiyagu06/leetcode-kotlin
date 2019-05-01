package leetcode.easy._246_strobogrammatic_number

import extensions.math.isOdd

/**
 * 246 - https://leetcode.com/problems/strobogrammatic-number
 */
class Solution {
    fun isStrobogrammatic(num: String): Boolean = when {
        num.isEmpty() -> true
        num.length == 1 -> num in setOf("0", "1", "8")
        num.any { it !in setOf('0', '1', '6', '8', '9')} -> false
        else -> isSemiSymmetric(num)
    }


    // must be symmetric except for 6/9 or 9/6 pairs.
    private fun isSemiSymmetric(num: String): Boolean {
        var i = 0
        var j = num.lastIndex

        if (num.length.isOdd) {
            val mid = num[num.length / 2]
            if (mid == '6' || mid == '9') return false
        }

        while (i < j) {
            when (num[i]) {
                '0' -> if (num[j] != '0') return false
                '1' -> if (num[j] != '1') return false
                '8' -> if (num[j] != '8') return false
                '6' -> if (num[j] != '9') return false
                '9' -> if (num[j] != '6') return false
            }
            i++
            j--
        }

        return true
    }
}