package day5

import java.io.File

fun main() {

    fun toStacks(input: List<String>): ArrayList<ArrayDeque<Char>> {
        val matrix = ArrayList(input.map { it.toCharArray() })
        val numberOfRows = (matrix[0].size + 2) / 4

        val header = matrix.removeAt(0)

        println(header)
        matrix.forEach {
            println(it)
        }
        println("")

        val stacks = ArrayList<ArrayDeque<Char>>()
        repeat((1..numberOfRows).count()) {
            stacks.add(ArrayDeque())
        }


        matrix.forEachIndexed { columIndex, row ->
            row.forEachIndexed { rowIndex, value ->
                if (header.size > rowIndex && header[rowIndex] != ' ' && value != ' ') {
                    println("$columIndex XXX $rowIndex XXX ${header[rowIndex].digitToInt()} XXX $value ")
                    stacks[header[rowIndex].digitToInt() - 1].add(value)
                }

            }
        }
        return stacks
    }

    fun toPairInputs(input: String): Pair<List<String>, List<String>> {
        val split = input
            .split("\n\n")
            .map { it.split("\n") }
        return Pair(split[0], split[1])
    }

    fun ArrayList<ArrayDeque<Char>>.move(krainInput: List<String>) {
        krainInput.forEach {
            println(it)
        }

        val instructionsTriple = krainInput.map {
            val instructions = it.split(" ")
            Triple(instructions[1].toInt(), instructions[3].toInt(), instructions[5].toInt())
        }

        println("XXXXXXX")

        instructionsTriple.forEach { instruction ->
            println(instruction)
            for (i in 0..instruction.first - 1) {
                this.forEach {
                    it.forEach {
                        print(it)
                    }
                    println()
                }
                println()
                this[instruction.third - 1]
                    .add(
                        this[instruction.second - 1]
                            .removeLastOrNull()!!
                    )
            }
        }
    }

    fun ArrayList<ArrayDeque<Char>>.move2(krainInput: List<String>) {
        krainInput.forEach {
            println(it)
        }

        val instructionsTriple = krainInput.map {
            val instructions = it.split(" ")
            Triple(instructions[1].toInt(), instructions[3].toInt(), instructions[5].toInt())
        }

        println("XXXXXXX")

        instructionsTriple.forEach { instruction ->
            println(instruction)
            val movingLoad = ArrayList<Char>()
            for (i in 0..instruction.first - 1) {
                this.forEach {
                    it.forEach {
                        print(it)
                    }
                    println()
                }
                println()
                movingLoad
                    .add(
                        this[instruction.second - 1]
                            .removeLastOrNull()!!
                    )
            }
            this[instruction.third - 1].addAll(movingLoad.reversed())
        }
    }

    fun part1(input: String): String {
        val inputPair = toPairInputs(input)
        val stacks: ArrayList<ArrayDeque<Char>> = toStacks(inputPair.first.reversed())

        println()
        stacks.forEach {
            it.forEach {
                print(it)
            }
            println()
        }

        stacks.move(inputPair.second)
        var topElements = ""
        stacks.forEach {
            topElements += it.last()
        }
        return topElements
    }

    fun part2(input: String): String {
        val inputPair = toPairInputs(input)
        val stacks: ArrayList<ArrayDeque<Char>> = toStacks(inputPair.first.reversed())

        println()
        stacks.forEach {
            it.forEach {
                print(it)
            }
            println()
        }

        stacks.move2(inputPair.second)
        var topElements = ""
        stacks.forEach {
            topElements += it.last()
        }
        return topElements
    }

// test if implementation meets criteria from the description, like:
    val testInput = File("src/day5/Input_test.txt").readText()
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = File("src/day5/Input.txt").readText()
    println(part1(input))
    println(part2(input))
}
