import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Part2Test {

    @Test
    fun calc() {
        assertEquals(900, Part2().calc("test-commands"))
    }
}