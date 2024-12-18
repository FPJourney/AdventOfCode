package org.example

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val pattern = "XMAS".toRegex()
    val lines = read("day4/Input.txt")
    lines.flatMap { line -> pattern.findAll(line).map { it.value } }.count().also(::println)
    lines.flatMap { line -> pattern.findAll(line).map { it.value } }.count().also(::println)
}

fun read(file: String): Sequence<String> =
    Path(file).readLines().asSequence()