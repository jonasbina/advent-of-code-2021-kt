package com.janbina.aoc20.solutions

import com.janbina.aoc20.utils.Input

fun main() {
    val input = Input.getDayInputLines(11)
    Day11(input).also {
        println(it.part1())
        println(it.part2())
    }
}

class Day11(
    private val inputLines: List<String>
) {

    private val inputInts by lazy { inputLines.map { it.toInt() } }
    private val inputLinesSplitted by lazy {
        inputLines.map {
            it.split(",")
        }
    }

    fun part1(): Any {
        var flashes = 0
        var mutableList = mutableListOf<MutableList<Int>>()
        inputLines.forEachIndexed { index, s ->
            mutableList.add(mutableListOf())
                s.forEach {
                    mutableList.get(index).add(it.toInt()-'0'.toInt())
                }
        }

        println(mutableList)
        for (day in 0 .. 100){

            var newList = mutableList

            mutableList.forEachIndexed {index ,intek->

                intek.forEachIndexed { ind,int->


                    newList.get(index).set(ind,int+1)

                }


        }
            var flashesOnIndex = mutableListOf<MutableList<Int>>()
            mutableList = newList
            mutableList.forEachIndexed { index, ints ->
                flashesOnIndex.add(mutableListOf())
                ints.forEachIndexed{ind,int->
                    if (int == 9){
                        newList.get(index).set(ind,0)
                        flashesOnIndex.get(index).add(ind)
                    }
                }
            }
            mutableList = newList
            flashesOnIndex.forEachIndexed { index,radek->
                radek.forEachIndexed { index, i ->
                    if (i<mutableList.get(index).lastIndex){
                        if (i!=0){
                        if (index<mutableList.lastIndex){
                            if (index!=0) {
                                newList.get(index + 1).set(i - 1, newList.get(index + 1).get(i) + 1)
                                newList.get(index + 1).set(i + 1, newList.get(index + 1).get(i) + 1)
                                newList.get(index + 1).set(i, newList.get(index + 1).get(i) + 1)
                                newList.get(index - 1).set(i - 1, newList.get(index + 1).get(i) + 1)
                                newList.get(index - 1).set(i + 1, newList.get(index + 1).get(i) + 1)
                                newList.get(index - 1).set(i, newList.get(index + 1).get(i) + 1)
                                newList.get(index).set(i - 1, newList.get(index + 1).get(i) + 1)
                                newList.get(index).set(i + 1, newList.get(index + 1).get(i) + 1)
                            }else{
                                newList.get(index + 1).set(i - 1, newList.get(index + 1).get(i) + 1)
                                newList.get(index + 1).set(i + 1, newList.get(index + 1).get(i) + 1)
                                newList.get(index + 1).set(i, newList.get(index + 1).get(i) + 1)
                                newList.get(index).set(i - 1, newList.get(index + 1).get(i) + 1)
                                newList.get(index).set(i + 1, newList.get(index + 1).get(i) + 1)
                            }
                        }else{

                            newList.get(index - 1).set(i - 1, newList.get(index + 1).get(i) + 1)
                            newList.get(index - 1).set(i + 1, newList.get(index + 1).get(i) + 1)
                            newList.get(index - 1).set(i, newList.get(index + 1).get(i) + 1)
                            newList.get(index).set(i - 1, newList.get(index + 1).get(i) + 1)
                            newList.get(index).set(i + 1, newList.get(index + 1).get(i) + 1)
                        }
                        }else{
                            if (index<mutableList.lastIndex){
                                if (index!=0) {
                                    newList.get(index + 1).set(i - 1, newList.get(index + 1).get(i) + 1)
                                    newList.get(index + 1).set(i + 1, newList.get(index + 1).get(i) + 1)
                                    newList.get(index + 1).set(i, newList.get(index + 1).get(i) + 1)

                                    newList.get(index).set(i - 1, newList.get(index + 1).get(i) + 1)
                                    newList.get(index).set(i + 1, newList.get(index + 1).get(i) + 1)
                                }else{

                                    newList.get(index + 1).set(i + 1, newList.get(index + 1).get(i) + 1)
                                    newList.get(index + 1).set(i, newList.get(index + 1).get(i) + 1)

                                    newList.get(index).set(i + 1, newList.get(index + 1).get(i) + 1)
                                }
                            }else{


                                newList.get(index).set(i - 1, newList.get(index + 1).get(i) + 1)
                                newList.get(index).set(i + 1, newList.get(index + 1).get(i) + 1)
                            }
                        }
                    }else{
                        if (i!=0){
                            if (index<mutableList.lastIndex){
                                if (index!=0) {

                                    newList.get(index - 1).set(i - 1, newList.get(index + 1).get(i) + 1)

                                    newList.get(index - 1).set(i, newList.get(index + 1).get(i) + 1)
                                    newList.get(index).set(i - 1, newList.get(index + 1).get(i) + 1)

                                }else{

                                    newList.get(index).set(i - 1, newList.get(index + 1).get(i) + 1)

                                }
                            }else{

                                newList.get(index - 1).set(i - 1, newList.get(index + 1).get(i) + 1)
                                newList.get(index - 1).set(i + 1, newList.get(index + 1).get(i) + 1)
                                newList.get(index - 1).set(i, newList.get(index + 1).get(i) + 1)
                                newList.get(index).set(i - 1, newList.get(index + 1).get(i) + 1)
                                newList.get(index).set(i + 1, newList.get(index + 1).get(i) + 1)
                            }
                        }else{
                            if (index<mutableList.lastIndex){
                                if (index!=0) {


                                    newList.get(index).set(i - 1, newList.get(index + 1).get(i) + 1)
                                    newList.get(index).set(i + 1, newList.get(index + 1).get(i) + 1)
                                }else{

                                    newList.get(index).set(i - 1, newList.get(index + 1).get(i) + 1)
                                    newList.get(index).set(i + 1, newList.get(index + 1).get(i) + 1)
                                }
                            }else{


                                newList.get(index).set(i - 1, newList.get(index + 1).get(i) + 1)
                                newList.get(index).set(i + 1, newList.get(index + 1).get(i) + 1)
                            }
                        }
                    }

                }


            }


    }
        return flashes
    }

    fun part2(): Any {

        return 0
    }
}

