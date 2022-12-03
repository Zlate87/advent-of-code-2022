package day2

import readInput

fun main() {

    fun score1(round: String): Int {
        val elveHand = Hand.from(round[0])!!
        val myHand = Hand.from(round[2])!!

        if (elveHand == Hand.ELVE_ROCK && myHand == Hand.MY_ROCK) return 3 + myHand.scoreWhenWih
        if (elveHand == Hand.ELVE_ROCK && myHand == Hand.MY_PAPER) return 6 + myHand.scoreWhenWih
        if (elveHand == Hand.ELVE_ROCK && myHand == Hand.MY_SCISSORS) return 0 + myHand.scoreWhenWih

        if (elveHand == Hand.ELVE_PAPER && myHand == Hand.MY_ROCK) return 0 + myHand.scoreWhenWih
        if (elveHand == Hand.ELVE_PAPER && myHand == Hand.MY_PAPER) return 3 + myHand.scoreWhenWih
        if (elveHand == Hand.ELVE_PAPER && myHand == Hand.MY_SCISSORS) return 6 + myHand.scoreWhenWih

        if (elveHand == Hand.ELVE_SCISSORS && myHand == Hand.MY_ROCK) return 6 + myHand.scoreWhenWih
        if (elveHand == Hand.ELVE_SCISSORS && myHand == Hand.MY_PAPER) return 0 + myHand.scoreWhenWih
        if (elveHand == Hand.ELVE_SCISSORS && myHand == Hand.MY_SCISSORS) return 3 + myHand.scoreWhenWih

        throw java.lang.RuntimeException("Combination not possible for round $round")
    }

    fun score2(round: String): Int {
        val elveHand = Hand.from(round[0])!!
        val myHand = Hand.from(elveHand, round[2])

        if (elveHand == Hand.ELVE_ROCK && myHand == Hand.MY_ROCK) return 3 + myHand.scoreWhenWih
        if (elveHand == Hand.ELVE_ROCK && myHand == Hand.MY_PAPER) return 6 + myHand.scoreWhenWih
        if (elveHand == Hand.ELVE_ROCK && myHand == Hand.MY_SCISSORS) return 0 + myHand.scoreWhenWih

        if (elveHand == Hand.ELVE_PAPER && myHand == Hand.MY_ROCK) return 0 + myHand.scoreWhenWih
        if (elveHand == Hand.ELVE_PAPER && myHand == Hand.MY_PAPER) return 3 + myHand.scoreWhenWih
        if (elveHand == Hand.ELVE_PAPER && myHand == Hand.MY_SCISSORS) return 6 + myHand.scoreWhenWih

        if (elveHand == Hand.ELVE_SCISSORS && myHand == Hand.MY_ROCK) return 6 + myHand.scoreWhenWih
        if (elveHand == Hand.ELVE_SCISSORS && myHand == Hand.MY_PAPER) return 0 + myHand.scoreWhenWih
        if (elveHand == Hand.ELVE_SCISSORS && myHand == Hand.MY_SCISSORS) return 3 + myHand.scoreWhenWih

        throw java.lang.RuntimeException("Combination not possible for round $round")
    }

    fun part1(input: List<String>): Int {
        return input.sumOf { score1(it) }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { score2(it) }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day2/Input_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("day2/Input")
    println(part1(input))
    println(part2(input))
}

enum class Hand(val code: Char, val scoreWhenWih: Int) {
    ELVE_ROCK('A', 1),
    ELVE_PAPER('B', 2),
    ELVE_SCISSORS('C', 3),
    MY_ROCK('X', 1),
    MY_PAPER('Y', 2),
    MY_SCISSORS('Z', 3);

    companion object {
        private val map = Hand.values().associateBy { it.code }
        infix fun from(code: Char) = map[code]
        fun from(elveHand: Hand, code: Char): Hand {
            if (elveHand == ELVE_ROCK && code == 'X') return MY_SCISSORS
            if (elveHand == ELVE_ROCK && code == 'Y') return MY_ROCK
            if (elveHand == ELVE_ROCK && code == 'Z') return MY_PAPER

            if (elveHand == ELVE_PAPER && code == 'X') return MY_ROCK
            if (elveHand == ELVE_PAPER && code == 'Y') return MY_PAPER
            if (elveHand == ELVE_PAPER && code == 'Z') return MY_SCISSORS

            if (elveHand == ELVE_SCISSORS && code == 'X') return MY_PAPER
            if (elveHand == ELVE_SCISSORS && code == 'Y') return MY_SCISSORS
            if (elveHand == ELVE_SCISSORS && code == 'Z') return MY_ROCK

            throw java.lang.RuntimeException("Invalid combination $elveHand $code")
        }
    }

}
