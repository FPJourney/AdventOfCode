package org.example

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val reportList: Sequence<List<Int>> = read("day2/Input.txt")
    reportList.count { it.isSafeReport() }.also(::println) //this is correct: 279
    reportList.count { it.isSafeDampenedReport() }.also(::println) // should be smaller than 350!!
}

fun read(file: String): Sequence<List<Int>> =
    Path(file).readLines().asSequence().map { str -> str.split(" ").map(String::toInt) }

fun List<Int>.getLevelDiffs(): List<Int> = zipWithNext { a, b -> b - a }

fun List<Int>.isSafeReport(): Boolean {
    val levelDiffs = getLevelDiffs()
    return levelDiffs.all { it > 0 && it in (1..3) } ||
            levelDiffs.all { it < 0 && -it in (1..3) }
}

//Fixme: value should be smaller than 350 and bigger than 338
fun List<Int>.isSafeDampenedReport(): Boolean {
    return isSafeReport() || any { level -> (this - level).isSafeReport() }
}