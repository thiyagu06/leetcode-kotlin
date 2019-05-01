package leetcode.easy._836_rectangle_overlap

/**
 * 836 - https://leetcode.com/problems/rectangle-overlap/
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
        (r1.bottomLeft.y >= r2.topRight.y) || (r2.bottomLeft.y >= r1.topRight.y)

    private fun isOneRectangleToLeftOfOther(r1: Rectangle, r2: Rectangle): Boolean =
        (r1.topRight.x <= r2.bottomLeft.x) || (r2.topRight.x <= r1.bottomLeft.x)


    private fun IntArray.toRectangle(): Rectangle =
        Rectangle(bottomLeft = Point2D(this[0], this[1]), topRight = Point2D(this[2], this[3]))
}

data class Point2D(val x: Int, val y: Int)

data class Rectangle(
    val bottomLeft: Point2D,
    val topRight: Point2D,
    val topLeft: Point2D = Point2D(bottomLeft.x, topRight.y),
    val bottomRight: Point2D = Point2D(topRight.x, bottomLeft.y)
)
