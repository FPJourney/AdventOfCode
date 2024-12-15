package org.example

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val multsLists = read("day3/Input.txt")
    val multResultsLists: Sequence<List<Long>> = multsLists.map { strings -> strings.map(::calculateMul) }
    val summedResultsList = multResultsLists.map { it.reduce { a, b -> a + b } }
    // summedResultsList.forEach(::println)
    println(summedResultsList.sum())
}

fun read(file: String): Sequence<List<String>> =
    Path(file).readLines().asSequence()
        .map { str -> Regex("mul\\(\\d{1,3},\\d{1,3}\\)").findAll(str).map { it.value }.toList() }

fun calculateMul(mul: String) = Regex("\\d{1,3}").findAll(mul).map { it.value.toLong() }.reduce { a, b -> a * b }