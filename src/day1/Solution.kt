package day1

import java.io.File

fun main() {
    fun getElvesCalories(input: String): List<Int> {
        return input
            .split("\n\n")
            .map { elfCaloriesString ->
                elfCaloriesString.split("\n")
                    .sumOf { elfCalories -> elfCalories.toInt() }
            }
    }

    fun part1(input: String): Int {
        return getElvesCalories(input)
            .max()
    }

    fun part2(input: String): Int {
        return getElvesCalories(input)
            .sortedDescending()
            .take(3)
            .sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = File("src/day1/Input_test.txt").readText()
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = File("src/day1/Input.txt").readText()
    println(part1(input))
    println(part2(input))
}
