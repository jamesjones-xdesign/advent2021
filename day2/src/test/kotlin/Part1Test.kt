import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Part1Test {

    @Test
    fun calc() {
        assertEquals(150, Part1().calc("test-commands"))
    }
}