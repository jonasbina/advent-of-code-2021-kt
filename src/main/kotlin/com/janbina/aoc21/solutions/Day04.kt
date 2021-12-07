package com.janbina.aoc20.solutions

import com.janbina.aoc20.utils.Input

fun main() {
    val input = Input.getDayInputLines(4)
    Day04(input).also {
        println(it.part1())
        println(it.part2())
    }
}

class Day04(
    private val inputLines: List<String>
) {

    private val inputInts by lazy { inputLines.map { it.toInt() } }
    private val inputLinesSplitted by lazy {
        inputLines.map {
            it.split(",")
        }
    }

    fun part1(): Any {
//        val cisla = ArrayList<Int>()
//        var tabule = ArrayList<ArrayList<MutableList<String>>>()
//        var newInput = inputLines
        var firstVyherce = ArrayList<MutableList<String>>()
        var cisloPriVyhre = 0
        val cisla = loadInput().numbers
        val tabule = loadInput().board
        var bestTurns = Int.MAX_VALUE
        var scoreOfBest = 0
        tabule.forEach { tabulka->
            val res = GameBoard(tabulka,cisla)
            if (res.turns<bestTurns){
                bestTurns=res.turns
                scoreOfBest = res.score
            }
        }
        return scoreOfBest

    }

    fun part2(): Any {

        return 0
    }


    fun countScore(numbersTillThis:List<Int>,board: ArrayList<MutableList<Int>>):Int{
        var score = 0
            println("NUMS TILL THIS :"+numbersTillThis)
          println("TABULE "+board)
            board.forEach {
                it.forEach {
                    var bool = false
                        numbersTillThis.forEach { num->

                            if (it.toInt() == num){
                            bool=true

                        }}
                      if (!bool)

                          score+=it.toInt()
                    }}



        return score * numbersTillThis[numbersTillThis.lastIndex]

    }
    fun loadInput(): com.janbina.aoc20.solutions.Input {
        val cisla = ArrayList<Int>()
        var tabule = ArrayList<ArrayList<MutableList<Int>>>()
        var newInput = inputLines
        inputLinesSplitted.forEach {
            if (it.size >3){
                it.forEach {
                    cisla.add(it.toInt())
                }
            }
        }
        newInput= inputLines.drop(2)
        var i = 0

        newInput.forEach {
            if (it !=""){
                i++
                var list = mutableListOf<String>()
                list = it.split(' ') as MutableList<String>
                var list2 = mutableListOf<Int>()
                list2 = list as MutableList<Int>
                if (it[0]==' '){
                    list2.drop(1)
                }
                if (i == 1){
                    tabule.add(ArrayList<MutableList<Int>>())
                    tabule[tabule.size-1].add(list2)
                }else{
                    if (i <6){
                        tabule[if (tabule.size < 1){ 0}else{tabule.size-1}].add(list2)
                    }else{
                        tabule.add(ArrayList<MutableList<Int>>())
                        tabule[tabule.size-1].add(list2)
                        i==0
                    }
                }
    }


}
      println("CISLA : "+cisla)
        println("TABULE : "+tabule)
      return Input(numbers = cisla, board = tabule)

    }
    fun GameBoard(board:ArrayList<MutableList<Int>>,numbers: List<Int>):GameResult{
         var numsTillThis = ArrayList<Int>()

        numbers.forEach {
            numsTillThis.add(it)
            if (isBoardWin(numsTillThis,board)){
                return GameResult(numsTillThis.size,countScore(numsTillThis,board));
            }
        }
        return GameResult(Int.MAX_VALUE,0)
    }
    fun isBoardWin(numbersTillThis:List<Int>,board: ArrayList<MutableList<Int>>):Boolean{

        var won = false
        board.forEach {
            var rada = 0
            it.forEachIndexed {ind,num->
                numbersTillThis.forEach {number->
                    if (number == num.toInt()){
                       rada++

                   }
                }

            }
            if (rada == 5){
               won = true
            }

        }
        for (i in 0 .. board.lastIndex) {
            var sloupec = 0
            board.forEach {

                    numbersTillThis.forEach {number->

                        if (number == it[i].toInt()){
                            sloupec++
                        }

                    }


                if (sloupec == 5){
                    won = true
                }

            }
        }
        return won
    }

}
class Input(
    val numbers:List<Int>,
    val board:ArrayList<ArrayList<MutableList<Int>>>

)
class GameResult(
    val turns:Int,
    val score:Int
)
