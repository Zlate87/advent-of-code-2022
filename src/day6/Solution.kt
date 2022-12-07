package day6

import java.io.File

fun main() {

    fun String.positionOfUnique(size: Int) = this
        .toCharArray()
        .toList()
        .windowed(size, 1)
        .map { it.toSet() }
        .indexOfFirst { it.size == size } + size

    fun part1(input: String): Int {
        return input.positionOfUnique( 4)
    }

    fun part2(input: String): Int {
        return input.positionOfUnique( 14)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = File("src/day6/Input_test.txt").readText()
    check(part1(testInput) == 5)
    check(part2(testInput) == 23)

    val input = File("src/day6/Input.txt").readText()
    println(part1(input))
    println(part2(input))
}
