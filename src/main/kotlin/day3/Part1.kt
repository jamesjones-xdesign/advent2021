package day3

import java.io.File

class Part1 {

    fun calc(file: String): Int {
        val states = mutableMapOf<Int, Int>()
        val rates: List<String> = File(file).useLines { it.toList() }
        rates.map { it.toCharArray() }.stream().forEach {
            it.toList().forEachIndexed { index, c ->
                when (c) {
                    "1".toCharArray()[0] -> { states.putIfAbsent(index, 0); states[index] = states[index]!! + 1 }
                    "0".toCharArray()[0] -> { states.putIfAbsent(index, 0); states[index] = states[index]!! - 1 }
                }
            }
        }

        val gamma = Integer.parseInt(states.values.map { v -> if (v > 0) 1 else 0 }.joinToString(""), 2)
        val epsilon = Integer.parseInt(states.values.map { v -> if (v > 0) 0 else 1 }.joinToString(""), 2)
        println(gamma)
        println(epsilon)
        return gamma * epsilon
    }

}