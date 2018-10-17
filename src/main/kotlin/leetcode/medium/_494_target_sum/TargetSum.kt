package leetcode.medium._494_target_sum

/**
 * 494 - https://leetcode.com/problems/target-sum
 */
class Solution {
    /**
     * Backtracking without Memoization - Time Limit Exceeding
     * Time: O(2^n)
     * Space: O(?)
     */
    fun findTargetSumWays(nums: IntArray, S: Int): Int = findSums(nums.toList(), S)

    private fun findSums(nums: List<Int>, sum: Int): Int = when {
        nums.isEmpty() -> if (sum == 0) 1 else 0
        else -> findSums(nums.drop(1), sum - nums.first()) + findSums(nums.drop(1), sum - (nums.first() * -1))
    }
}

class SolutionTwo {
    /**
     * Backtracking with memoization
     * Time: O(?)
     * Space: O(?)
     */
    fun findTargetSumWays(nums: IntArray, S: Int): Int {
        // memo[nums to S] stores the # of ways for inputs nums & S
        val memo: MutableMap<Pair<List<Int>, Int>, Int> = hashMapOf()
        memo[emptyList<Int>() to 0] = 1
        return findSums(nums.toList(), S, memo)
    }

    private fun findSums(nums: List<Int>, sum: Int, memo: MutableMap<Pair<List<Int>, Int>, Int>): Int = when {
        (nums to sum) in memo -> memo[nums to sum]!!
        nums.isEmpty() -> {
            memo[nums to sum] = if (sum == 0) 1 else 0
            memo[nums to sum]!!
        }
        else -> {
            val addResult = findSums(nums.drop(1), sum - nums.first(), memo)
            val subtractResult = findSums(nums.drop(1), sum + nums.first(), memo)
            memo[nums to sum] = addResult + subtractResult
            memo[nums to sum]!!
        }
    }
}

class SolutionThree {
    /**
     * Backtracking with memoization - improve upon SolutionTwo by reducing space used
     * Time: O(?)
     * Space: O(?)
     */
    fun findTargetSumWays(nums: IntArray, S: Int): Int {
        val memo: MutableMap<Pair<Int, Int>, Int> = hashMapOf() // (startIndex to sum) => 0 or 1
        return findSums(nums, 0, S, memo)
    }

    private fun findSums(
        nums: IntArray,
        startIndex: Int,
        sum: Int,
        memo: MutableMap<Pair<Int, Int>, Int>
    ): Int = when {
        (startIndex to sum) in memo -> memo[startIndex to sum]!!
        startIndex > nums.lastIndex -> {
            memo[startIndex to sum] = if (sum == 0) 1 else 0
            memo[startIndex to sum]!!
        }
        else -> {
            val addResult = findSums(nums, startIndex + 1, sum - nums[startIndex], memo)
            val subtractResult = findSums(nums, startIndex + 1, sum + nums[startIndex], memo)
            memo[startIndex to sum] = addResult + subtractResult
            memo[startIndex to sum]!!
        }
    }
}