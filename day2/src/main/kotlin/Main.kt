package org.example

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val reportList: Sequence<List<Int>> = read("day2/Input.txt")
    reportList.getLevelDiffs().count(::isSafeReport).also(::println)
    reportList.count { report -> isSafeReport(report) || isSafeReportDampened(report) }.also(::println)
}

fun read(file: String): Sequence<List<Int>> =
    Path(file).readLines().asSequence().map { str -> str.split(" ").map(String::toInt) }

fun Sequence<List<Int>>.getLevelDiffs(): Sequence<List<Int>> = map { report -> report.zipWithNext { a, b -> b - a } }

fun isSafeReport(levelDiffs: List<Int>): Boolean = levelDiffs.all { it > 0 && it in (1..3) } ||
        levelDiffs.all { it < 0 && -it in (1..3) }

fun isSafeReportDampened(levelDiffs: List<Int>): Boolean =
    levelDiffs.count { it > 0 && it in (1..3) } == levelDiffs.size - 1 ||
            levelDiffs.count { it < 0 && -it in (1..3) } == levelDiffs.size - 1