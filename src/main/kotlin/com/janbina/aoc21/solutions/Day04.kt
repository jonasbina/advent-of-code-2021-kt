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


        cisla.forEach {
            tabule.forEach { tabulka->
                tabulka.forEach { radek->
                    radek.forEachIndexed { ind,cislo->
                        if (cislo !=""){
                            println("Cislo na spotu:"+cislo+" CISLO MOMENTALNI:"+it)
                            if (cislo.split('*').size!= 1){
                            if (
                                cislo.toInt() == it
                            ){
                            radek[ind] = "*"+cislo
                            if (vyhral(radek,tabulka)){
                                if (firstVyherce.isNotEmpty()){
                                    firstVyherce = tabulka
                                    cisloPriVyhre = it
                                }
                            }
                            }
                        }
                    }
                    }
                }
            }
        }
         return countScore(firstVyherce,cisloPriVyhre)
    }

    fun part2(): Any {

        return 0
    }
    fun vyhral(radek:MutableList<String>,tabulka : ArrayList<MutableList<String>>):Boolean{
        var bool = false
        var pocetVRadku=0
        radek.forEach{cislo->
            if (cislo.split('*').isNotEmpty()){
                pocetVRadku++
            }
        }
        if (pocetVRadku == 5){
            bool = true
        }

        return bool
    }
    fun countScore(tabulka:ArrayList<MutableList<String>>,cisloPriBingu : Int):Int{
        var sum = 0
        tabulka.forEach {
            it.forEach { cislo->
                if (cislo.split('*').isEmpty()){
                    sum+=cislo.toInt()
                }
            }
        }
        return sum*cisloPriBingu
    }
    fun loadInput(): com.janbina.aoc20.solutions.Input {
        val cisla = ArrayList<Int>()
        var tabule = ArrayList<ArrayList<MutableList<String>>>()
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
                if (it[0]==' '){
                    list.drop(1)
                }
                if (i == 1){
                    tabule.add(ArrayList<MutableList<String>>())
                    tabule[tabule.size-1].add(list)
                }else{
                    if (i <6){
                        tabule[if (tabule.size < 1){ 0}else{tabule.size-1}].add(list)
                    }else{
                        tabule.add(ArrayList<MutableList<String>>())
                        tabule[tabule.size-1].add(list)
                        i==0
                    }
                }
    }


}

      return Input(numbers = cisla, board = tabule)
    }

}
class Input(
    val numbers:List<Int>,
    val board:ArrayList<ArrayList<MutableList<String>>>

)
