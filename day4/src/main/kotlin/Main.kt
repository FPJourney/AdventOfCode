package org.example

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val pattern = "XMAS".toRegex()
    read("day4/Input.txt").count { it.contains(pattern) }.also(::println)
}

fun read(file: String): Sequence<String> =
    Path(file).readLines().asSequence()