package org.example

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val pattern = "XMAS".toRegex()
    val patternValue = "XMAS".sumOf { it.code } //313
//    println("pattern value is $patternValue")
    val lines = read("day4/Input.txt")
    //Input is a 140 * 140 matrix and only contains letters in the word XMAS
//    lines.first().count().also(::println)
//    lines.count().also(::println)
    lines.flatMap { line -> pattern.findAll(line).map { it.value } }.count().also(::println)
    lines.flatMap { line -> pattern.findAll(line.reversed()).map { it.value } }.count().also(::println)
}

fun read(file: String): Sequence<String> =
    Path(file).readLines().asSequence()