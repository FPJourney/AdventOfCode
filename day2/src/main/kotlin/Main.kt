package org.example

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val reportListLevelDiffs: Sequence<List<Int>> =
        read("day2/Input.txt").asSequence()
            .map { str -> str.split(" ").map { it.toInt() } }
            .map { ints -> ints.zipWithNext { a, b -> b - a } }
    reportListLevelDiffs.map(::isSafeReport).count { it == true }.also(::println)
}

fun read(file: String) = Path(file).readLines()

fun isSafeReport(levelDiffs: List<Int>): Boolean = levelDiffs.all { it > 0 && it in (1..3) } ||
        levelDiffs.all { it < 0 && -it in (1..3) }