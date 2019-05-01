package leetcode.medium._223_rectangle_area

import kotlin.math.max
import kotlin.math.min

/**
 * 223 - https://leetcode.com/problems/rectangle-area
 */
class Solution {
    fun computeArea(A: Int, B: Int, C: Int, D: Int, E: Int, F: Int, G: Int, H: Int): Int {
        val r1 = Rectangle(bottomLeft = Point2D(A, B), topRight = Point2D(C, D))
        val r2 = Rectangle(bottomLeft = Point2D(E, F), topRight = Point2D(G, H))

        // Total Area = ((Area of R1) + (Area of R2)) - (Area of Intersection)
        return (r1.area + r2.area) - areaOfIntersection(r1, r2)
    }

    internal fun areaOfIntersection(r1: Rectangle, r2: Rectangle): Int {
        if (!r1.overlapsWith(r2)) return 0

        val w = min(r1.topRight.x, r2.topRight.x) - max(r1.bottomLeft.x, r2.bottomLeft.x)
        val h = min(r1.topRight.y, r2.topRight.y) - max(r1.bottomLeft.y, r2.bottomLeft.y)
        return w * h
    }
}

data class Point2D(val x: Int, val y: Int)

data class Rectangle(
    val bottomLeft: Point2D,
    val topRight: Point2D,
    val topLeft: Point2D = Point2D(bottomLeft.x, topRight.y),
    val bottomRight: Point2D = Point2D(topRight.x, bottomLeft.y)
) {
    val area: Int get() = (topRight.x - bottomLeft.x) * (topRight.y - bottomLeft.y)

    fun overlapsWith(r2: Rectangle): Boolean {
        val isOneRectangleAboveOther = (bottomLeft.y >= r2.topRight.y) || (r2.bottomLeft.y >= topRight.y)
        val isOneRectangleToLeftOfOther = (topRight.x <= r2.bottomLeft.x) || (r2.topRight.x <= bottomLeft.x)
        return !isOneRectangleAboveOther && !isOneRectangleToLeftOfOther
    }
}
