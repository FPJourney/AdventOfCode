package org.example

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val part1Regex = Regex("mul\\(\\d{1,3},\\d{1,3}\\)")
    val multsLists = read("day3/Input.txt")
    multsLists.parseInput(part1Regex)
        .flatMap { strings -> strings.map(::calculateMul) }
        .sum()
        .also(::println)
    val part2Regex = Regex("do\\(\\)|don't\\(\\)|mul\\(\\d{1,3},\\d{1,3}\\)")
    multsLists.parseInput(part2Regex)
        .flatMap { strings -> strings.filterNot { it == "do()" || it == "don't()" }.map(::calculateMul) }
        //.map { it.sum() }
        .sum()
        .also(::println)
}

fun read(file: String): Sequence<String> =
    Path(file).readLines().asSequence()


fun Sequence<String>.parseInput(regex: Regex): Sequence<List<String>> =
    map { str -> regex.findAll(str).map { it.value }.toList() }

fun calculateMul(mul: String): Long =
    Regex("\\d{1,3}").findAll(mul).map { it.value.toLong() }.reduce { a, b -> a * b }