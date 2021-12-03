package day2

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day2Test {

    @Test
    fun calc() {
        assertEquals(150, Part1().calc("src/test/resources/day2/test-commands"));
        assertEquals(900, Part2().calc("src/test/resources/day2/test-commands"));
    }
}