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
        var filtered = inputLines
        for (i in 0 .. filtered.first().lastIndex){
            var num = 0
            filtered.forEach {
                if (it[i] == '1'){
                    num++
                }else{
                    num--
                }

            }

            val filteredNew = if (num >= 0){
                //vic 1
                filtered.filter { it[i]=='1' }
            }else{
                filtered.filter { it[i]=='0' }
            }
            filtered = filteredNew
        }

        val oxygen = filtered[0]
        filtered = inputLines
        for (i in 0 .. filtered.first().lastIndex){
            var num = 0
            filtered.forEach {
                if (it[i] == '1'){
                    num--
                }else{
                    num++
                }

            }

            val filteredNew = if (num.absoluteValue==filtered.size){filtered}else if(num <= 0){
                //vic 1
                filtered.filter { it[i]=='0' }
            }else{
                filtered.filter { it[i]=='1' }
            }
            filtered = filteredNew
        }


        val co2 = filtered[0]

        val co2I = co2.toInt(2)
        val oxygenI = oxygen.toInt(2)


        return oxygenI*co2I
    }
}