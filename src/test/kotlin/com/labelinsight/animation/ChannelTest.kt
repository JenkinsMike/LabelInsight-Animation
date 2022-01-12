package com.labelinsight.animation

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


internal class ChannelTest {
    @Test
    fun `Test01, 4 steps`() {
        val speed = 2
        val init = "..R...."
        val expected = arrayOf("..X....", "....X..", "......X", ".......")
        val actual: Array<String> = Channel.animate(speed, init)
        assertArrayEquals(expected, actual)
        assertEquals(expected[0], actual[0])
        assertEquals(expected[1], actual[1])
        assertEquals(expected[2], actual[2])
        assertEquals(expected[3], actual[3])
    }

    @Test
    fun `Test02, 4 steps`() {
        val speed = 3
        val init = "RR..LRL"
        val expected = arrayOf("XX..XXX", ".X.XX..", "X.....X", ".......")
        val actual: Array<String> = Channel.animate(speed, init)
        assertArrayEquals(expected, actual)
        assertEquals(expected[0], actual[0])
        assertEquals(expected[1], actual[1])
        assertEquals(expected[2], actual[2])
        assertEquals(expected[3], actual[3])
    }

    @Test
    fun `Test03, 5 steps`() {
        val speed = 2
        val init = "LRLR.LRLR"
        val expected = arrayOf("XXXX.XXXX", "X..X.X..X", ".X.X.X.X.", ".X.....X.", ".........")
        val actual: Array<String> = Channel.animate(speed, init)
        assertArrayEquals(expected, actual)
        assertEquals(expected[0], actual[0])
        assertEquals(expected[1], actual[1])
        assertEquals(expected[2], actual[2])
        assertEquals(expected[3], actual[3])
        assertEquals(expected[4], actual[4])
    }

    @Test
    fun `Test04, 2 steps`() {
        val speed = 10
        val init = "RLRLRLRLRL"
        val expected = arrayOf("XXXXXXXXXX", "..........")
        val actual: Array<String> = Channel.animate(speed, init)
        assertArrayEquals(expected, actual)
        assertEquals(expected[0], actual[0])
        assertEquals(expected[1], actual[1])
    }

    @Test
    fun `Test05, 1 steps`() {
        val speed = 1
        val init = "..."
        val expected = arrayOf("...")
        val actual: Array<String> = Channel.animate(speed, init)
        assertArrayEquals(expected, actual)
        assertEquals(expected[0], actual[0])
    }

    @Test
    fun `Test06, tons of steps, not checking iteratively`() {
        val speed = 1
        val init = "LRRL.LR.LRR.R.LRRL."
        val expected = arrayOf(
            "XXXX.XX.XXX.X.XXXX.", "..XXX..X..XX.X..XX.", ".X.XX.X.X..XX.XX.XX",
            "X.X.XX...X.XXXXX..X", ".X..XXX...X..XX.X..", "X..X..XX.X.XX.XX.X.", "..X....XX..XX..XX.X",
            ".X.....XXXX..X..XX.", "X.....X..XX...X..XX", ".....X..X.XX...X..X", "....X..X...XX...X..",
            "...X..X.....XX...X.", "..X..X.......XX...X", ".X..X.........XX...", "X..X...........XX..",
            "..X.............XX.", ".X...............XX", "X.................X", "..................."
        )
        val actual: Array<String> = Channel.animate(speed, init)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `Test07, tons of steps, not checking iteratively, just checking size`() {
        val speed = 1
        val init = "LRRLL.RLRRRLRRLL.RLRRRLRRLL.RLRRRLRRLL.RLRRRLRRLL.RLRRRLRRLL.RLRRR"
        val expectedSteps = 66
        val actual: Array<String> = Channel.animate(speed, init)
        assertEquals(expectedSteps, actual.size)
    }
}
