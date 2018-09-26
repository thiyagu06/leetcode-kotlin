package leetcode.easy._599_min_index_sum

/**
 * 599 - https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 */
class Solution {
    /**
     * Time: O(L1 + L2) - where L1 & L2 are the lengths of the input lists.
     * Space: O(L1 + L2)
     */
    fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
        val indexMap = hashMapOf<String, List<Int>>()

        addToIndexMap(list1, indexMap)
        addToIndexMap(list2, indexMap)

        val indexSums = indexMap.map { (s, indices) ->
            when (indices.size) {
                in 0..1 -> s to Int.MAX_VALUE
                else -> s to indices.sum()
            }
        }

        val minIndexSum = indexSums.minBy { (_, indexSum) -> indexSum }?.second ?: 0

        return indexSums.fold(arrayOf()) { acc, (s, indexSum) ->
            if (indexSum == minIndexSum) acc + s else acc
        }
    }

    private fun addToIndexMap(list: Array<String>, indexMap: MutableMap<String, List<Int>>) {
        list.forEachIndexed { index, s ->
            indexMap[s] = (indexMap[s] ?: emptyList()) + index
        }
    }
}

