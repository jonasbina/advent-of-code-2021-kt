package com.janbina.aoc20.solutions

import com.janbina.aoc20.utils.Input
import kotlin.math.absoluteValue

fun main() {
    val input = Input.getDayInputLines(3)
    Day03(input).also {
        println(it.part1())
        println(it.part2())
    }
}

class Day03(
    private val inputLines: List<String>
) {

    private val inputInts by lazy { inputLines.map { it.toInt() } }
    private val inputLinesSplitted by lazy {
        inputLines.map {
            it.split(",")
        }
    }

    fun part1(): Any {
        val list = IntArray(inputLines.first().length)
        inputLines.forEach { line->
            line.forEachIndexed {i,c->
                if (c == '1'){
                    list[i]++
                }
            }
        }
        var g = ""
        var e = ""
        list.forEach {

            if (it> inputLines.size/2){
                g+='1'
                e+='0'
            }else{
                g+='0'
                e+='1'
            }

        }

        val gnum = g.toInt(2)
        val enum = e.toInt(2)


        return gnum*enum
    }




    fun part2(): Any {


        val oxygen = filter(false)

        val co2 = filter(true)

        val co2I = co2.toInt(2)
        val oxygenI = oxygen.toInt(2)


        return oxygenI*co2I
    }
    fun filter(leastcommon : Boolean):String{
        var filtered = inputLines
        for (i in 0 .. filtered.first().lastIndex){
            var numberOfOnes = 0
            filtered.forEach {
                if (it[i] == '1'){
                    numberOfOnes++
                }

            }

            val numOfZeros = filtered.size-numberOfOnes

                    filtered = if (numberOfOnes == 0||numOfZeros==0){
                filtered
            } else if(numberOfOnes>=numOfZeros){
                if (leastcommon){
                    filtered.filter { it[i]=='0' }
                }else{
                    filtered.filter { it[i]=='1' }
                }

            } else{
                if (leastcommon){
                    filtered.filter { it[i]=='1' }
                }else{
                    filtered.filter { it[i]=='0' }
                }
            }

        }

        return filtered[0]

    }
}