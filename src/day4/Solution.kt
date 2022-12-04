package day4

import readInput

fun main() {

    fun temp(pair: String) = pair.split("-").map { it.toInt() }

    fun temo2(firstElf: List<Int>): Set<Int> {
        val set = HashSet<Int>()
        for (i in firstElf[0]..firstElf[1]) {
            set.add(i)
        }
        return set
    }

    fun temp(input: List<String>) = input
        .map { pairString -> pairString.split(",") }
        .map { pairList ->
            val firstElf = temp(pairList[0])
            val secondElf = temp(pairList[1])
            val firstSet = temo2(firstElf)
            val secondSet = temo2(secondElf)
            Pair(firstSet, secondSet)
        }

    fun part1(input: List<String>): Int {
        return temp(input)
            .count {
                it.first.containsAll(it.second) or it.second.containsAll(it.first)
            }
    }

    fun part2(input: List<String>): Int {
        return temp(input)
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
