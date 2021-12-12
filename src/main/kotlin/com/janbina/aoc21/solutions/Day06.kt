package com.janbina.aoc20.solutions

import com.janbina.aoc20.utils.Input
import com.janbina.aoc20.utils.copyOf

fun main() {
    val input = Input.getDayInputLines(6)
    Day06(input).also {
        println(it.part1())
        println(it.part2())
    }
}

class Day06(
    private val inputLines: List<String>
) {

    private val inputInts by lazy { inputLines.map { it.toInt() } }
    private val inputLinesSplitted by lazy {
        inputLines.map {
            it.split(",")
        }
    }

    fun part1(): Any {
        var fishes = mutableListOf<Int>()
        inputLinesSplitted.forEach {

            it.forEach {
                fishes.add(it.toInt())
            }
        }
        for (i in 1 .. 80){
            var newList = mutableListOf <Int>()


            fishes.forEachIndexed {ind,fish->


                    if (fish.toInt() == 0){
                        newList.add(6)
                       newList.add(8)
                    }else{
                        newList.add(fish- 1)
                    }
                }


        fishes = newList
        }
        return fishes.size
    }

    fun part2(): Any {
        var list = mutableListOf<Long>()
        for (i in 0 .. 8){
            list.add(0)
        }
        inputLinesSplitted.forEach {
            it.forEach {

                list[it.toInt()] += 1L
            }
        }
        for (i in 1 .. 256){
//            for (b in 0 .. list.size-1){
//                if (b == 0){
//                    list[0]--
//                    list[6]++
//                    list[8]++
//                }else{
//                    list[b]--
//                    list[b-1]++
//                }
//            }
            var newList = list.copyOf()
            list.forEachIndexed { index, i ->

                if (index == 0){

                    newList[6]+=i
                    newList[8]+=i
                    newList[index]-=i
                }else{
                    newList[index-1]+=i
                    newList[index]-=i
                }
            }
            list=newList
        }
        var count = 0L
        list.forEach {
            count += it
        }
        return count

    }

}








