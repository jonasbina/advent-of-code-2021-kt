package com.janbina.aoc20.solutions

import com.janbina.aoc20.utils.Input
import kotlin.math.cos

fun main() {
    val input = Input.getDayInputLines(7)
    Day07(input).also {
        println(it.part1())
        println(it.part2())
    }
}

class Day07(
    private val inputLines: List<String>
) {

    private val inputInts by lazy { inputLines.map { it.toInt() } }
    private val inputLinesSplitted by lazy {
        inputLines.map {
            it.split(",")
        }
    }

    fun part1(): Any {
        var maxNum = 0
        var bestHeight=Int.MAX_VALUE
        var bestCost = Int.MAX_VALUE
        inputLinesSplitted.forEach {
            it.forEach {
                if (it.toInt() > maxNum){
                    maxNum= it.toInt()
                }
            }
        }
        for (i in 0 .. maxNum){
            var cost = 0
            inputLinesSplitted.forEach { line->
                line.forEach { crab->
                    if (crab.toInt() > i){
                        cost+=crab.toInt()-i
                    }else{
                        cost+=i-crab.toInt()
                    }
                }
            }
            if (cost<bestCost){
                bestHeight=i
                bestCost=cost
            }
        }
        return bestCost
    }

    fun part2(): Any {
        var maxNum = 0
        var bestHeight=Int.MAX_VALUE
        var bestCost = Int.MAX_VALUE
        inputLinesSplitted.forEach {
            it.forEach {
                if (it.toInt() > maxNum){
                    maxNum= it.toInt()
                }
            }
        }
        for (i in 0 .. maxNum){
            var cost = 0
            inputLinesSplitted.forEach { line->
                line.forEach { crab->
                    if (crab.toInt() > i){
                        cost+=move(crab.toInt()-i)
                    }else{
                        cost+=move(i-crab.toInt())
                    }
                }
            }
            if (cost<bestCost){
                bestHeight=i
                bestCost=cost
            }
        }
        return bestCost
    }
    fun move(num:Int):Int{
        var moveBy = 0

        for (i in 1 .. num){
            moveBy+=i
        }

        return moveBy
    }
}
