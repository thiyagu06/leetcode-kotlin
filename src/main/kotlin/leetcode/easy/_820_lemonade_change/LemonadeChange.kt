package leetcode.easy._820_lemonade_change

const val LEMONADE_PRICE = 5

class Solution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun lemonadeChange(bills: IntArray): Boolean {
        val register = hashMapOf(
            5 to 0,
            10 to 0,
            20 to 0
        )

        bills.forEach { bill ->
            register[bill] = register[bill]!! + 1
            val changeNeeded = bill - LEMONADE_PRICE
            if (!returnChange(changeNeeded, register))
                return false
        }

        return true
    }

    private fun returnChange(changeNeeded: Int, register: MutableMap<Int, Int>): Boolean {
        when (changeNeeded) {
            5 -> {
                if (register[5]!! == 0) return false
                register[5] = register[5]!! - 1
                return true
            }
            15 -> {
                return if (register[5]!! >= 3) {
                    register[5] = register[5]!! - 3
                    true
                } else if (register[10]!! >= 1 && register[5]!! >= 1) {
                    register[10] = register[10]!! - 1
                    register[5] = register[5]!! - 1
                    true
                } else {
                    false
                }
            }
        }

        return true
    }
}

class SolutionTwo {

    fun lemonadeChange(bills: IntArray): Boolean {
        var fives = 0
        var tens = 0
        // Don't need to track twenties since they won't ever be given out as change

        bills.forEach { bill ->
            when (bill) {
                5 -> fives++
                10 -> {
                    // Change: $5
                    tens++
                    if (fives == 0) return false
                    fives--
                }
                20 -> {
                    // Change: $15 - 3 $5 or 1 $10, 1 $5
                    if (fives >= 3) {
                        fives -= 3
                    } else if (fives >= 1 && tens >= 1) {
                        fives--
                        tens--
                    } else {
                        return false
                    }
                }
            }
        }
        return true
    }
}