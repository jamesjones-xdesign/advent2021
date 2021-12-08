package day4

import java.io.File

class Part1 {

    fun play(numbers: String, boards: String) {
        val numbers: List<Int> = File(numbers).readText().split(",").map(String::toInt)

        val rows: List<Set<Int>> = File(boards).readLines()
            .filter { it.isNotBlank() }
            .map { line -> line.split(" ")
                .filter { it.isNotBlank() }
                .map { it.toInt() }
                .toSet()
            }.toList()

        val boards = rows.windowed(5, 5)

        println(numbers)
        println(rows)
        println(boards)
    }
}