package org.example

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val part1Regex = Regex("mul\\(\\d{1,3},\\d{1,3}\\)")
    val multsLists = read("day3/Input.txt")
    val multResultsLists: Sequence<List<Long>> =
        multsLists.parseInput(part1Regex).map { strings -> strings.map(::calculateMul) }
    val summedResultsList = multResultsLists.map { it.sum() }
    // summedResultsList.forEach(::println)
    println(summedResultsList.sum())
}

fun read(file: String): Sequence<String> =
    Path(file).readLines().asSequence()


fun Sequence<String>.parseInput(regex: Regex): Sequence<List<String>> =
    map { str -> regex.findAll(str).map { it.value }.toList() }

fun calculateMul(mul: String): Long =
    Regex("\\d{1,3}").findAll(mul).map { it.value.toLong() }.reduce { a, b -> a * b }