package com.janbina.aoc20.solutions

import com.janbina.aoc20.utils.Input

fun main() {
    val input = Input.getDayInputLines(1)
    DayXX(input).also {
        println(it.part1())
        println(it.part2())
    }
}

class DayXX(
    private val inputLines: List<String>
) {

    private val inputInts by lazy { inputLines.map { it.toInt() } }
    private val inputLinesSplitted by lazy {
        inputLines.map {
            it.split(",")
        }
    }

    fun part1(): Any {

        return 0
    }

    fun part2(): Any {

        return 0
    }
}
