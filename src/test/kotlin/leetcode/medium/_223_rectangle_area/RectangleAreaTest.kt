package leetcode.medium._223_rectangle_area

import org.junit.Test

import org.junit.Assert.*

class RectangleAreaTest {

    private val solution = Solution()
    private val r1 = Rectangle(bottomLeft = Point2D(-3, 0), topRight = Point2D(3, 4))
    private val r2 = Rectangle(bottomLeft = Point2D(0, -1), topRight = Point2D(9, 2))

    @Test
    fun computeArea() {
        assertEquals(45, solution.computeArea(A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2))
        assertEquals(17, solution.computeArea(A = -2, B = -2, C = 2, D = 2, E = 3, F = 3, G = 4, H = 4))
    }

    @Test
    fun areaOfIntersection() {
        assertEquals(6, solution.areaOfIntersection(r1, r2))
        assertEquals(
            4,
            solution.areaOfIntersection(
                Rectangle(bottomLeft = Point2D(1, 1), topRight = Point2D(5, 3)),
                Rectangle(bottomLeft = Point2D(3, 0), topRight = Point2D(5, 4))
            )
        )
        assertEquals(
            0,
            solution.areaOfIntersection(
                Rectangle(bottomLeft = Point2D(-2, -2), topRight = Point2D(2, 2)),
                Rectangle(bottomLeft = Point2D(3, 3), topRight = Point2D(4, 4))
            )
        )
    }
}