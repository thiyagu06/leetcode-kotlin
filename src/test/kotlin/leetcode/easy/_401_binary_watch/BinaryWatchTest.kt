package leetcode.easy._401_binary_watch

import kotlin.test.assertEquals
import org.junit.Test

class BinaryWatchTest {

    private val solution = Solution()

    @Test
    fun readBinaryWatch() {
        assertEquals(listOf("0:00"), solution.readBinaryWatch(0))

        val expected1 = listOf("1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32")
        val actual1 = solution.readBinaryWatch(1)
        assertEquals(expected1.size, actual1.size)
        assertEquals(expected1.toSet(), actual1.toSet())

        val expected2 = listOf(
            "0:03", "0:05", "0:06", "0:09", "0:10", "0:12", "0:17", "0:18", "0:20", "0:24", "0:33",
            "0:34", "0:36", "0:40", "0:48", "1:01", "1:02", "1:04", "1:08", "1:16", "1:32", "2:01",
            "2:02", "2:04", "2:08", "2:16", "2:32", "3:00", "4:01", "4:02", "4:04", "4:08", "4:16",
            "4:32", "5:00", "6:00", "8:01", "8:02", "8:04", "8:08", "8:16", "8:32", "9:00", "10:00"
        )
        val actual2 = solution.readBinaryWatch(2)
        assertEquals(expected2.size, actual2.size)
        assertEquals(expected2.toSet(), actual2.toSet())

        val expected3 = listOf(
            "0:07", "0:11", "0:13", "0:14", "0:19", "0:21", "0:22", "0:25", "0:26", "0:28", "0:35",
            "0:37", "0:38", "0:41", "0:42", "0:44", "0:49", "0:50", "0:52", "0:56", "1:03", "1:05",
            "1:06", "1:09", "1:10", "1:12", "1:17", "1:18", "1:20", "1:24", "1:33", "1:34", "1:36",
            "1:40", "1:48", "2:03", "2:05", "2:06", "2:09", "2:10", "2:12", "2:17", "2:18", "2:20",
            "2:24", "2:33", "2:34", "2:36", "2:40", "2:48", "3:01", "3:02", "3:04", "3:08", "3:16",
            "3:32", "4:03", "4:05", "4:06", "4:09", "4:10", "4:12", "4:17", "4:18", "4:20", "4:24",
            "4:33", "4:34", "4:36", "4:40", "4:48", "5:01", "5:02", "5:04", "5:08", "5:16", "5:32",
            "6:01", "6:02", "6:04", "6:08", "6:16", "6:32", "7:00", "8:03", "8:05", "8:06", "8:09",
            "8:10", "8:12", "8:17", "8:18", "8:20", "8:24", "8:33", "8:34", "8:36", "8:40", "8:48",
            "9:01", "9:02", "9:04", "9:08", "9:16", "9:32", "10:01", "10:02", "10:04", "10:08",
            "10:16", "10:32", "11:00"
        )
        val actual3 = solution.readBinaryWatch(3)
        assertEquals(expected3.size, actual3.size)
        assertEquals(expected3.toSet(), actual3.toSet())

        val expected8 = listOf("7:31", "7:47", "7:55", "7:59", "11:31", "11:47", "11:55", "11:59")
        val actual8 = solution.readBinaryWatch(8)
        assertEquals(expected8.size, actual8.size)
        assertEquals(expected8.toSet(), actual8.toSet())

        assertEquals(emptyList(), solution.readBinaryWatch(9))
        assertEquals(emptyList(), solution.readBinaryWatch(10))
    }

    @Test
    fun convertBitsToTime() {
        assertEquals("0:00", solution.convertBitsToTime("0000000000"))
        assertEquals("8:00", solution.convertBitsToTime("1000000000"))
        assertEquals("1:00", solution.convertBitsToTime("0001000000"))
        assertEquals("1:01", solution.convertBitsToTime("0001000001"))
        assertEquals("1:03", solution.convertBitsToTime("0001000011"))
        assertEquals("9:43", solution.convertBitsToTime("1001101011"))
        assertEquals("12:00", solution.convertBitsToTime("1100000000"))
    }

    @Test
    fun convertHourBits() {
        assertEquals(8, solution.convertHourBits("1000"))
        assertEquals(4, solution.convertHourBits("0100"))
        assertEquals(2, solution.convertHourBits("0010"))
        assertEquals(1, solution.convertHourBits("0001"))
        assertEquals(0, solution.convertHourBits("0000"))
        assertEquals(12, solution.convertHourBits("1100"))
        assertEquals(9, solution.convertHourBits("1001"))
    }

    @Test
    fun convertMinuteBits() {
        assertEquals(32, solution.convertMinuteBits("100000"))
        assertEquals(16, solution.convertMinuteBits("010000"))
        assertEquals(8, solution.convertMinuteBits("001000"))
        assertEquals(4, solution.convertMinuteBits("000100"))
        assertEquals(2, solution.convertMinuteBits("000010"))
        assertEquals(1, solution.convertMinuteBits("000001"))
        assertEquals(0, solution.convertMinuteBits("000000"))
        assertEquals(42, solution.convertMinuteBits("101010"))
        assertEquals(33, solution.convertMinuteBits("100001"))
    }
}