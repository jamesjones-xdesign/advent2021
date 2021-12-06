package day3

import java.io.File

class Part2 {

    fun calc(file: String): Int {
        val rates: List<String> = File(file).useLines { it.toList() }
        val chars =  rates.map { it.toCharArray() }
        val o2 = filter(chars, 0, this::commonO2)
        val co2 = filter(chars, 0, this::commonCO2)
        val generator = Integer.parseInt(o2.flatMap { it.toList() }.joinToString(""), 2)
        val scrubber = Integer.parseInt(co2.flatMap { it.toList() }.joinToString(""), 2)
        return generator * scrubber
    }

    fun commonO2(states: Map<Int, Int>, index: Int): Char {
        val count = states[index]!!
        return if (count >= 0) 1.toString()[0] else 0.toString()[0]
    }

    fun commonCO2(states: Map<Int, Int>, index: Int): Char {
        val count = states[index]!!
        return if (count < 0) 1.toString()[0] else 0.toString()[0]
    }

    fun filter(rates: List<CharArray>, index: Int, func: (state: Map<Int, Int>, index: Int) -> Char): List<CharArray> {
        if (rates.size == 1) return rates
        val states = mutableMapOf<Int, Int>()
        rates.stream().forEach {
            it.toList().forEachIndexed { index, c ->
                when (c) {
                    "1".toCharArray()[0] -> { states.putIfAbsent(index, 0); states[index] = states[index]!! + 1 }
                    "0".toCharArray()[0] -> { states.putIfAbsent(index, 0); states[index] = states[index]!! - 1 }
                }
            }
        }
        val common = func(states, index)
        return filter(rates.filter { it[index] == common },index + 1, func)
    }

}