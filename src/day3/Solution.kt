package day3

import readInput

fun main() {

    fun getIntValue(it: Char) = if (it.isLowerCase()) it.toInt() - 96 else it.toInt() - 38

    fun getValue1(line: String): Int {
        val substring1 = line.substring(0, line.length / 2)
        val substring2 = line.substring(line.length / 2)
        substring1.forEach { if (substring2.contains(it)) return getIntValue(it) }
        throw java.lang.RuntimeException()
    }

    fun part1(input: List<String>): Int {
        return input.sumOf { getValue1(it) }
    }

    fun getValue2(strings: List<String>): Int {
        strings[0].forEach { if (strings[1].contains(it) && strings[2].contains(it)) return getIntValue(it) }
        throw java.lang.RuntimeException()
    }

    fun part2(input: List<String>): Int {
        return input.chunked(3).sumOf { getValue2(it) }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day3/Input_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("day3/Input")
    println(part1(input))
    println(part2(input))
}
