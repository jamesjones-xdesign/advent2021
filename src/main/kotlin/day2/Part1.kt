package day2

import java.io.File

class Part1 {

    fun calc(file: String): Int {
        val instructions: List<String> = File(file).useLines { it.toList() }
        val commands: List<Command> = instructions.map { Command(it.split(" ")[0], it.split(" ")[1].toInt()) }

        var horizontal = 0
        var depth = 0
        commands.forEach() {
           when (it.action) {
               "forward" -> horizontal += it.distance
               "up" -> depth -= it.distance
               "down" -> depth += it.distance
           }
        }
        println(horizontal)
        println(depth)
        println(horizontal * depth)
        return horizontal * depth
    }

}