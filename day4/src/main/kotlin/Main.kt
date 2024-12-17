package org.example

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    read("day4/Input.txt").count().also(::println)
}

fun read(file: String): Sequence<String> =
    Path(file).readLines().asSequence()