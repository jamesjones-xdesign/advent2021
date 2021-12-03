package day3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day3Test {

    @Test
    fun calc() {
        assertEquals(198, Part1().calc("src/test/resources/day3/rates"));
    }
}