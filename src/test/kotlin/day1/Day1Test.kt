package day1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day1Test {

    @Test
    fun calc() {
        assertEquals(7, Part1().calc("src/test/resources/day1/test-depths"))
        assertEquals(5, Part2().calc("src/test/resources/day1/test-depths"))
    }
}