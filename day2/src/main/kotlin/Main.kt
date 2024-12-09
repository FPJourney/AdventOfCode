package org.example

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val reportList: Sequence<List<Int>> = read("day2/Input.txt")
    reportList.map { levels -> levels.getLevelDiffs() }.count(::isSafeReport).also(::println) //this is correct: 279
    reportList.map { levels -> levels.getLevelDiffs() }
        .count { report -> isSafeReport(report) || isSafeReportDampened(report) }
        .also(::println) // should be smaller than 350!!
}

fun read(file: String): Sequence<List<Int>> =
    Path(file).readLines().asSequence().map { str -> str.split(" ").map(String::toInt) }

fun List<Int>.getLevelDiffs(): List<Int> = zipWithNext { a, b -> b - a }

fun isSafeReport(levelDiffs: List<Int>): Boolean = levelDiffs.all { it > 0 && it in (1..3) } ||
        levelDiffs.all { it < 0 && -it in (1..3) }

fun isSafeReportDampened(levelDiffs: List<Int>): Boolean =
    levelDiffs.count { it > 0 && it in (1..3) } == levelDiffs.size - 1 ||
            levelDiffs.count { it < 0 && -it in (1..3) } == levelDiffs.size - 1