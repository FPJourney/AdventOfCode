package org.example

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val multsLists = read("day3/Input.txt")
    multsLists.map { strings -> strings.map(::calculateMul) }.forEach(::println)
}

fun read(file: String): Sequence<List<String>> =
    Path(file).readLines().asSequence()
        .map { str -> Regex("mul\\(\\d{1,3},\\d{1,3}\\)").findAll(str).map { it.value }.toList() }

fun calculateMul(mul: String) = Regex("\\d{1,3}").findAll(mul).map { it.value.toInt() }.reduce { a, b -> a * b }