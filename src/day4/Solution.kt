package day4

import readInput

fun main() {

    fun String.toSections() = this
        .split("-")
        .map { it.toInt() }

    fun List<Int>.toSectionSet(): Set<Int> {
        val set = HashSet<Int>()
        for (i in this[0]..this[1]) {
            set.add(i)
        }
        return set
    }

    fun List<String>.toElvesPairSectionsSets() = this
        .map { pairString -> pairString.split(",") }
        .map { pairList ->
            Pair(
                pairList[0].toSections().toSectionSet(),
                pairList[1].toSections().toSectionSet()
            )
        }

    fun part1(input: List<String>): Int {
        return input.toElvesPairSectionsSets()
            .count {
                it.first.containsAll(it.second) or it.second.containsAll(it.first)
            }
    }

    fun part2(input: List<String>): Int {
        return input.toElvesPairSectionsSets()
            .count {
                it.first.intersect(it.second).isNotEmpty()
            }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day4/Input_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("day4/Input")
    println(part1(input))
    println(part2(input))
}
