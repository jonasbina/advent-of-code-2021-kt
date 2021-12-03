package com.janbina.aoc20.solutions

import com.janbina.aoc20.utils.Input

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
        var list = IntArray(inputLines.first().length)
        inputLines.forEach { line->
            line.forEachIndexed {i,c->
                if (c.toInt() == 1){
                    list[i]++
                }
            }
        }
        var g = ""
        var e = ""
        list.forEach {
            if (it-inputLines.size < it){
                g+='1'
                e+='0'
            }else{
                g+='0'
                e+='1'
            }

        }
        var gnum = g.toInt(2)
        var enum = e.toInt(2)


        return 0
    }




    fun part2(): Any {

        return 0
    }
//    var list = ArrayList< ArrayList<Int>>();
//    inputLines.forEach {
//        it.forEachIndexed { index,c->
//            if (list.lastIndex >= index){
//                list[index].add(c.toInt())
//            }else{
//                list.add(ArrayList<Int>())
//                list[index].add(c.toInt())
//            }
//        }
//    }

//    var zero= 0
//    var one= 0
//    list.forEach {
//        it.forEach{
//            if (it == 48){
//                zero++
//            }else{
//                one++
//            }
//        }
//    }
//    if (zero>one){
//        grate = (grate.toString() +  z.toString()).toInt()
//    }else{
//        grate = (grate.toString() +  j.toString()).toInt()
//
//    }
//    zero = 0
//    one = 0
//
//    grate.toString().forEach {
//        if (it.toInt() == 0){
//            erate = (erate.toString() +  j.toString()).toInt()
//        }else{
//            erate = (erate.toString() +  z.toString()).toInt()
//        }
//    }
}