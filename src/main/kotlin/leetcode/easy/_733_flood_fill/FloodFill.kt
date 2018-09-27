package leetcode.easy._733_flood_fill

import extensions.arrays.IntMatrix
import extensions.lists.columnRange
import extensions.lists.rowRange
import java.util.*

/**
 * 733 - https://leetcode.com/problems/flood-fill/
 */

typealias Image = MutableList<MutableList<Pixel>>

data class Pixel(val x: Int, val y: Int, val color: Int, val visited: Boolean) {
    override fun toString(): String = "(($x, $y), color=$color, visited=$visited)"
}

class Solution {
    private lateinit var image: Image

    fun floodFill(img: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        image = img.toPixelMatrix()

        if (newColor == img[sr][sc]) {
            return img
        }

        val pixels: Queue<Pixel> = ArrayDeque<Pixel>()
        pixels.add(Pixel(sr, sc, img[sr][sc], false))
        floodFillNeighbors(pixels, img[sr][sc], newColor)
        return image.toArrayFormat()
    }

    private fun floodFillNeighbors(pixels: Queue<Pixel>, originalColor: Int, newColor: Int) {
        while (pixels.isNotEmpty()) {
            val currentPixel = pixels.remove()
            changeColorAndMarkVisited(image[currentPixel.x][currentPixel.y], newColor)

            val neighbors = getNeighboringPixels(currentPixel)
            val (toFill, _) = neighbors.partition { it.color == originalColor }
            toFill.filterNot {
                it.visited
            }.forEach {
                pixels.offer(it)
            }

            neighbors.forEach { markVisited(it) }
        }
    }

    /**
     * Returns the neighboring pixels that are 4-directionally connected to the pixel
     * and are valid for the given image.
     */
    private fun getNeighboringPixels(pixel: Pixel): List<Pixel> {
        return setOf(
            (pixel.x - 1 to pixel.y),
            (pixel.x + 1 to pixel.y),
            (pixel.x to pixel.y - 1),
            (pixel.x to pixel.y + 1)
        ).asSequence().filter { (x, y) ->
            x in image.rowRange && y in image.columnRange
        }.map { (x, y) ->
            image[x][y]
        }.toList()
    }

    private fun markVisited(pixel: Pixel) {
        image[pixel.x][pixel.y] = pixel.copy(visited = true)
    }

    private fun changeColorAndMarkVisited(pixel: Pixel, newColor: Int) {
        image[pixel.x][pixel.y] = pixel.copy(color = newColor, visited = true)
    }


    private fun IntMatrix.toPixelMatrix(): Image = foldIndexed(mutableListOf()) { rowIndex, acc, row ->
        acc.apply {
            val pixelRow = row.mapIndexed { columnIndex, color ->
                Pixel(x = rowIndex, y = columnIndex, color = color, visited = false)
            }
            acc += pixelRow.toMutableList()
        }
    }

    private fun Image.toArrayFormat(): Array<IntArray> {
        val color2DList = image.map { row ->
            row.map { it.color }
        }
        return Array(size = size, init = { i -> color2DList[i].toIntArray() })
    }
}

