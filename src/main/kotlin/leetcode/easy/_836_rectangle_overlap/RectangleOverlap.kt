package leetcode.easy._836_rectangle_overlap

/**
 * 836 - https://leetcode.com/problems/rectangle-overlap/description/
 */
class Solution {
    /**
     * Time: O(1)
     * Space: O(1)
     */
    fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
        val r1 = rec1.toRectangle()
        val r2 = rec2.toRectangle()

        return !isOneRectangleAboveOther(r1, r2) && !isOneRectangleToLeftOfOther(r1, r2)
    }

    private fun isOneRectangleAboveOther(r1: Rectangle, r2: Rectangle): Boolean =
        (r1.lowerLeft.y >= r2.upperRight.y) || (r2.lowerLeft.y >= r1.upperRight.y)

    private fun isOneRectangleToLeftOfOther(r1: Rectangle, r2: Rectangle): Boolean =
        (r1.upperRight.x <= r2.lowerLeft.x) || (r2.upperRight.x <= r1.lowerLeft.x)


    private fun IntArray.toRectangle(): Rectangle =
        Rectangle(lowerLeft = Point2D(this[0], this[1]), upperRight = Point2D(this[2], this[3]))
}

data class Point2D(val x: Int, val y: Int)

data class Rectangle(
    val lowerLeft: Point2D,
    val upperRight: Point2D,
    val upperLeft: Point2D = Point2D(lowerLeft.x, upperRight.y),
    val lowerRight: Point2D = Point2D(upperRight.x, lowerLeft.y)
)
