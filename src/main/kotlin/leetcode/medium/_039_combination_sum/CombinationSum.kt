package leetcode.medium._039_combination_sum

/**
 * 39 - https://leetcode.com/problems/combination-sum/
 */
class Solution {
    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val solutionSet = arrayListOf<List<Int>>()
        combinationSum(candidates.toList(), target, listOf(), solutionSet)
        return solutionSet
    }

    private fun combinationSum(
        candidates: List<Int>,
        target: Int,
        currentSolution: List<Int>,
        solutionSet: MutableList<List<Int>>
    ) {
        when {
            target < 0 || candidates.isEmpty() -> return
            target == 0 -> solutionSet += currentSolution
            else -> {
                // Don't include
                combinationSum(
                    candidates = candidates.drop(1),
                    target = target,
                    currentSolution = currentSolution,
                    solutionSet = solutionSet
                )

                // Include
                combinationSum(
                    candidates = candidates,
                    target = target - candidates.first(),
                    currentSolution = currentSolution + candidates.first(),
                    solutionSet = solutionSet
                )
            }
        }
    }
}

class SolutionTwo {
    /**
     * Similar to above, but uses less space
     * Time: O(?)
     * Space: O(?)
     */
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val solutions: MutableSet<List<Int>> = hashSetOf()
        combinationSum(
            candidates = candidates,
            index = 0,
            remaining = target,
            currentSolution = emptyList(),
            solutions = solutions
        )
        return solutions.toList()
    }

    private fun combinationSum(
        candidates: IntArray,
        index: Int,
        remaining: Int,
        currentSolution: List<Int>,
        solutions: MutableSet<List<Int>>
    ) {
        when {
            remaining < 0 || index > candidates.lastIndex -> return
            remaining == 0 -> solutions += currentSolution
            remaining > 0 -> {
                // Include (possibly repeat)
                if (!solutions.contains(currentSolution + candidates[index])) {
                    combinationSum(
                        candidates = candidates,
                        index = index,
                        remaining = remaining - candidates[index],
                        currentSolution = currentSolution + candidates[index],
                        solutions = solutions
                    )
                }

                // Don't include
                combinationSum(
                    candidates = candidates,
                    index = index + 1,
                    remaining = remaining,
                    currentSolution = currentSolution,
                    solutions = solutions
                )
            }
        }
    }
}

class SolutionThree {
    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val solutionSet = hashSetOf<List<Int>>()
        backtrack(candidates.toList(), target, listOf(), solutionSet)
        return solutionSet.toList()
    }

    private fun backtrack(
        candidates: List<Int>,
        remaining: Int,
        currentSolution: List<Int>,
        solutionSet: MutableSet<List<Int>>
    ) {
        when {
            remaining < 0 -> return
            remaining == 0 -> solutionSet += currentSolution
            else ->
                candidates.forEachIndexed { i, n ->
                    if (!solutionSet.contains(currentSolution + n)) {
                        backtrack(
                            candidates = candidates.drop(i),
                            remaining = remaining - n,
                            currentSolution = currentSolution + n,
                            solutionSet = solutionSet
                        )
                    }
                }
        }
    }
}