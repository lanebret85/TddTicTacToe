package org.example.com.example.demo

class GameBoard (var size: Int) {
    fun generateBoard(size: Int): Array<Array<String>> {
        val board: Array<Array<String>> = Array(size) { Array(size) { " " } }

        return board
    }

    fun generateWinConditions(size: Int): List<List<Int>> {
        val lastSpace = size * size
        val range: List<Int> = (1..lastSpace).toList()
        val winConditions: MutableList<List<Int>> = mutableListOf()

        generateRowWinConditions(size, range, winConditions)
        generateColWinCondtions(size, range, winConditions)
        generateCross1WinCondtion(size, range, winConditions)
        generateCross2WinCondition(size, range, winConditions)

        return winConditions
    }

    fun generateRowWinConditions(size: Int, range: List<Int>, winConditions: MutableList<List<Int>>) {
        for (i in 0 until size) {
            val conditions: MutableList<Int> = mutableListOf()
            for (j in 0 until size) {
                conditions += range[j + (i * size)]
            }
            addConditionToWinConditions(winConditions, conditions)
        }
    }

    fun generateColWinCondtions(size: Int, range: List<Int>, winConditions: MutableList<List<Int>>) {
        for (i in 0 until size) {
            val conditions = mutableListOf<Int>()
            for (j in 0 until size) {
                val index = (j * size) + i
                conditions += range[index]
            }
            addConditionToWinConditions(winConditions, conditions)
        }
    }

    fun generateCross1WinCondtion(size: Int, range: List<Int>, winConditions: MutableList<List<Int>>) {
        val condition = mutableListOf<Int>()
        for (i in 0 until size) {
            val index = i * (size + 1)
            condition += range[index]
        }
        addConditionToWinConditions(winConditions, condition)
    }

    fun generateCross2WinCondition(size: Int, range: List<Int>, winConditions: MutableList<List<Int>>) {
        val condition = mutableListOf<Int>()
        for (i in 0 until size) {
            val index = (i * (size - 1)) + (size - 1)
            condition += range[index]
        }
        addConditionToWinConditions(winConditions, condition)
    }

    fun addConditionToWinConditions(winConditions: MutableList<List<Int>>, conditions: MutableList<Int>) {
        winConditions.add(conditions.toList())
        conditions.clear()
    }
}