package com.janbina.aoc20.solutions

import com.janbina.aoc20.utils.Input

fun main() {
    val input = Input.getDayInputLines(10)
    Day10(input).also {
        println(it.part1())
        println(it.part2())
    }
}

class Day10(
    private val inputLines: List<String>
) {

    private val inputInts by lazy { inputLines.map { it.toInt() } }
    private val inputLinesSplitted by lazy {
        inputLines.map {
            it.split(",")
        }
    }

    fun part1(): Any {

        var score = 0
        inputLines.forEach {line->
            var list = ArrayList<String>()
            var corrupted = false
            var firstCorrupted = Int.MAX_VALUE
        line.forEachIndexed {ind,it->
            if (isOteviraciZavorka(it)){
                list.add(it.toString())
            }else{
                if (toZaviraciZavorka(list[list.lastIndex][0]) != it){
                    corrupted=true
                    if (firstCorrupted >  ind){
                        firstCorrupted=ind
                    }

                }else{
                    list.removeAt(list.lastIndex)
                }
            }
        }
            if (corrupted){
                if (line[firstCorrupted] == '>'){
                    score+=25137
                }
                if (line[firstCorrupted] == '}'){
                    score+=1197
                }
                if (line[firstCorrupted] == ')'){
                    score+=3
                }
                if (line[firstCorrupted] == ']'){
                    score+=57
                }
            }

        }



        return score
    }

    fun part2(): Any {



        var scoreList = ArrayList<Long>()
        inputLines.forEach {line->
            var list = ArrayList<String>()
            var score = 0L
            var corrupted = false
            var firstCorrupted = Int.MAX_VALUE
            line.forEachIndexed {ind,it->
                if (isOteviraciZavorka(it)){
                    list.add(it.toString())
                }else{
                    if (toZaviraciZavorka(list[list.lastIndex][0]) != it){
                        corrupted=true
                        if (firstCorrupted >  ind){
                            firstCorrupted=ind
                        }

                    }else{
                        list.removeAt(list.lastIndex)
                    }
                }
            }
            if(!corrupted){
            println(list)
            list.asReversed().forEach {
                if (it == "{"){
                    println(score.toString()+"*5+3")
                    score *=5
                    score+=3
                }
                if (it == "("){
                    println(score.toString()+"*5+1")
                    score *=5
                    score+=1
                }
                if (it == "["){
                    println(score.toString()+"*5+2")
                    score *=5
                    score+=2

                }
                if (it == "<"){
                    println(score.toString()+"*5+4")
                    score *=5
                    score+=4
                }
            }
            scoreList.add(score)
        }
        }



        return scoreList.sorted()[scoreList.size/2]
    }




    fun isOteviraciZavorka(char:Char):Boolean{
        if (char == '{'||char=='['||char=='<'||char=='('){
            return true
        }else{
            return false
        }

    }
    fun toZaviraciZavorka(char: Char):Char{
        if (char == '<'){
          return '>'
        }
        if (char == '('){
            return ')'
        }
        if (char == '{'){
            return '}'
        }
        if (char == '['){
            return ']'
        }
        return 'd'

    }
}

