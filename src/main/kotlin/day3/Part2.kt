package day3

import java.io.File

class Part2 {

    fun calc(file: String): Int {
        val states = mutableMapOf<Int, Int>()
        val rates: List<String> = File(file).useLines { it.toList() }
        val chars =  rates.map { it.toCharArray() }
            chars.stream().forEach {
            it.toList().forEachIndexed { index, c ->
                when (c) {
                    "1".toCharArray()[0] -> { states.putIfAbsent(index, 0); states[index] = states[index]!! + 1 }
                    "0".toCharArray()[0] -> { states.putIfAbsent(index, 0); states[index] = states[index]!! - 1 }
                }
            }
        }
        val o2 = o2(chars, states, 0,  1.toString()[0])
        val co2 = co2(chars, states, 0, 0.toString()[0])

    }

    fun commonO2(states: Map<Int, Int>, index: Int): Char {
        return if (states[index]!! > 0) 1.toString()[0] else 0.toString()[0]
    }

    fun commonCO2(states: Map<Int, Int>, index: Int): Char {
        return if (states[index]!! > 0) 0.toString()[0] else 1.toString()[0]
    }

    fun o2(rates: List<CharArray>, states: Map<Int, Int>, index: Int, decider: Char): List<CharArray> {
        if (rates.size == 1) return rates
        if (rates.size == 2) return rates.filter { it[index] == decider }
        return o2(rates.filter { it[index] == commonO2(states, index) }, states, index + 1, decider)
    }

    fun co2(rates: List<CharArray>, states: Map<Int, Int>, index: Int, decider: Char): List<CharArray> {
        if (rates.size == 1) return rates
        if (rates.size == 2) return rates.filter { it[index] == decider }
        return co2(rates.filter { it[index] == commonCO2(states, index) }, states, index + 1, decider)
    }

}