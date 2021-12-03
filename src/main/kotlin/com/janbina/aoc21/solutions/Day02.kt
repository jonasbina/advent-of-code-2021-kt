package com.janbina.aoc20.solutions

import com.janbina.aoc20.utils.Input

fun main() {
    val input = Input.getDayInputLines(2)
    Day02(input).also {
        println(it.part1())
        println(it.part2())
    }
}

class Day02(
    private val inputLines: List<String>
) {

    private val inputInts by lazy { inputLines.map { it.toInt() } }
    private val inputLinesSplitted by lazy {
        inputLines.map {
            it.split(",")
        }
    }

    fun part1(): Any {
        var x = 0
        var y =0
        var a = 0
        inputLines.forEach { lineS->
            var line =lineS.split(' ')

            if (line[0] == "up"){

                  a-=line[1].toInt()


              }
            if (line[0] == "down"){

                a+=line[1].toInt()

            }
            if (line[0] == "forward"){

                x+=line[1].toInt()
                y+=a*line[1].toInt()
            }

        }

        println(x)
        println(y)
        return x*y
    }

    fun part2(): Any {

        return 0
    }
}
