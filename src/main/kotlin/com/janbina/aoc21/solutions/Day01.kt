package com.janbina.aoc20.solutions

import com.janbina.aoc20.utils.Input

fun main() {
    val input = Input.getDayInputLines(1)
    Day01(input).also {
        println(it.part1())
        println(it.part2())
    }
}

class Day01(
    private val inputLines: List<String>
) {

    private val inputInts by lazy { inputLines.map { it.toInt() } }
    private val inputLinesSplitted by lazy {
        inputLines.map {
            it.split(",")
        }
    }

    fun part1(): Any {
        var result = 0
        var last = 0
        inputInts.forEach {cislo->
            if (last!=0){
            if (last<cislo){
                result+=1
            }
            }
            last = cislo
        }
        return result
    }

    fun part2(): Any {
        var result = 0
        var i = 0
        var list = ArrayList<Int>()
        for (i in 0 .. inputInts.lastIndex){
            if (inputInts.lastIndex-i==1){
                list.add(inputInts[i]+inputInts[i+1])
            }else {
                if (inputInts.lastIndex-i==0){


                list.add(inputInts[i])
                }else{
                    list.add(inputInts[i]+inputInts[i+1]+inputInts[i+2])
                }
            }
        }
        var previous = 0;
        list.forEach { num->
            if (previous!=0){
                if (num>previous){
                    result++
                }

            }
            previous=num
        }
        return result
    }
}
