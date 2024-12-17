package org.example

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val part1Regex = Regex("mul\\(\\d{1,3},\\d{1,3}\\)")
    val multsLists = read("day3/Input.txt")
    multsLists.parseInput(part1Regex)
        .map(::calculateMul)
        .sum()
        .also(::println)
    val part2Regex = Regex("""do\(\)|don't\(\)|mul\(\d{1,3},\d{1,3}\)""")
    multsLists.parseInput(part2Regex)
        .fold(Pair(true, 0L), ::calculateMulConditionally)
        .also { println(it.second) }
}

fun read(file: String): Sequence<String> =
    Path(file).readLines().asSequence()

fun Sequence<String>.parseInput(regex: Regex): Sequence<String> =
    flatMap { str -> regex.findAll(str).map { it.value } }

fun calculateMul(mul: String): Long =
    Regex("\\d{1,3}").findAll(mul).map { it.value.toLong() }.reduce { a, b -> a * b }

fun calculateMulConditionally(acc: Pair<Boolean, Long>, str: String): Pair<Boolean, Long> {
    val (flag, sum) = acc
    return when (str) {
        "do()" -> Pair(true, sum)
        "don't()" -> Pair(false, sum)
        else -> when (Pair(flag, sum)) {
            Pair(true, sum) -> Pair(true, sum + calculateMul(str))
            Pair(false, sum) -> Pair(false, sum)
            else -> acc
        }
    }
}