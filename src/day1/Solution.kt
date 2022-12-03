package day1

import readInput

fun main() {
    fun getElves(input: List<String>): ArrayList<Int> {
        val elves = arrayListOf<Int>()
        var elve = 0
        input.forEach {
            if (it == "") {
                elves.add(elve)
                elve = 0
            } else {
                elve += it.toInt()
            }
        }
        elves.add(elve)
        return elves
    }

    fun part1(input: List<String>): Int {
        return getElves(input).max()
    }

    fun part2(input: List<String>): Int {
        return getElves(input)
            .sortedByDescending { it }
            .take(3)
            .sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day1/Input_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("day1/Input")
    println(part1(input))
    println(part2(input))
}
